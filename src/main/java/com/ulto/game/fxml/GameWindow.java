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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
    private StackPane canvasStack;
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
    @FXML
    private VBox sidebar;
    
    private String towerType;
    
    private Game game;
    
    private GameController controller;

    private boolean selling = false;

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
        towerType = "NormalTower";
        foreground.setDisable(false);
    }

    @FXML
    private void onMachineGunBuild(ActionEvent event) {
        towerType = "MachineGunTower";
        foreground.setDisable(false);
    }

    @FXML
    private void onSniperBuild(ActionEvent event) {
        towerType = "SniperTower";
        foreground.setDisable(false);
    }

    @FXML
    private void onSell(ActionEvent event) {
        selling = true;
        foreground.setDisable(false);
    }

    @FXML
    private void onPause(ActionEvent event) {
        sidebar.setDisable(true);
        foreground.setDisable(true);
        canvasStack.getChildren().add(new PauseMenu(this));
        controller.stop();
    }
    
    @FXML
    private void onForegroundClick(MouseEvent e) {
        if (!selling)
            controller.onBuildRequest(towerType, e.getX(), e.getY());
        else {
            controller.onSellRequest(e.getX(), e.getY());
            selling = false;
        }
        foreground.setDisable(true);
    }
    
    public void toMainMenu() {
        game.toMainMenu();
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
    
    public void setHealth(int health) {
        String text = String.valueOf(health);
        this.health.setText(text);
    }
    
    public void setGold(int gold) {
        String text = String.valueOf(gold);
        this.gold.setText(text);
    }
    
    public void resumeGame() {
        canvasStack.getChildren().remove(2);
        sidebar.setDisable(false);
        foreground.setDisable(false);
        controller.start();
    }
    
    public void gameOver() {
        sidebar.setDisable(true);
        foreground.setDisable(true);
        canvasStack.getChildren().add(new GameOver(this));
        controller.stop();
    }
}
