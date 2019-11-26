package com.ulto.game.entity.tower;

import com.ulto.game.Constants;
import com.ulto.game.entity.drawer.Drawer;
import javafx.scene.media.AudioClip;

import java.net.URL;

public class NormalTower extends Tower {
    private final URL resource = getClass().getResource("/tower/sound/nSound.wav");
    private final AudioClip nSound = new AudioClip(resource.toString());
    public NormalTower(double x, double y) {
        super(x, y,
            Constants.NORMAL_TOWER_DAMAGE,
            Constants.NORMAL_TOWER_RANGE,
            Constants.NORMAL_TOWER_DELAY);
    }
    @Override
    public void draw(int code) {
        Drawer.draw(this);
    }
    public void playSound(){
        nSound.play();
    }
}
