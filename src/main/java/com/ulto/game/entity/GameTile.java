package com.ulto.game.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class GameTile implements GameEntity {
    private final int x;
    private final int y;
    private List<GameEntity> entities = new ArrayList<>();

    protected GameTile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<GameEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<GameEntity> entities) {
        this.entities = entities;
    }
}