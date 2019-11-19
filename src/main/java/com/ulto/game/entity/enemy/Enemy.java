package com.ulto.game.entity.enemy;

import com.ulto.game.GameField;
import com.ulto.game.GameGrid;
import com.ulto.game.entity.DestroyableEntity;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.UpdatableEntity;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tile.Road;

import javafx.geometry.Point2D;

public abstract class Enemy implements GameEntity, UpdatableEntity, DestroyableEntity {
    private Point2D position;
    private double width;
    private double height;

    private double speed;
    private Point2D direction = new Point2D(0, 0);

    private int health;
    private int reward;

    protected void move(GameField field) {
        GameGrid grid = field.getGrid();

        GameTile topLeftCell = grid.getCell(position);
        GameTile botRightCell = grid.getCell(getX() + width, getY() + height);
        
        if (topLeftCell == botRightCell) {
            direction = ((Road)topLeftCell).getDirection();
        }

        double delta = field.getDelta();
        Point2D offset = direction.multiply(speed).multiply(delta);
        
        Point2D predictedTopLeft = position.add(offset);
        Point2D predictedBotRight = predictedTopLeft.add(new Point2D(width, height));

        GameTile preTopLeftCell = grid.getCell(predictedTopLeft);
        GameTile preBotRightCell = grid.getCell(predictedBotRight);
        
        boolean hasCollision = preTopLeftCell.getEntities()
                                            .stream()
                                            .anyMatch(e -> hasCollision(predictedTopLeft, e))
                                || preBotRightCell.getEntities()
                                            .stream()
                                            .anyMatch(e -> hasCollision(predictedTopLeft, e));
        

        if (!hasCollision) {
            position = predictedTopLeft;
            
            topLeftCell.getEntities().remove(this);
            preTopLeftCell.getEntities().add(this);
            
            botRightCell.getEntities().remove(this);
            preBotRightCell.getEntities().add(this);
        }
    }

    public boolean hasCollision(Point2D a, GameEntity b) {
        if (b.getClass() != this.getClass() || b == this)
            return false;
        Enemy other = (Enemy)b;
        return a.getX() < other.getX() + other.width
                && a.getX() + width > other.getX()
                && a.getY() < other.getY() + other.height
                && a.getY() + height > other.getY();
    }

    public void onAttack(int damage) {
        health -= damage;
    }

    @Override
    public boolean isDestroyed() {
        return health <= 0;
    }

    @Override
    public void onDestroy(GameField field) {
        GameGrid grid = field.getGrid();

        GameTile topLeftCell = grid.getCell(position);
        GameTile botRightCell = grid.getCell(getX() + width, getY() + height);
        
        topLeftCell.getEntities().remove(this);
        botRightCell.getEntities().remove(this);
    }

    @Override
    public void update(GameField field) {
        move(field);
    }
    
    public Enemy(Point2D position, double width, double height, double speed, int health, int reward) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.health = health;
        this.reward = reward;
    }

    public Enemy(double x, double y, double width, double height, double speed, int health, int reward) {
        this(new Point2D(x, y), width, height, speed, health, reward);
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Point2D getCenter() {
        return new Point2D(getX() + width/2f, getY() + height/2f);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point2D getVelocity() {
        return direction.multiply(speed);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Point2D getDirection() {
        return direction;
    }

    public void setDirection(Point2D direction) {
        this.direction = direction;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }
    
    public int getReward() {
        return reward;
    }
}