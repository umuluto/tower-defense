/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulto.game.fxml;

import com.ulto.game.Game;
import com.ulto.game.GameController;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ulto
 */
public class GameWindow extends BorderPane {

    @FXML
    private Canvas background;
    @FXML
    private Canvas foreground;
    @FXML
    private Text health;
    @FXML
    private Text gold;
    @FXML
    private Button nm_tower_button;
    @FXML
    private Button mg_tower_button;
    @FXML
    private Button sp_button;
    @FXML
    private Button sell_button;
    @FXML
    private Button pause_button;
    
    private String towerType;
    
    private Game game;
    
    private GameController controller;

    public GameWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameWindow.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public GameWindow(Game game) {
        this();
        this.game = game;
        foreground.setDisable(true);
    }

    @FXML
    private void onNormalBuild(ActionEvent event) {
        towerType = "nt";
        toggleForegroundClick();
    }

    @FXML
    private void onMachineGunBuild(ActionEvent event) {
    }

    @FXML
    private void onSniperBuild(ActionEvent event) {
    }

    @FXML
    private void onSell(ActionEvent event) {
    }

    @FXML
    private void onPause(ActionEvent event) {
        controller.stop();
    }
    
    @FXML
    private void onForegroundClick(MouseEvent e) {
        controller.onBuildRequest(towerType, e.getX(), e.getY());
    }
    
    public void setController(GameController controller) {
        this.controller = controller;
    }
    
    public GraphicsContext getBackgroundContext() {
        return background.getGraphicsContext2D();
    }
    
    public GraphicsContext getForegroundContext() {
        return foreground.getGraphicsContext2D();
    }
    
    private void toggleForegroundClick() {
        foreground.setDisable(!foreground.isDisable());
    }
}
