package com.ulto.game.entity.tile;

import java.util.ArrayList;
import java.util.List;

import com.ulto.game.entity.GameEntity;

import javafx.geometry.Point2D;

public abstract class GameTile implements GameEntity {
    private final Point2D position;
    protected List<GameEntity> entities = new ArrayList<>();

    protected GameTile(int x, int y) {
        this(new Point2D(x, y));
    }

    protected GameTile(Point2D position) {
        this.position = position;
    }

	public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public List<GameEntity> getEntities() {
        return entities;
    }
}