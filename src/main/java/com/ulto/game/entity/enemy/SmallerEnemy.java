package com.ulto.game.entity.enemy;

import com.ulto.game.Constants;
import com.ulto.game.entity.drawer.Drawer;

public class SmallerEnemy extends Enemy{
    public SmallerEnemy(double x, double y) {
        super(x, y,
                Constants.SMALLER_ENEMY_WIDTH,
                Constants.SMALLER_ENEMY_HEIGHT,
                Constants.SMALLER_ENEMY_SPEED,
                Constants.SMALLER_ENEMY_HEALTH,
                Constants.SMALLER_ENEMY_ARMOR,
                Constants.SMALLER_ENEMY_REWARD);
    }

    @Override
    public void draw(int code) {
        Drawer.draw(this);
    }
}
