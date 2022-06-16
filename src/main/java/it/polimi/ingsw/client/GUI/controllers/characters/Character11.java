package it.polimi.ingsw.client.GUI.controllers.characters;

import it.polimi.ingsw.client.ClientAppGUI;
import it.polimi.ingsw.model.Model;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Character11 implements Character{

    private ClientAppGUI gui;
    private Stage dialog;
    private Model model;
    private int cardPosition;

    @FXML private Label effect;

    @FXML
    protected void onButtonClick() {
        effect.setText("ancora da implementare");
        //Platform.runLater(()-> gui.getClientGUI().asyncWriteToSocket("100,11"));
    }

    @Override
    public void setGui(ClientAppGUI gui, Stage dialog) {
        this.gui = gui;
        this.dialog = dialog;
    }

    @Override
    public void setModel(Model model, int cardPosition) {

    }

}