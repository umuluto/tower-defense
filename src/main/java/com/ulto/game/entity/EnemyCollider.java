package com.ulto.game.entity;

public interface EnemyCollider extends PhysicsCollider {
    @Override
    default void onCollision(Collidable e) {
        if (e.getClass() == this.getClass()
            || e instanceof Rock) {
            PhysicsCollider.super.onCollision(e);
        }
    }
}