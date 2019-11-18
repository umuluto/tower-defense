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
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author ulto
 */
public class PauseMenu extends HBox {

    @FXML
    private Button resume_button;
    @FXML
    private Button save_button;
    @FXML
    private Button exit_button;
    
    private GameWindow gameWindow;

    public PauseMenu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PauseMenu.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public PauseMenu(GameWindow gameWindow) {
        this();
        this.gameWindow = gameWindow;
    }

    @FXML
    private void resumeGame(ActionEvent event) {
        gameWindow.resumeGame();
    }

    @FXML
    private void saveGame(ActionEvent event) {
    }

    @FXML
    private void exitGame(ActionEvent event) {
        gameWindow.toMainMenu();
    }
    
}
