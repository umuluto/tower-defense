package com.ulto.game.entity;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.entity.drawer.Drawer;
import com.ulto.game.entity.enemy.Enemy;

import javafx.geometry.Point2D;

public class Bullet implements GameEntity, UpdatableEntity, DestroyableEntity {
    private Point2D position;
    private int damage;
    private Enemy target;
    private double remainTime;
    
    public Bullet(Point2D position, Enemy target, int damage, double remainTime) {
        this.position = position;
        this.target = target;
        this.damage = damage;
        this.remainTime = remainTime;
    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }

    @Override
    public void update(GameField field) {
        if (target.isDestroyed()) {
            remainTime -= 100000;
            return;
        }
        
        double delta = field.getDelta();
        follow(delta);
        remainTime -= delta;
        
        if (hasCollision(position, target)) {
            remainTime -= 1000000;
            target.onAttack(damage);
        }
    }

    @Override
    public boolean isDestroyed() {
        return remainTime <= 0;
    }
    
    public boolean hasCollision(Point2D a, GameEntity b) {
        Enemy other = (Enemy)b;
        return a.getX() < other.getX() + getWidth()
                && a.getX() + getWidth() > other.getX()
                && a.getY() < other.getY() + other.getHeight()
                && a.getY() + getHeight() > other.getY();
    }

    @Override
    public void onDestroy(GameField field) {
        // TODO: EFFECTS?
    }
    
    private void follow(double delta) {
        Point2D offset = target.getPosition().subtract(position);
        position = position.add(offset.normalize().multiply(delta).multiply(Constants.BULLET_SPEED));
    }
    
    public double getX() {
        return position.getX();
    }
    
    public double getY() {
        return position.getY();
    }
    
    public double getWidth() {
        return Constants.BULLET_SIZE;
    }
    
    public double getHeight() {
        return Constants.BULLET_SIZE;
    }
}