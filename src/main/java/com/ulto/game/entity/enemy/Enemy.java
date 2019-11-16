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
    private int width;
    private int height;

    private int speed;
    private Point2D direction;

    private int health;
    private GameTile cell;

    protected void move(GameField field) {
        GameGrid grid = field.getGrid();

        if (cell == grid.getCell(position.getX() + width, position.getY() + height)) {
            direction = ((Road)cell).getDirection();
        }

        double delta = field.getDelta();
        Point2D offset = direction.multiply(speed).multiply(delta);
        Point2D predicted = position.add(offset);

        GameTile predictedCell = grid.getCell(predicted);
        boolean hasCollision = predictedCell.getEntities()
                                            .stream()
                                            .anyMatch(e -> hasCollision(predicted, e));

        if (!hasCollision) {
            position = predicted;
            grid.changeCell(this, grid.getCell(predicted));
            cell = grid.getCell(predicted);
        }
    }

    public boolean hasCollision(Point2D a, GameEntity b) {
        if (!(b instanceof Enemy) || b == this)
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
    public void onDestroy() {
        cell.getEntities().remove(this);
    }

    public double cellWeight() {
        return (getX() - cell.getX()) * direction.getX() + (getY() - cell.getY()) * direction.getY();
    }

    @Override
    public void update(GameField field) {
        move(field);
    }
    
    public Enemy(Point2D position, int width, int height, int speed, int health, GameTile cell) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.health = health;
        this.cell = cell;
    }

    public Enemy(double x, double y, int width, int height, int speed, int health, GameTile cell) {
        this(new Point2D(x, y), width, height, speed, health, cell);
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point2D getVelocity() {
        return direction.multiply(speed);
    }

    public int getSpeed() {
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

    public GameTile getCell() {
        return cell;
    }

    public void setCell(GameTile cell) {
        this.cell = cell;
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }
}