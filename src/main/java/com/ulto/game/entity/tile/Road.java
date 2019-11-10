package com.ulto.game.entity.tile;

import com.ulto.game.Pair;
import com.ulto.game.entity.drawer.Drawer;

public class Road extends GameTile {
    protected Pair<Integer, Integer> direction;
    protected int distance;

    protected Road(int x, int y, int distance) {
        super(x, y);
        this.distance = distance;
    }

    public Road(int x, int y) {
        this(x, y, Integer.MAX_VALUE);
    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }

    public Pair<Integer, Integer> getDirection() {
        return direction;
    }

    public void setDirection(Pair<Integer, Integer> direction) {
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}