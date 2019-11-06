package com.ulto.game.entity.tile;

import com.ulto.game.entity.GameTile;
import com.ulto.game.entity.drawer.Drawer;

public class Road extends GameTile {
    private int distanceToTarget;

    public Road(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }
}