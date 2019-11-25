package com.ulto.game.entity.tower;

import com.ulto.game.Constants;
import com.ulto.game.entity.drawer.Drawer;

public class NormalTower extends Tower {
    public NormalTower(double x, double y) {
        super(x, y,
                Constants.NORMAL_TOWER_DAMAGE,
                Constants.NORMAL_TOWER_RANGE,
                Constants.NORMAL_TOWER_DELAY);
    }
    @Override
    public void draw() {
        // Drawer.draw(this);
    }
}