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
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

import javafx.geometry.Point2D;

import java.net.URL;
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
            e.draw(1);
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

    public static void draw(Mountain mountain, int code) {
        int n = rand.nextInt(60);
        Image image = null;
        if(code<20) {
            if (code == 1)
                background.drawImage(Constants.grass_10, mountain.getX(), mountain.getY());
            else if (code == 2)
                background.drawImage(Constants.grass_20, mountain.getX(), mountain.getY());
            else if (code == 3)
                background.drawImage(Constants.grass_30, mountain.getX(), mountain.getY());
            else if (code == 4)
                background.drawImage(Constants.grass_40, mountain.getX(), mountain.getY());
            else if (code == 5)
                background.drawImage(Constants.grass_11, mountain.getX(), mountain.getY());
            else if (code == 6)
                background.drawImage(Constants.grass_15, mountain.getX(), mountain.getY());
            else if (code == 7)
                background.drawImage(Constants.grass_25, mountain.getX(), mountain.getY());
            else if (code == 8)
                background.drawImage(Constants.grass_31, mountain.getX(), mountain.getY());
            else if (code == 9)
                background.drawImage(Constants.grass_29, mountain.getX(), mountain.getY());
            else if (code == 10)
                background.drawImage(Constants.grass_35, mountain.getX(), mountain.getY());
            else if (code == 11)
                background.drawImage(Constants.grass_45, mountain.getX(), mountain.getY());
            else if (code == 12)
                background.drawImage(Constants.grass_09, mountain.getX(), mountain.getY());
            else if (code == 13)
                background.drawImage(Constants.grass, mountain.getX(), mountain.getY());
            else if (code == 14)
                background.drawImage(Constants.sand, mountain.getX(), mountain.getY());
            else if (code == 15)
                background.drawImage(Constants.rock, mountain.getX(), mountain.getY());
            else if (code == 16)
                background.drawImage(Constants.rock_r16, mountain.getX(), mountain.getY());
            else if (code == 17)
                background.drawImage(Constants.rock_r17, mountain.getX(), mountain.getY());
            else if (code == 18)
                background.drawImage(Constants.rock_r18, mountain.getX(), mountain.getY());
            else if (code == 19)
                background.drawImage(Constants.rock_r19, mountain.getX(), mountain.getY());
        }
        else if(code<40 && code>19){
            if(code == 20)
                background.drawImage(Constants.sand_20,mountain.getX(),mountain.getY());
            else if(code == 21)
                background.drawImage(Constants.sand_21,mountain.getX(),mountain.getY());
            else if(code == 22)
                background.drawImage(Constants.sand_22,mountain.getX(),mountain.getY());
            else if(code == 23)
                background.drawImage(Constants.sand_23,mountain.getX(),mountain.getY());
            else if(code == 24)
                background.drawImage(Constants.sand_24,mountain.getX(),mountain.getY());
            else if(code == 25)
                background.drawImage(Constants.sand_25,mountain.getX(),mountain.getY());
            else if(code == 26)
                background.drawImage(Constants.sand_26,mountain.getX(),mountain.getY());
            else if(code == 27)
                background.drawImage(Constants.sand_27,mountain.getX(),mountain.getY());
            else if(code == 28)
                background.drawImage(Constants.sand_28,mountain.getX(),mountain.getY());
            else if(code == 29)
                background.drawImage(Constants.sand_29,mountain.getX(),mountain.getY());
            else if(code == 30)
                background.drawImage(Constants.sand_30,mountain.getX(),mountain.getY());
            else if(code == 31)
                background.drawImage(Constants.sand_31,mountain.getX(),mountain.getY());
            else if(code == 32)
                background.drawImage(Constants.sand_32,mountain.getX(),mountain.getY());
            else if(code == 33)
                background.drawImage(Constants.sand_33,mountain.getX(),mountain.getY());
            else if(code == 34)
                background.drawImage(Constants.sand_34,mountain.getX(),mountain.getY());
            else if(code == 35)
                background.drawImage(Constants.sand_35,mountain.getX(),mountain.getY());
            else if(code == 36)
                background.drawImage(Constants.sand_36,mountain.getX(),mountain.getY());
            else if(code == 37)
                background.drawImage(Constants.sand_37,mountain.getX(),mountain.getY());
            else if(code == 38)
                background.drawImage(Constants.sand_38,mountain.getX(),mountain.getY());
            else if(code == 39)
                background.drawImage(Constants.sand_39,mountain.getX(),mountain.getY());

        }
        else if(code>39){
            if(code == 40)
                background.drawImage(Constants.grass20,mountain.getX(), mountain.getY());
            else if(code == 41)
                background.drawImage(Constants.grass21,mountain.getX(),mountain.getY());
            else if(code == 42)
                background.drawImage(Constants.grass22,mountain.getX(),mountain.getY());
            else if(code == 43)
                background.drawImage(Constants.grass23,mountain.getX(),mountain.getY());
            else if(code == 44)
                background.drawImage(Constants.sand_40,mountain.getX(),mountain.getY());
            else if(code == 45)
                background.drawImage(Constants.sand_41,mountain.getX(),mountain.getY());
            else if(code == 46)
                background.drawImage(Constants.sand_42,mountain.getX(),mountain.getY());
            else if(code == 47)
                background.drawImage(Constants.sand_43,mountain.getX(),mountain.getY());
        }



        //draw tree
        if(n == 13)
            background.drawImage(Constants.tree0,mountain.getX(),mountain.getY());
        else if(n == 15) {
            background.drawImage(Constants.tree4, mountain.getX(), mountain.getY());
        }
        else if(n==20) {
            background.drawImage(Constants.tree1, mountain.getX(), mountain.getY());
        }
        else if(n==30) {
            background.drawImage(Constants.tree2, mountain.getX(), mountain.getY());
        }

    }

    public static void draw(Road road) {
        background.drawImage(Constants.road1,road.getX(),road.getY());
    }

    public static void draw(Target target) {
        background.drawImage(Constants.road1,target.getX(),target.getY());
    }

    public static void draw(Spawner spawner) {
        background.drawImage(Constants.road1,spawner.getX(),spawner.getY());
    }


    public static void draw(NormalTower normalTower) {
        foreground.drawImage(Constants.tab,normalTower.getX(),normalTower.getY());
        foreground.drawImage(Constants.nmTower,normalTower.getX(),normalTower.getY()-15);
    }
    public static void draw(MachineGunTower machineGunTower) {
        foreground.drawImage(Constants.tab,machineGunTower.getX(),machineGunTower.getY());
        foreground.drawImage(Constants.mgTower,machineGunTower.getX(),machineGunTower.getY()-15);
    }
    public static void draw(SniperTower sniperTower) {
        foreground.drawImage(Constants.snTower,sniperTower.getX(),sniperTower.getY());
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
