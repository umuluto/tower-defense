package com.ulto.game.entity.tower;

import com.ulto.game.Constants;

public class MachineGunTower extends Tower {
    public MachineGunTower(double x, double y) {
        super(x, y,
                Constants.MACHINE_GUN_TOWER_DAMAGE,
                Constants.MACHINE_GUN_TOWER_RANGE,
                Constants.MACHINE_GUN_TOWER_DELAY);
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub

    }
}