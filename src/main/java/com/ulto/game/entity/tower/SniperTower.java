package com.ulto.game.entity.tower;

import com.ulto.game.Constants;

public class SniperTower extends Tower {
    public SniperTower(double x, double y) {
        super(x, y,
                Constants.SNIPER_TOWER_DAMAGE,
                Constants.SNIPER_TOWER_RANGE,
                Constants.SNIPER_TOWER_DELAY);
    }
    @Override
    public void draw() {
        // TODO Auto-generated method stub

    }
}