package com.ulto.game.entity.tile;

import java.util.List;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.Pair;
import com.ulto.game.entity.drawer.Drawer;

public class Spawner extends Road {
    private List<Pair<Integer, String>> wave;
    private double lastWaveTime = Integer.MIN_VALUE;
    private double lastSpawnTime = Integer.MIN_VALUE;

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
        if (pair.getA() <= 0)
            wave.remove(wave.size() - 1);
    }

    @Override
    public void update(GameField field) {
        double time = field.getTime();
        if (time - lastWaveTime > field.getWaveCreater().getWaveDuration()) {
            wave = field.getWaveCreater().getWave();
            lastWaveTime = time;
        }
        
        if (time - lastSpawnTime > Constants.SPAWN_DELAY) {
            spawn(field);
            lastSpawnTime = time;
        }
    }
}