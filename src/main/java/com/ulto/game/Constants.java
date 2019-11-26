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

    public static Image grass0 = new Image("/moutain/grass_tile_1.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image grass1 = new Image("/moutain/grass_tile_2.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image grass2 = new Image("/moutain/grass_tile_3.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image tree0 = new Image("/moutain/tree1.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image tree1 = new Image("/moutain/tree2.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);
    public static Image tree2 = new Image("/moutain/tree3.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);

    public static Image road = new Image("/moutain/grass_tile_4.png",Constants.TILE_SIZE-0.5,Constants.TILE_SIZE-0.5,false,true);
    public static Image road1 = new Image("/road/road1.png",Constants.TILE_SIZE,Constants.TILE_SIZE,false,true);

    public static Image nm_tower = new Image("/tower/tower1.png",Constants.TILE_SIZE+8,Constants.TILE_SIZE+8,false,true);
    public static Image np_tower = new Image("/tower/tower2.png",Constants.TILE_SIZE+8,Constants.TILE_SIZE+8,false,true);
    public static Image ms_tower = new Image("/tower/tower3.png",Constants.TILE_SIZE+8,Constants.TILE_SIZE+8,false,true);


    public static Image nm_enemy_up = new Image("/enemy/normal_enemy_up.png",NORMAL_ENEMY_WIDTH,NORMAL_ENEMY_HEIGHT,false,true);
    public static Image nm_enemy_down = new Image("/enemy/normal_enemy_down.png",NORMAL_ENEMY_WIDTH,NORMAL_ENEMY_HEIGHT,false,true);
    public static Image nm_enemy_right = new Image("/enemy/normal_enemy_right.png",NORMAL_ENEMY_WIDTH,NORMAL_ENEMY_HEIGHT,false,true);
    public static Image nm_enemy_left = new Image("/enemy/normal_enemy_left.png",NORMAL_ENEMY_WIDTH,NORMAL_ENEMY_HEIGHT,false,true);

    public static Image boss_enemy_up = new Image("/enemy/boss_enemy_up.png",BOSS_ENEMY_WIDTH,BOSS_ENEMY_HEIGHT,false,true);
    public static Image boss_enemy_down = new Image("/enemy/boss_enemy_down.png",BOSS_ENEMY_WIDTH,BOSS_ENEMY_HEIGHT,false,true);
    public static Image boss_enemy_right = new Image("/enemy/boss_enemy_right.png",BOSS_ENEMY_WIDTH,BOSS_ENEMY_HEIGHT,false,true);
    public static Image boss_enemy_left = new Image("/enemy/boss_enemy_left.png",BOSS_ENEMY_WIDTH,BOSS_ENEMY_HEIGHT,false,true);

    public static Image tank_enemy_up = new Image("/enemy/tank_enemy_up.png",TANKER_ENEMY_WIDTH,TANKER_ENEMY_HEIGHT,false,true);
    public static Image tank_enemy_down= new Image("/enemy/tank_enemy_down.png",TANKER_ENEMY_WIDTH,TANKER_ENEMY_HEIGHT,false,true);
    public static Image tank_enemy_right = new Image("/enemy/tank_enemy_right.png",TANKER_ENEMY_WIDTH,TANKER_ENEMY_HEIGHT,false,true);
    public static Image tank_enemy_left = new Image("/enemy/tank_enemy_left.png",TANKER_ENEMY_WIDTH,TANKER_ENEMY_HEIGHT,false,true);


    public static Image nm_bullet = new Image("/bullet/bullet1.png",BULLET_SIZE,BULLET_SIZE,false,true);

    public static Image target_background = new Image("/target/target0.png",TILE_SIZE,TILE_SIZE,false,true);
    public static Image target1 = new Image("/target/target1.png",TILE_SIZE,TILE_SIZE,false,true);

    public static Image spawner_background = new Image("/spawner/spawner0.png",TILE_SIZE,TILE_SIZE,false,true);
    public static Image spawner1 = new Image("/spawner/spawner1.png",TILE_SIZE,TILE_SIZE,false,true);
}
