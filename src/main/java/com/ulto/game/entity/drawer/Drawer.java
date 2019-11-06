package com.ulto.game.entity.drawer;

import com.ulto.game.Constants;
import com.ulto.game.entity.tile.Mountain;
import com.ulto.game.entity.tile.Road;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Drawer {
    private static GraphicsContext background;   
    private static GraphicsContext foreground;

    public static void setGc(GraphicsContext t, GraphicsContext e) {
        background = t;
        foreground = e;
    }

    public static void draw(Mountain mountain) {
        background.setFill(Color.CHOCOLATE);
        background.fillRect(mountain.getX(), mountain.getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);
    }
 
    public static void draw(Road road) {
        background.setFill(Color.GRAY);
        background.fillRect(road.getX(), road.getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);
    }
}