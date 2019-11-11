package com.ulto.game;

import com.ulto.game.entity.drawer.Drawer;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameController extends AnimationTimer {
    private GameStage stage;
    private GameField field;

    public GameController(String name, GraphicsContext background, GraphicsContext foreground) {
        Drawer.setGraphicsContexts(background, foreground);

        stage = new GameStage(name);
        // TODO: handle exception

        field = new GameField(stage);
    }

    @Override
    public void handle(long now) {
        field.update(now);
        Drawer.batchDraw(field);
    }
}