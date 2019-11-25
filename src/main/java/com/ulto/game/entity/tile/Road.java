package com.ulto.game.entity.tile;

import com.ulto.game.entity.drawer.Drawer;

public class Road extends GameTile {
    public Road(int x, int y, int distance) {
        super(x, y);
        this.distance = distance;
    }

    public Road(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }
}