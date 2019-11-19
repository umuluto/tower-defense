package com.ulto.game.entity.drawer;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.entity.Bullet;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.enemy.BossEnemy;
import com.ulto.game.entity.enemy.NormalEnemy;
import com.ulto.game.entity.enemy.SmallerEnemy;
import com.ulto.game.entity.enemy.TankerEnemy;
import com.ulto.game.entity.tile.Mountain;
import com.ulto.game.entity.tile.Road;
import com.ulto.game.entity.tile.Spawner;
import com.ulto.game.entity.tile.Target;
import com.ulto.game.entity.tower.MachineGunTower;
import com.ulto.game.entity.tower.NormalTower;
import com.ulto.game.entity.tower.SniperTower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javafx.geometry.Point2D;
import java.util.Random;

public class Drawer {
    private static GraphicsContext background;
    private static GraphicsContext foreground;

    private static Point2D UP = new Point2D(0, -1);
    private static Point2D DOWN = new Point2D(0, 1);
    private static Point2D LEFT = new Point2D(-1, 0);
    private static Point2D RIGHT = new Point2D(1,0 );

    static Random rand = new Random();


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
        int n = rand.nextInt(60);
        Image image = null;
        if(n == 0)
            background.drawImage(Constants.grass0,mountain.getX(),mountain.getY());
        else if(n == 13)
            background.drawImage(Constants.grass2,mountain.getX(),mountain.getY());
        else if(n == 15) {
            background.drawImage(Constants.grass1, mountain.getX(), mountain.getY());
            background.drawImage(Constants.tree0, mountain.getX(), mountain.getY());
        }
        else if(n==20) {
            background.drawImage(Constants.grass1, mountain.getX(), mountain.getY());
            background.drawImage(Constants.tree1, mountain.getX(), mountain.getY());
        }
        else if(n==30) {
            background.drawImage(Constants.grass1, mountain.getX(), mountain.getY());
            background.drawImage(Constants.tree2, mountain.getX(), mountain.getY());
        }
        else
            background.drawImage(Constants.grass1,mountain.getX(),mountain.getY());
    }

    public static void draw(Road road) {
        background.drawImage(Constants.road1,road.getX(),road.getY());
    }

    public static void draw(Target target) {
        background.drawImage(Constants.target_background,target.getX(),target.getY());
        background.drawImage(Constants.target1,target.getX(),target.getY());
    }

    public static void draw(Spawner spawner) {
        background.drawImage(Constants.spawner_background,spawner.getX(),spawner.getY());
        background.drawImage(Constants.spawner1,spawner.getX(),spawner.getY());
    }


    public static void draw(NormalTower normalTower) {
        foreground.drawImage(Constants.nm_tower,normalTower.getX()-5,normalTower.getY()-12);
    }
    public static void draw(MachineGunTower machineGunTower) {
        foreground.drawImage(Constants.ms_tower,machineGunTower.getX()-5,machineGunTower.getY()-15);
    }
    public static void draw(SniperTower sniperTower) {
        foreground.drawImage(Constants.np_tower,sniperTower.getX()-5,sniperTower.getY()-12);
    }

    public static void draw(Bullet bullet) {
        foreground.drawImage(Constants.nm_bullet,bullet.getX(),bullet.getY());
    }



    public static void draw(NormalEnemy enemy) {
        Image image = null;
        if(enemy.getDirection().equals(UP))
            image = Constants.nm_enemy_up;
        else if(enemy.getDirection().equals(DOWN))
            image = Constants.nm_enemy_down;
        else if(enemy.getDirection().equals(LEFT))
            image = Constants.nm_enemy_left;
        else if(enemy.getDirection().equals(RIGHT))
            image = Constants.nm_enemy_right;
        foreground.drawImage(image,enemy.getX(),enemy.getY());
    }

    public static void draw(SmallerEnemy enemy) {
        Image image = null;
        if(enemy.getDirection().equals(UP))
            image = Constants.boss_enemy_up;
        else if(enemy.getDirection().equals(DOWN))
            image = Constants.boss_enemy_down;
        else if(enemy.getDirection().equals(LEFT))
            image = Constants.boss_enemy_left;
        else if(enemy.getDirection().equals(RIGHT))
            image = Constants.boss_enemy_right;
        foreground.drawImage(image,enemy.getX(),enemy.getY());
    }

    public static void draw(TankerEnemy enemy) {
        Image image = null;
        if(enemy.getDirection().equals(UP))
            image = Constants.tank_enemy_up;
        else if(enemy.getDirection().equals(DOWN))
            image = Constants.tank_enemy_down;
        else if(enemy.getDirection().equals(LEFT))
            image = Constants.tank_enemy_left;
        else if(enemy.getDirection().equals(RIGHT))
            image = Constants.tank_enemy_right;
        foreground.drawImage(image,enemy.getX(),enemy.getY());
    }

    public static void draw(BossEnemy enemy) {
        Image image = null;
        if(enemy.getDirection().equals(UP))
            image = Constants.boss_enemy_up;
        else if(enemy.getDirection().equals(DOWN))
            image = Constants.boss_enemy_down;
        else if(enemy.getDirection().equals(LEFT))
            image = Constants.boss_enemy_left;
        else if(enemy.getDirection().equals(RIGHT))
            image = Constants.boss_enemy_right;
        foreground.drawImage(image,enemy.getX(),enemy.getY());
    }

}
