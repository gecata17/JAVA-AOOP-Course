package com.example.newgametest;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

import game.*;

public class HelloController {
    EuchreGame game;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnKozove;

    @FXML
    private Button btnKozove2;

    @FXML
    private Button btnKrai;

    @FXML
    private Button btnTegli;

    @FXML
    private Label lblKoz;

    @FXML
    private Label lblTochki;

    @FXML
    private TextArea txtDolu;

    @FXML
    private TextArea txtGore;

    @FXML
    void btnKozove2OnActionHandler(ActionEvent event) {
        boolean hasTrump = game.hasJackANDAceTrump();
        txtDolu.appendText("В изтеглената ръка " + (hasTrump ? "има" : "няма") + " Jack и Ace от Коз цвят\n");
    }

    @FXML
    void btnKozoveOnActionHandler(ActionEvent event) {
        boolean hasTrump = game.hasJackQueenKingTrump();
        txtDolu.appendText("В изтеглената ръка " + (hasTrump ? "има" : "няма") + " Jack, Queen и King от Коз цвят\n");
    }

    @FXML
    void btnKraiOnActionHandler(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnTegliOnActionHandler(ActionEvent event) {
        txtDolu.clear();
        txtGore.clear();
        game.dealHand();
        txtGore.setText(game.printCards());
        lblTochki.setText("Точки: " + Integer.toString(game.countHandStrength()));
    }

    @FXML
    void initialize() {
        assert btnKozove != null : "fx:id=\"btnKozove\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnKozove2 != null : "fx:id=\"btnKozove2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnKrai != null : "fx:id=\"btnKrai\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnTegli != null : "fx:id=\"btnTegli\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblKoz != null : "fx:id=\"lblKoz\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblTochki != null : "fx:id=\"lblTochki\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtDolu != null : "fx:id=\"txtDolu\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtGore != null : "fx:id=\"txtGore\" was not injected: check your FXML file 'hello-view.fxml'.";

        game = new EuchreGame();
        game.shuffleCards();

        lblKoz.setText("Коз: " + game.getTRUMP());
    }

}
