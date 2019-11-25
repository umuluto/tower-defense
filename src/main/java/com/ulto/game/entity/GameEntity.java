package com.ulto.game.entity;

import java.util.List;

import com.ulto.game.GameField;

public abstract class GameEntity {
    protected List<Behavior> behaviors;

    public abstract void update(GameField field);

    public abstract void draw();
}