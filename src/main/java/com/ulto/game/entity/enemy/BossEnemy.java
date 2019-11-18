package com.ulto.game.entity.enemy;

import com.ulto.game.Constants;
import com.ulto.game.entity.tile.GameTile;

public class BossEnemy extends Enemy {
    public BossEnemy(double x, double y) {
        super(x, y,
                Constants.BOSS_ENEMY_WIDTH,
                Constants.BOSS_ENEMY_HEIGHT,
                Constants.BOSS_ENEMY_SPEED,
                Constants.BOSS_ENEMY_HEALTH);
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub

    }
}