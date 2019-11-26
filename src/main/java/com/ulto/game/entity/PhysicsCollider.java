package com.ulto.game.entity;

import com.ulto.game.util.Vector;

public interface PhysicsCollider extends Collidable {
    Vector getVelocity();
    void setVelocity(Vector velocity);

    @Override
    default void onCollision(Collidable e) {
        System.out.println("#");
        setVelocity(Vector.ZERO);
    }
}