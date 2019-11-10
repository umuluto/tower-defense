package com.ulto.game;

public final class Constants {
    public static final double NPS = 1e9;
    public static final int TILE_SIZE = 20;
    public static final int NUM_ROW = 30;
    public static final int NUM_COL = 50;
    public static final int SCREEN_WIDTH = TILE_SIZE * NUM_COL;
    public static final int SCREEN_HEIGHT = TILE_SIZE * NUM_ROW;
    public static final double SPAWN_DELAY = 0.5;
    public static final double WAVE_DURATION = 10;

    public static final int NORMAL_ENEMY_WIDTH = 10;
    public static final int NORMAL_ENEMY_HEIGHT = 10;

    public static final int BOSS_ENEMY_WIDTH = 15;
    public static final int BOSS_ENEMY_HEIGHT = 15;

    public static final int SMALLER_ENEMY_WIDTH = 7;
    public static final int SMALLER_ENEMY_HEIGHT = 7;

    public static final int TANKER_ENEMY_WIDTH = 10;
    public static final int TANKER_ENEMY_HEIGHT = 10;

    public static final int NORMAL_ENEMY_HEALTH = 5;
    public static final int BOSS_ENEMY_HEALTH = 20;
    public static final int SMALLER_ENEMY_HEALTH = 3;
    public static final int TANKER_ENEMY_HEALTH = 10;
}