package com.ulto.game.entity.enemy;

import com.ulto.game.Constants;
import com.ulto.game.entity.drawer.Drawer;

public class BossEnemy extends Enemy {
    public BossEnemy(double x, double y) {
        super(x, y,
            Constants.BOSS_ENEMY_WIDTH,
            Constants.BOSS_ENEMY_HEIGHT,
            Constants.BOSS_ENEMY_SPEED,
            Constants.BOSS_ENEMY_HEALTH,
            Constants.BOSS_ENEMY_REWARD);
    }

    @Override
    public void draw(int code) {
        Drawer.draw(this);
    }
}
