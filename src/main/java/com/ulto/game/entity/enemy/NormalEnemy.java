package com.ulto.game.entity.enemy;

import com.ulto.game.Constants;
import com.ulto.game.entity.drawer.Drawer;
import com.ulto.game.entity.tile.GameTile;

public class NormalEnemy extends Enemy {
    public NormalEnemy(double x, double y, GameTile cell) {
        super(x, y,
                Constants.NORMAL_ENEMY_WIDTH,
                Constants.NORMAL_ENEMY_HEIGHT,
                Constants.NORMAL_ENEMY_SPEED,
                Constants.NORMAL_ENEMY_HEALTH,
                cell);
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        Drawer.draw(this);
    }
}