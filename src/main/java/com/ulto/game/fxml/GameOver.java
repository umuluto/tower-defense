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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ulto
 */
public class GameOver extends VBox {

    @FXML
    private Button exit_button;
    
    private GameWindow gameWindow;
    
    public GameOver() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameOver.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public GameOver(GameWindow gameWindow) {
        this();
        this.gameWindow = gameWindow;
    }

    @FXML
    private void exitGame(ActionEvent event) {
        gameWindow.toMainMenu();
    }
    
}
