package com.ulto.game.entity.tower;

import com.ulto.game.Constants;
import com.ulto.game.entity.drawer.Drawer;

import javafx.scene.media.AudioClip;

import java.net.URL;

public class MachineGunTower extends Tower {

    AudioClip mgSound = new AudioClip(this.getClass().getResource("/tower/sound/mgSound.wav").toString());

    public MachineGunTower(double x, double y) {
        super(x, y,
            Constants.MACHINE_GUN_TOWER_DAMAGE,
            Constants.MACHINE_GUN_TOWER_RANGE,
            Constants.MACHINE_GUN_TOWER_DELAY);
    }

    @Override
    public void draw(int code) {
        Drawer.draw(this);
    }

    public void playSound(){
        mgSound.play();
    }
}
