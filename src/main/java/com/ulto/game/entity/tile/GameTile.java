package com.ulto.game.entity.tile;

import java.util.ArrayList;
import java.util.List;

import com.ulto.game.entity.GameEntity;

public abstract class GameTile implements GameEntity {
    private final int x;
    private final int y;
    protected List<GameEntity> entities = new ArrayList<>();

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