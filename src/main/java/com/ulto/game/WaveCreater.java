package com.ulto.game;

import com.ulto.game.entity.UpdatableEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaveCreater implements UpdatableEntity {
    private List<Pair<Integer, String>> wave = new ArrayList<>();
    private double lastWaveTime = Integer.MIN_VALUE;
    private double difficulty = Constants.BASE_DIFFICULTY;
    private double waveDuration = Constants.STANDBY_TIME;
    private double maxDuration = Constants.STANDBY_TIME;
    private boolean syncedLanes = false;
    private boolean newlyInit = false;
    private String[] types = new String[] {"NormalEnemy", "SmallerEnemy", "TankerEnemy", "BossEnemy"};

    @Override
    public void update(GameField field) {
        if (newlyInit) {
            waveDuration = maxDuration;
            maxDuration = Constants.STANDBY_TIME;
            newlyInit = false;
        }

        if (field.getTime() - lastWaveTime > waveDuration) {
            newlyInit = true;
            lastWaveTime = field.getTime();
            int rand = new Random().nextInt(4);
            syncedLanes = rand > 0;
            
            if (syncedLanes) createWave();
        }

        difficulty += field.getDelta() * 0.03;
    }
    
    public void createWave() {
        wave.clear();
        
        int remainingDiff = (int)difficulty;
        double curWaveTime = Constants.STANDBY_TIME;
        for (String type : types) {
            int maxNum = remainingDiff / weight(type);
            if (maxNum <= 0) continue;
            int enemyNum = new Random().nextInt(maxNum);
            
            if (enemyNum == 0) continue;
            
            remainingDiff -= enemyNum * weight(type);
            wave.add(new Pair<>(enemyNum, type));
            curWaveTime += enemyNum * Constants.SPAWN_DELAY;
            if (remainingDiff <= 0) break;
        }
        
        if (remainingDiff > 0) {
            int enemyNum = remainingDiff / weight("NormalEnemy");
            wave.add(new Pair<>(enemyNum, "NormalEnemy"));
            curWaveTime += enemyNum * Constants.SPAWN_DELAY;
        }

        maxDuration = Math.max(maxDuration, curWaveTime);
    }

    public List<Pair<Integer, String>> getWave() {
        if (!syncedLanes)
            createWave();
        return new ArrayList<>(wave);
    }
    
    private int weight(String type) {
        switch (type) {
            case "NormalEnemy":
                return 1;
            case "SmallerEnemy":
                return 1;
            case "TankerEnemy":
                return 2;
            case "BossEnemy":
                return 3;
        }
        return 0;
    }

    public double getWaveDuration() {
        return waveDuration;
    }

    public boolean isReady() {
        return newlyInit;
    }
}