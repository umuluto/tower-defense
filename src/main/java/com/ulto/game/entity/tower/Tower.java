package com.ulto.game.entity.tower;

import com.ulto.game.GameField;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.UpdatableEntity;

public abstract class Tower implements GameEntity, UpdatableEntity {
    @Override
    public void update(GameField field) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}