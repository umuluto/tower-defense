package com.ulto.game.entity.enemy;

import com.ulto.game.Constants;
import com.ulto.game.entity.tile.GameTile;

public class SmallerEnemy extends Enemy{
    protected SmallerEnemy(double x, double y, double time, GameTile cell) {
        super(x, y, Constants.SMALLER_ENEMY_WIDTH, Constants.SMALLER_ENEMY_HEIGHT, Constants.SMALLER_ENEMY_HEALTH, time, cell);
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub

    }  
}