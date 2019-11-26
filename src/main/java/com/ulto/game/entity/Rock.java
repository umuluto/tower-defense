package com.ulto.game.entity;

import com.ulto.game.Constants;

public class Rock implements GameEntity, Collidable {
    private double x;
    private double y;

    public Rock(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return Constants.TILE_SIZE;
    }

    @Override
    public double getHeight() {
        return Constants.TILE_SIZE;
    }

    @Override
    public void onCollision(Collidable e) {}
}