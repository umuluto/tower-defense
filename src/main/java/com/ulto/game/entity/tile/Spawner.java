package com.ulto.game.entity.tile;

import java.util.List;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.Pair;
import com.ulto.game.WaveCreater;
import com.ulto.game.entity.UpdatableEntity;
import com.ulto.game.entity.drawer.Drawer;

public class Spawner extends Road implements UpdatableEntity {
    private List<Pair<Integer, String>> wave;
    private double lastWaveTime = -999999999;
    private double lastSpawnTime = -999999999;

    public Spawner(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }

    public void spawn(GameField field) {
        if (wave.isEmpty()) return;
        Pair<Integer, String> pair = wave.get(wave.size() - 1);
        field.spawn(pair.getB(), getX(), getY());
        pair.setA(pair.getA() - 1);
        if (pair.getA().equals(0))
            wave.remove(wave.size() - 1);
    }

    @Override
    public void update(GameField field) {
        double now = field.getTime();
        if (now - lastWaveTime > Constants.WAVE_DURATION) {
            wave = WaveCreater.getWave(now);
            lastWaveTime = now;
        }
        if (now - lastSpawnTime > Constants.SPAWN_DELAY) {
            spawn(field);
            lastSpawnTime = now;
        }
    }
}