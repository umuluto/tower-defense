package com.ulto.game.entity.enemy;

import com.ulto.game.GameField;
import com.ulto.game.GameGrid;
import com.ulto.game.entity.DestroyableEntity;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.UpdatableEntity;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tile.Road;

public abstract class Enemy implements GameEntity, UpdatableEntity, DestroyableEntity {
    private double x;
    private double y;
    private double width;
    private double height;
    private double velocityX;
    private double velocityY;

    private int health;
    private double past;
    private GameTile cell;

    protected void move(GameField field) {
        GameGrid grid = field.getGrid();

        if (cell == grid.findCell(x + width, y + height)) {
            velocityX = ((Road)cell).getDirection().getA();
            velocityY = ((Road)cell).getDirection().getB();
        }

        double delta = field.getTime() - past;
        double dx = velocityX * delta * 200;
        double dy = velocityY * delta * 200;

        x += dx; y += dy;

        GameTile estimateCell = grid.findCell(x, y);
        boolean hasCollision = estimateCell.getEntities()
                                            .stream()
                                            .anyMatch(e -> this.isCollided(e));

        if (hasCollision) {
            x -= dx; y -= dy;
        } else {
            grid.reposition(this, estimateCell);
            cell = estimateCell;
        }
    }

    public boolean isCollided(GameEntity entity) {
        if (!(entity instanceof Enemy) || entity == this)
            return false;
        Enemy other = (Enemy)entity;
        return this.x < other.x + other.width
                && this.x + this.width > other.x
                && this.y < other.y + other.height
                && this.y + this.height > other.y;
    }

    @Override
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

    @Override
    public void update(GameField field) {
        move(field);
        past = field.getTime();
    }

    protected Enemy(double x, double y, int width, int height, int health, double time, GameTile cell) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
        this.past = time;
        this.cell = cell;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public GameTile getCell() {
        return cell;
    }
}