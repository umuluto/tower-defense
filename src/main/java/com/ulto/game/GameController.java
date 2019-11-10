package com.ulto.game;

import java.io.FileNotFoundException;

import com.ulto.game.entity.drawer.Drawer;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameController extends AnimationTimer {
    private GameStage stage;
    private GameField field;

    public GameController(String name, GraphicsContext background, GraphicsContext foreground) {
        Drawer.setGraphicsContexts(background, foreground);

        try {
            stage = new GameStage(name);
        }
        catch (FileNotFoundException e) {
            // TODO: handle or throws
        }

        field = new GameField(stage);
    }

    @Override
    public void handle(long now) {
        field.update(now);
        Drawer.batchDraw(field);
    }
}