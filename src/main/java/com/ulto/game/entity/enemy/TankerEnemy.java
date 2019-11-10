package com.ulto.game.entity.enemy;

import com.ulto.game.Constants;
import com.ulto.game.entity.tile.GameTile;

public class TankerEnemy extends Enemy {
    protected TankerEnemy(double x, double y, double time, GameTile cell) {
        super(x, y, Constants.TANKER_ENEMY_WIDTH, Constants.TANKER_ENEMY_HEIGHT, Constants.TANKER_ENEMY_HEALTH, time, cell);
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub

    }
}