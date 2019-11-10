package com.ulto.game.entity.tile;

import com.ulto.game.entity.drawer.Drawer;

public class Mountain extends GameTile {
    public Mountain(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }
}