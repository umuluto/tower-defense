/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulto.game.fxml;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import com.ulto.game.Game;
import javafx.application.Platform;

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

    public MainMenu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainMenu.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public MainMenu(Game game) {
        this();
        this.game = game;
    }
    
    @FXML
    private void startGame(ActionEvent event) {
        game.toLevelSelect();
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
