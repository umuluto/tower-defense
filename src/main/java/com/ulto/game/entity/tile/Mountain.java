package com.ulto.game.entity.tile;

import com.ulto.game.entity.GameTile;
import com.ulto.game.entity.drawer.Drawer;

public class Mountain extends GameTile {

    public Mountain(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }
    
}