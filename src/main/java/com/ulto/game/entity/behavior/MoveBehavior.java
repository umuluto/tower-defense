package com.ulto.game.entity.behavior;

import com.ulto.game.GameField;
import com.ulto.game.entity.Behavior;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.Movable;
import com.ulto.game.util.Vector;

public class MoveBehavior implements Behavior {
    private static GameField field;

    public static void setField(GameField field) {
        MoveBehavior.field = field;
    }

    @Override
    public void update(GameEntity entity) {
        Movable movable = (Movable)entity;

        Vector position = movable.getPosition();
        Vector velocity = movable.getVelocity();
        double dt = field.getDelta();

        position = position.plus(velocity.mul(dt));
        movable.setPosition(position);
    }
}