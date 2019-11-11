package com.ulto.game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public final class Game extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Canvas background = new Canvas(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        Canvas foreground = new Canvas(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        GraphicsContext gcBackground = background.getGraphicsContext2D();
        GraphicsContext gcForeground = foreground.getGraphicsContext2D();

        String name = "/level1.txt";
        GameController controller = new GameController(name, gcBackground, gcForeground);

        Group root = new Group();
        root.getChildren().addAll(background, foreground);

        Scene scene = new Scene(root, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        stage.setScene(scene);
        stage.show();
        controller.start();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
