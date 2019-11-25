package com.ulto.game.entity.behavior;

import com.ulto.game.GameField;
import com.ulto.game.entity.Behavior;
import com.ulto.game.entity.Collidable;
import com.ulto.game.entity.GameEntity;

public class ShootBehavior implements Behavior {
    private static GameField field;

    @Override
    public void update(GameEntity entity) {
        Collidable shooter = (Collidable)entity;
    }
}