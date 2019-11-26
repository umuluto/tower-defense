package com.ulto.game.entity.tower;

import com.ulto.game.Constants;
import com.ulto.game.entity.drawer.Drawer;
import javafx.scene.media.AudioClip;

public class SniperTower extends Tower {
    AudioClip snSound = new AudioClip(this.getClass().getResource("/tower/sound/snSound.mp3").toString());
    public SniperTower(double x, double y) {
        super(x, y,
            Constants.SNIPER_TOWER_DAMAGE,
            Constants.SNIPER_TOWER_RANGE,
            Constants.SNIPER_TOWER_DELAY);
    }

    @Override
    public void draw(int code) {
        Drawer.draw(this);
    }
    public void playSound(){
        snSound.play();
    }
}
