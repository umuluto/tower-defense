package com.ulto.game;

import javafx.application.Application;
import javafx.stage.Stage;

public final class Game extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GameContainer container = new GameContainer(this, "/level1.txt");
        stage.setScene(container.getScene());
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
