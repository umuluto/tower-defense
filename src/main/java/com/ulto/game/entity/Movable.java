package com.ulto.game.entity;

import com.ulto.game.GameField;
import com.ulto.game.util.Vector;

public interface Movable {
    Vector getPosition();
    void setPosition(Vector position);
    Vector getVelocity();
    void setVelocity(Vector velocity);

    default void move(GameField field) {
        Vector position = getPosition();
        Vector velocity = getVelocity();
        double dt = field.getDelta();

        position = position.plus(velocity.mul(dt));
        setPosition(position);
    }
}