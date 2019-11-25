package com.ulto.game.entity.tile;

import java.util.ArrayList;
import java.util.List;

import com.ulto.game.GameField;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.util.Vector;

public abstract class GameTile extends GameEntity {
    private final Vector position;
    protected Vector direction = Vector.ZERO;
    protected int distance = Integer.MAX_VALUE;
     
    protected List<GameEntity> entities = new ArrayList<>();

    protected GameTile(int x, int y) {
        this(new Vector(x, y));
    }

    protected GameTile(Vector position) {
        this.position = position;
    }

    public Vector getPosition() {
        return position;
    }
	public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public List<GameEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<GameEntity> entities) {
        this.entities = entities;
    }

    @Override
    public void update(GameField field) {
        // TODO Auto-generated method stub
        
    }
}