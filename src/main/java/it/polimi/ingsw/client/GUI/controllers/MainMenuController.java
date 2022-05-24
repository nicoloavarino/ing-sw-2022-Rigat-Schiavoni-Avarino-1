package it.polimi.ingsw.client.GUI.controllers;

import it.polimi.ingsw.client.ClientAppGUI;
import it.polimi.ingsw.client.GUI.ClientGUI;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.concurrent.TimeUnit;

public class MainMenuController {

    private ClientAppGUI gui;

    @FXML private TextField ip;
    @FXML private TextField port;

    @FXML
    protected void onButtonClick() {

        ClientGUI clientGUI = new ClientGUI(ip.getText(), Integer.parseInt(port.getText()), gui); //192.168.100.10
        Thread clientThread = new Thread(clientGUI);
        clientThread.start();
        gui.setClientGUI(clientGUI);

    }

    public void clearIpPort() {
        this.ip.clear();
        this.port.clear();
    }

    public void setGui(ClientAppGUI gui) {
        this.gui = gui;
    }
}