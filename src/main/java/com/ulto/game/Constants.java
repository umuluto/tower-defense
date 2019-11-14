package com.ulto.game;

public final class Constants {
    public static final double NPS = 1e9;
    public static final int TILE_SIZE = 20;
    public static final int NUM_ROW = 30;
    public static final int NUM_COL = 50;
    public static final int SCREEN_WIDTH = TILE_SIZE * NUM_COL;
    public static final int SCREEN_HEIGHT = TILE_SIZE * NUM_ROW;
    public static final double SPAWN_DELAY = 1;
    public static final double WAVE_DURATION = 15;

    public static final int NORMAL_ENEMY_WIDTH = 10;
    public static final int NORMAL_ENEMY_HEIGHT = 10;

    public static final int BOSS_ENEMY_WIDTH = 15;
    public static final int BOSS_ENEMY_HEIGHT = 15;

    public static final int SMALLER_ENEMY_WIDTH = 7;
    public static final int SMALLER_ENEMY_HEIGHT = 7;

    public static final int TANKER_ENEMY_WIDTH = 10;
    public static final int TANKER_ENEMY_HEIGHT = 10;

    public static final int NORMAL_ENEMY_SPEED = 70;
    public static final int BOSS_ENEMY_SPEED = 60;
    public static final int TANKER_ENEMY_SPEED = 50;
    public static final int SMALLER_ENEMY_SPEED = 100;

    public static final int TOWER_SIZE = 12;
    public static final int BULLET_SIZE = 6;
    public static final int BULLET_SPEED = 200;

    public static final int NORMAL_TOWER_DAMAGE = 3;
    public static final int MACHINE_GUN_TOWER_DAMAGE = 2;
    public static final int SNIPER_TOWER_DAMAGE = 5;

    public static final double NORMAL_TOWER_RANGE = 2.4 * TILE_SIZE;
    public static final double MACHINE_GUN_TOWER_RANGE = 1.3 * TILE_SIZE;
    public static final double SNIPER_TOWER_RANGE = 3.2 * TILE_SIZE;

    public static final double NORMAL_TOWER_DELAY = 0.5;
    public static final double MACHINE_GUN_TOWER_DELAY = 1;
    public static final double SNIPER_TOWER_DELAY = 4;

    public static final int NORMAL_ENEMY_HEALTH = 5;
    public static final int BOSS_ENEMY_HEALTH = 20;
    public static final int SMALLER_ENEMY_HEALTH = 3;
    public static final int TANKER_ENEMY_HEALTH = 10;
}