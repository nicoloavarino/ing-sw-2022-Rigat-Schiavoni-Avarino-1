package it.polimi.ingsw.client.GUI;

import it.polimi.ingsw.client.ClientAppGUI;
import it.polimi.ingsw.exceptions.ConnectionClosedException;
import it.polimi.ingsw.model.Model;
import javafx.application.Platform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;

public class ClientGUI implements Runnable {

    private String ip;
    private Integer port;

    private ObjectOutputStream socketOut;

    private ClientAppGUI gui;

    private String nickname = "";

    private boolean connectionEstablished = false;
    private boolean loading = false;
    private boolean firstPlayer = false;
    private boolean startgame = false;

    public ClientGUI(String ip, int port, ClientAppGUI gui){
        this.ip = ip;
        this.port = port;
        this.gui = gui;
    }

    private boolean active = true;

    public void setNickname(String nickname) {
        asyncWriteToSocket(nickname);
        this.nickname = nickname;
        System.out.println("Set: " + this.nickname);
    }

    public boolean isLoading() {
        return loading;
    }

    public boolean isFirstPlayer() {
        return firstPlayer;
    }

    public boolean isStartgame() {
        return startgame;
    }

    public boolean isConnectionEstablished() {
        return connectionEstablished;
    }

    public synchronized boolean isActive(){
        return active;
    }

    public synchronized void setActive(boolean active){
        this.active = active;
    }

    // asyncReadFromSocket

    public Thread asyncReadFromSocket(final ObjectInputStream socketIn, final ObjectOutputStream socketOut){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isActive()) {
                        Object inputObject = socketIn.readObject();
                        if(inputObject instanceof String){
                            System.out.println((String) inputObject);
                            if (((String) inputObject).contains("Write a valid name!") || ((String) inputObject).contains("Another player already chosen this nickname")){
                                Platform.runLater(()-> gui.getNicknameController().clearNickname());
                            }
                            else if (((String) inputObject).contains("How many players?")){
                                Platform.runLater(()-> gui.changeStage("FirstPlayer"));
                            }
                            else if (((String) inputObject).contains("please wait the beginning of the game") || ((String) inputObject).contains("Waiting for another player")){
                                if(!gui.getCurrentFXML().equals("Loading"))
                                    Platform.runLater(()-> gui.changeStage("Loading"));
                            }
                            else if (((String) inputObject).contains("opponent")){
                                Platform.runLater(()-> gui.changeStage("GameBoard"));
                            }
                        } else if (inputObject instanceof Model){
                            ((Model)inputObject).print(nickname);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                } catch (Exception e){
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }

    public Thread asyncWriteToSocket(String message){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (ip){
                        socketOut.writeObject(message);
                        socketOut.flush();
                    }
                }catch(Exception e){
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(ip, port);
            Platform.runLater(()-> gui.changeStage("Nickname"));
            connectionEstablished = true;
            System.out.println("Connection established");

            ObjectOutputStream socketOut = new ObjectOutputStream(socket.getOutputStream());
            this.socketOut = socketOut;
            ObjectInputStream socketIn = new ObjectInputStream(socket.getInputStream());

            try{
                Thread t0 = asyncReadFromSocket(socketIn, socketOut);

                t0.join();
                System.in.close();
                System.out.println("Connection closed!");

            } catch(InterruptedException | NoSuchElementException | ConnectionClosedException e){
                System.out.println("Connection closed from the client side");
            } finally {
                socketIn.close();
                socketOut.close();
                socket.close();
            }
        } catch (IOException e) {
            Platform.runLater(()-> gui.getMainMenuController().clearIpPort());
            throw new RuntimeException(e);
        }

    }
}


