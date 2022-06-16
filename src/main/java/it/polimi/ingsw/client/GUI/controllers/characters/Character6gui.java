package it.polimi.ingsw.client.GUI.controllers.characters;

import it.polimi.ingsw.client.ClientAppGUI;
import it.polimi.ingsw.model.Model;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Character6gui implements Character{
    private ClientAppGUI gui;
    private Stage dialog;
    private Model model;
    private int cardPosition;

    @FXML
    private Label effect;

    @FXML
    protected void onButtonClick() {
        //effect.setText("hai giocato questa carta!");
        Platform.runLater(()-> gui.getClientGUI().asyncWriteToSocket("100,6"));
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
