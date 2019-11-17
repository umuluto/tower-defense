package com.ulto.game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameContainer {
    private Scene scene;

    private BorderPane borderPane;
    private StackPane uiStackPane;
    private StackPane canvasStackPane;

    private VBox sidebar;

    private GameController controller;

    private String nextSpawn;
    private boolean paused = false;

    private Button pauseButton = new Button("Pause/Resume");
    private Button normalTowerButton = new Button("Normal Tower");
    private Button machineGunTowerButton = new Button("Machine Gun Tower");
    private Button sniperTowerButton = new Button("Sniper Tower");

    private Canvas backgroundCanvas = new Canvas(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    private Canvas foregroundCanvas = new Canvas(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

    private GraphicsContext backgroundContext = backgroundCanvas.getGraphicsContext2D();
    private GraphicsContext foregroundContext = foregroundCanvas.getGraphicsContext2D();

    public GameContainer(Application game, String name) {
        canvasStackPane = new StackPane(backgroundCanvas, foregroundCanvas);
        borderPane = new BorderPane(canvasStackPane);

        sidebar = new VBox(pauseButton, normalTowerButton, machineGunTowerButton, sniperTowerButton);
        Insets insets = new Insets(30);
        sidebar.setPadding(insets);
        sidebar.setAlignment(Pos.CENTER);
        sidebar.setSpacing(30);
        borderPane.setRight(sidebar);

        uiStackPane = new StackPane(borderPane);
        scene = new Scene(uiStackPane);

        controller = new GameController(name, backgroundContext, foregroundContext);
        pauseButton.setOnAction(e -> {
            if (paused) {
                controller.start();
                paused = false;
            } else {
                controller.stop();
                paused = true;
            }
        });

        foregroundCanvas.setDisable(true);
        foregroundCanvas.setOnMouseClicked(e -> {
            controller.onBuildRequest(nextSpawn, e.getX(), e.getY());
            toggleFCanvasClick();
        });

        normalTowerButton.setOnAction(e -> {
            nextSpawn = "nt";
            toggleFCanvasClick();
        });

        controller.start();
    }

    private void toggleFCanvasClick() {
        foregroundCanvas.setDisable(!foregroundCanvas.isDisable());
    }

    public Scene getScene() {
        return scene;
    }
}
