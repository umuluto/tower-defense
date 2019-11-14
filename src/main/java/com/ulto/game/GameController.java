package com.ulto.game;

import com.ulto.game.entity.drawer.Drawer;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tile.Mountain;

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

    public void onBuildRequest(String type, double x, double y) {
        final double inset = (Constants.TILE_SIZE - Constants.TOWER_SIZE) / 2;
        GameTile tile = field.getGrid().getCell(x, y);
        if (!(tile instanceof Mountain) || !tile.getEntities().isEmpty()) return;
        field.spawn(type, tile.getX() + inset, tile.getY() + inset);
    }   
}