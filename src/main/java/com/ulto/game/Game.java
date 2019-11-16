package com.ulto.game;

import com.ulto.game.fxml.LevelSelect;
import com.ulto.game.fxml.MainMenu;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public final class Game extends Application {
    private Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(new Scene(new MainMenu(this)));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void toLevelSelect() {
        LevelSelect root = new LevelSelect(this);
        Scene scene = new Scene(root);
        setScene(scene);
    }
    
    public void toMainMenu() {
        MainMenu root = new MainMenu(this);
        Scene scene = new Scene(root);
        setScene(scene);
    }
    
    public void setScene(Scene scene) {
        stage.setScene(scene);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2); 
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);  
    }
}
