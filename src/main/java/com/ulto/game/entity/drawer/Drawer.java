package com.ulto.game.entity.drawer;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.entity.Bullet;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.enemy.NormalEnemy;
import com.ulto.game.entity.tile.Mountain;
import com.ulto.game.entity.tile.Road;
import com.ulto.game.entity.tile.Spawner;
import com.ulto.game.entity.tile.Target;
import com.ulto.game.entity.tower.NormalTower;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.InputStream;

public class Drawer {
    private static GraphicsContext background;
    private static GraphicsContext foreground;

    public static void batchDraw(GameField field) {
        foreground.clearRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        for (GameEntity e : field.getEntities()) {
            e.draw();
        }
    }

    public static void setGraphicsContexts(GraphicsContext bgContext, GraphicsContext fgContext) {
        background = bgContext;
        foreground = fgContext;
    }

    /**
     * @return the background
     */
    public static GraphicsContext getBackground() {
        return background;
    }

    /**
     * @return the foreground
     */
    public static GraphicsContext getForeground() {
        return foreground;
    }

    public static void draw(Mountain mountain) {
        //background.setFill(Color.CHOCOLATE);
        //background.fillRect(mountain.getX(), mountain.getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);
    }

    public static void draw(Road road) {
        background.setFill(Color.GRAY);
        background.fillRect(road.getX(), road.getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);

        background.setFill(Color.BLACK);
        Integer distance = road.getDistance();
        background.fillText(distance.toString(), road.getX(), road.getY() + Constants.TILE_SIZE);
    }

    public static void draw(Target target) {
        background.setFill(Color.BLUE);
        background.fillRect(target.getX(), target.getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);

        // background.setFill(Color.YELLOW);
        // Integer distance = target.getDistance();
        // background.fillText(distance.toString(), target.getX(), target.getY() + Constants.TILE_SIZE);
    }

    public static void draw(Spawner spawner) {
        background.setFill(Color.RED);
        background.fillRect(spawner.getX(), spawner.getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);

        // background.setFill(Color.GREEN);
        // Integer distance = spawner.getDistance();
        // background.fillText(distance.toString(), spawner.getX(), spawner.getY() + Constants.TILE_SIZE);
    }

    public static void draw(NormalEnemy enemy) {
        foreground.setFill(Color.GREEN);
        foreground.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
    }

    public static void draw(NormalTower normalTower) {
        foreground.setFill(Color.PURPLE);
        foreground.fillRect(normalTower.getX(), normalTower.getY(), Constants.TOWER_SIZE, Constants.TOWER_SIZE);
    }

    public static void draw(Bullet bullet) {
        foreground.setFill(Color.BLACK);
        foreground.fillRect(bullet.getX(), bullet.getY(), Constants.BULLET_SIZE, Constants.BULLET_SIZE);
    }
}
