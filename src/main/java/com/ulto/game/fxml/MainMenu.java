/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulto.game.fxml;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import com.ulto.game.Game;
import javafx.application.Platform;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

/**
 * FXML Controller class
 *
 * @author ulto
 */
public class MainMenu extends StackPane {

    @FXML
    private Button start_button;
    @FXML
    private Button load_button;
    @FXML
    private Button exit_button;

    private Game game;

    private static MediaPlayer player;

    public MainMenu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainMenu.fxml"));
        loader.setRoot(this);
        loader.setController(this);


        //play 999 cycle start games
        String path = "/tower/sound/bg.mp3";
        Media media = new Media(getClass().getResource("/tower/sound/bg.mp3").toString());
        player = new MediaPlayer(media);
        player.setCycleCount(999);
        player.play();

        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public MainMenu(Game game) {
        this();
        this.game = game;

        //play 999 cycle start games
        String path = "/tower/sound/bg.mp3";
        Media media = new Media(getClass().getResource("/tower/sound/bg.mp3").toString());
        player = new MediaPlayer(media);
        player.setCycleCount(999);
        player.play();

    }

    @FXML
    private void startGame(ActionEvent event) {
        game.toLevelSelect();
        player.stop();
    }

    @FXML
    private void loadGame(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) throws Exception {
        Platform.exit();
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
