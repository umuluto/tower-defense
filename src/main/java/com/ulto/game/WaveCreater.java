package com.ulto.game;

import java.util.ArrayList;
import java.util.List;

public class WaveCreater {
    public static List<Pair<Integer, String>> wave = new ArrayList<>();
    public static double lastWaveTime = -99999999;

    public static void createWave() {
        wave.clear();
        wave.add(new Pair<>(12, "ne"));
    }

    public static List<Pair<Integer, String>> getWave(double now) {
        if (now - lastWaveTime > Constants.WAVE_DURATION) createWave();
        return new ArrayList<>(wave);
    }
}