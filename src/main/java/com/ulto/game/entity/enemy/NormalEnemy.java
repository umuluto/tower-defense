package com.ulto.game.entity.enemy;

import com.ulto.game.Constants;
import com.ulto.game.entity.drawer.Drawer;

public class NormalEnemy extends Enemy {
    public NormalEnemy(double x, double y) {
        super(x, y,
                Constants.NORMAL_ENEMY_WIDTH,
                Constants.NORMAL_ENEMY_HEIGHT,
                Constants.NORMAL_ENEMY_SPEED,
                Constants.NORMAL_ENEMY_HEALTH,
                Constants.NORMAL_ENEMY_ARMOR,
                Constants.NORMAL_ENEMY_REWARD);
    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }
}