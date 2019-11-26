package com.ulto.game;

import javafx.scene.image.Image;

public final class Constants {
    public static final double NPS = 1e9;
    public static final int TILE_SIZE = 30;
    public static final int NUM_ROW = 20;
    public static final int NUM_COL = 40;
    
    public static final int SCREEN_WIDTH = TILE_SIZE * NUM_COL;
    public static final int SCREEN_HEIGHT = TILE_SIZE * NUM_ROW;
    
    public static final int STARTING_HEALTH = 20;
    public static final int STARTING_GOLD = 10;
    
    public static final int BASE_DIFFICULTY = 10;
    public static final double STANDBY_TIME = 6;
    
    public static final double SPAWN_DELAY = 1;
    public static final double WAVE_DURATION = 15;

    public static final double NORMAL_ENEMY_WIDTH = TILE_SIZE * 0.45;
    public static final double NORMAL_ENEMY_HEIGHT = TILE_SIZE * 0.45;

    public static final double BOSS_ENEMY_WIDTH = TILE_SIZE * 0.75;
    public static final double BOSS_ENEMY_HEIGHT = TILE_SIZE * 0.75;

    public static final double SMALLER_ENEMY_WIDTH = TILE_SIZE * 0.25;
    public static final double SMALLER_ENEMY_HEIGHT = TILE_SIZE * 0.25;

    public static final double TANKER_ENEMY_WIDTH = TILE_SIZE * 0.75;
    public static final double TANKER_ENEMY_HEIGHT = TILE_SIZE * 0.75;

    public static final double NORMAL_ENEMY_SPEED = 70;
    public static final double BOSS_ENEMY_SPEED = 60;
    public static final double TANKER_ENEMY_SPEED = 50;
    public static final double SMALLER_ENEMY_SPEED = 100;

    public static final double TOWER_SIZE = TILE_SIZE * 0.75;
    public static final double BULLET_SIZE = 6;
    public static final double BULLET_SPEED = 250;

    public static final int NORMAL_TOWER_DAMAGE = 8;
    public static final int MACHINE_GUN_TOWER_DAMAGE = 6;
    public static final int SNIPER_TOWER_DAMAGE = 15;

    public static final double NORMAL_TOWER_RANGE = 2.4 * TILE_SIZE;
    public static final double MACHINE_GUN_TOWER_RANGE = 1.3 * TILE_SIZE;
    public static final double SNIPER_TOWER_RANGE = 3.2 * TILE_SIZE;

    public static final double NORMAL_TOWER_DELAY = 1;
    public static final double MACHINE_GUN_TOWER_DELAY = 0.2;
    public static final double SNIPER_TOWER_DELAY = 4;

    public static final int NORMAL_ENEMY_HEALTH = 12;
    public static final int BOSS_ENEMY_HEALTH = 30;
    public static final int SMALLER_ENEMY_HEALTH = 7;
    public static final int TANKER_ENEMY_HEALTH = 20;
    
    public static final int NORMAL_ENEMY_ARMOR = 2;
    public static final int BOSS_ENEMY_ARMOR = 5;
    public static final int SMALLER_ENEMY_ARMOR = 1;
    public static final int TANKER_ENEMY_ARMOR = 3;

    public static final int NORMAL_ENEMY_REWARD = 1;
    public static final int BOSS_ENEMY_REWARD = 10;
    public static final int SMALLER_ENEMY_REWARD = 2;
    public static final int TANKER_ENEMY_REWARD = 5;

    public static Image img_tree0 = new Image("/Tree_Rock/towerDefense_tile236.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image img_tree1 = new Image("/Tree_Rock/towerDefense_tile132.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image img_tree2 = new Image("/Tree_Rock/towerDefense_tile134.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image img_tree3 = new Image("/Tree_Rock/towerDefense_tile157.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image grass = new Image("/Tree_Rock/towerDefense_tile157.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image img_road = new Image("/towerDefense_tile200.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image img_spawner = new Image("/towerDefense_tile278.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image img_target = new Image("/towerDefense_tile247.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
}
