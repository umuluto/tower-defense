/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulto.game.fxml;

import com.ulto.game.Game;
import com.ulto.game.GameController;
import com.ulto.game.entity.drawer.Drawer;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author ulto
 */
public class LevelSelect extends BorderPane {

    @FXML
    private Button menu_button;
    @FXML
    private Button lvl1_button;
    @FXML
    private Button lvl2_button;
    @FXML
    private Button lvl3_button;
    @FXML
    private Button lvl4_button;
    
    private Game game;

    public LevelSelect() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LevelSelect.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public LevelSelect(Game game) {
        this();
        this.game = game;
    }
    
    @FXML
    private void startLevel1(ActionEvent event) {
        game.setScene(startLevel("/map/level1.txt"));
    }

    @FXML
    private void startLevel2(ActionEvent event) {
        game.setScene(startLevel("/map/level2.txt"));
    }

    @FXML
    private void startLevel3(ActionEvent event) {
        game.setScene(startLevel("/map/level3.txt"));
    }

    @FXML
    private void startLevel4(ActionEvent event) {
        game.setScene(startLevel("/map/level4.txt"));
    }
    
    public void setGame(Game game) {
        this.game = game;
    }

    @FXML
    private void toMainMenu(ActionEvent event) {
        game.toMainMenu();
    }
    
    private Scene startLevel(String name) {
        GameWindow gameWindow = new GameWindow(game);
        Drawer.setGraphicsContexts(gameWindow.getBackgroundContext(), gameWindow.getForegroundContext());
        
        GameController controller = new GameController(name);
        
        gameWindow.setController(controller);
        controller.setGameWindow(gameWindow);
        
        controller.start();
        
        return new Scene(gameWindow);
    }
}