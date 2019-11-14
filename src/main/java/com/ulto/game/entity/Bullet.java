package com.ulto.game.entity;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.entity.drawer.Drawer;
import com.ulto.game.entity.enemy.Enemy;

import javafx.geometry.Point2D;

public class Bullet implements GameEntity, UpdatableEntity, DestroyableEntity {
    private Point2D position;

    private Point2D velocity;

    private int damage;
    private double remainTime;

    @Override
    public void update(GameField field) {
        double delta = field.getDelta();
        position = position.add(velocity.multiply(delta));
        remainTime -= delta;

        if (remainTime <= 0.032) {
            for (GameEntity entity : field.getGrid().getCell(position).getEntities()) {
                if (hasCollision(position, entity)) {
                    ((Enemy)entity).onAttack(damage);
                    remainTime = Integer.MIN_VALUE;
                    break;
                }
            }
        }
    }

    @Override
    public boolean isDestroyed() {
        return remainTime <= 0;
    }

    @Override
    public void onDestroy() {
        // TODO: effects 
    }
    
    public boolean hasCollision(Point2D a, GameEntity b) {
        if (!(b instanceof Enemy))
            return false;
        Enemy other = (Enemy)b;
        return a.getX() < other.getX() + other.getWidth()
                && a.getX() + getWidth() > other.getX()
                && a.getY() < other.getY() + other.getHeight()
                && a.getY() + getHeight() > other.getY();
    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }

    public Bullet(Point2D position, Point2D velocity, int damage, double remainTime) {
        this.position = position;
        this.velocity = velocity;
        this.damage = damage;
        this.remainTime = remainTime;
    }    

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public int getWidth() {
        return Constants.BULLET_SIZE;
    }

    public int getHeight() {
        return Constants.BULLET_SIZE;
    }

    public Point2D getPosition() {
        return position;
    }
}