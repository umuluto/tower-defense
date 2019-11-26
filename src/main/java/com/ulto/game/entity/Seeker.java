package com.ulto.game.entity;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.GameGrid;
import com.ulto.game.util.Vector;

public interface Seeker {
    Vector getPosition();
    Vector getVelocity();
    void setVelocity(Vector velocity);
    double getMaxSpeed();

    default void seek(GameField field) {
        double dt = field.getDelta();
        Vector velocity = getVelocity();
        Vector force = steeringBehaviourFlowField(field);

        velocity = velocity.plus(force.mul(dt));

        double speed = velocity.magn();
        if (speed > getMaxSpeed()) {
            velocity = velocity.mul(getMaxSpeed() / speed);
        }

        setVelocity(velocity);
    }

    default Vector steeringBehaviourFlowField(GameField field) {
        GameGrid grid = field.getGrid();

        Vector position = getPosition();
        int floorX = (int)position.getX();
        int floorY = (int)position.getY();
        int j = floorX / Constants.TILE_SIZE;
        int i = floorY / Constants.TILE_SIZE;

        Vector f00 = grid.getCell(i, j).getDirection();
        Vector f01 = grid.getCell(i, j + 1).getDirection();
        Vector f10 = grid.getCell(i + 1, j).getDirection();
        Vector f11 = grid.getCell(i + 1, j + 1).getDirection();

        double xWeight = position.getX() - floorX;

        Vector top = f00.mul(1 - xWeight).plus(f10.mul(xWeight));
        Vector bottom = f01.mul(1 - xWeight).plus(f11.mul(xWeight));

        double yWeight = position.getY() - floorY;
        Vector direction = top.mul(1 - yWeight).plus(bottom.mul(yWeight)).norm();

        if (Double.isNaN(direction.magn())) {
            return Vector.ZERO;
        }

        Vector desiredVelocity = direction.mul(getMaxSpeed());
        Vector velocityChange = desiredVelocity.minus(getVelocity());
        return velocityChange.mul(Constants.NORMAL_ENEMY_MAX_FORCE / getMaxSpeed());
    }
}