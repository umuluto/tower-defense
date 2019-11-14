package com.ulto.game.entity.tile;

import com.ulto.game.entity.drawer.Drawer;

import javafx.geometry.Point2D;

public class Road extends GameTile {
    protected Point2D direction;
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

    public Point2D getDirection() {
        return direction;
    }

    public void setDirection(Point2D direction) {
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}