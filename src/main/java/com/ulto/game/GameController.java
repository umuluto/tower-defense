package com.ulto.game;

import java.io.FileNotFoundException;

import com.ulto.game.entity.drawer.Drawer;

import javafx.scene.canvas.GraphicsContext;

public class GameController {
    private String name;
    private GraphicsContext backGround;
    private GraphicsContext foreGround;

    private GameStage stage;
    private GameField field;

    public GameController(String name, GraphicsContext background, GraphicsContext foreground) {
        this.name = name;
        this.backGround = background;
        this.foreGround = foreground;

        Drawer.setGc(background, foreground);

        try {
            stage = new GameStage(name);
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }

        //field = new GameField(stage);
    }
}