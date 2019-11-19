package com.ulto.game.entity.enemy;

import com.ulto.game.Constants;
import com.ulto.game.entity.drawer.Drawer;

public class TankerEnemy extends Enemy {
    public TankerEnemy(double x, double y) {
        super(x, y,
                Constants.TANKER_ENEMY_WIDTH,
                Constants.TANKER_ENEMY_HEIGHT,
                Constants.TANKER_ENEMY_SPEED,
                Constants.TANKER_ENEMY_HEALTH,
                Constants.TANKER_ENEMY_REWARD);
    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }
}