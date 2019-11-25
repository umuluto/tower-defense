package com.ulto.game.entity;

import com.ulto.game.util.Vector;

public interface Movable {
    public Vector getPosition();
    public void setPosition(Vector position);
    public Vector getVelocity();
    public void setVelocity(Vector velocity);
    public double getMaxSpeed();
}