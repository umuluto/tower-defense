package com.ulto.game.entity.behavior;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.GameGrid;
import com.ulto.game.entity.Behavior;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.Movable;
import com.ulto.game.util.Vector;

public class SeekBehavior implements Behavior {
    private static GameField field;
    
    public static void setField(GameField field) {
        SeekBehavior.field = field;
    }

    @Override
    public void update(GameEntity entity) {
        Movable movable = (Movable)entity;
        double dt = field.getDelta();

        Vector force = steeringBehaviourFlowField(movable);

        Vector velocity = movable.getVelocity();
        velocity = velocity.plus(force.mul(dt));

        double speed = velocity.magn();
        if (speed > movable.getMaxSpeed()) {
            velocity = velocity.mul(movable.getMaxSpeed() / speed);
        }

        movable.setVelocity(velocity);
    }

    private Vector steeringBehaviourFlowField(Movable movable) {
        GameGrid grid = field.getGrid();

        Vector position = movable.getPosition();
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

        Vector desiredVelocity = direction.mul(movable.getMaxSpeed());

        Vector velocityChange = desiredVelocity.minus(movable.getVelocity());

        return velocityChange.mul(Constants.NORMAL_ENEMY_MAX_FORCE / movable.getMaxSpeed());
    }
}