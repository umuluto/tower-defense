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
<<<<<<< HEAD
        
<<<<<<< HEAD
        if (hasCollision(position, target)) {
            remainTime -= 1000000;
=======
        if (position.distance(target.getCenter()) < 5) {
>>>>>>> 41bd985acab06a68b85b8e081bc430aa1eb254d9
            target.onAttack(damage);
=======

        if (remainTime <= 0.032) {
            for (GameEntity entity : field.getGrid().getCell(position).getEntities()) {
                if (hasCollision(position, entity)) {
                    ((Enemy)entity).onAttack(damage);
                    remainTime = Integer.MIN_VALUE;
                    break;
                }
            }
>>>>>>> parent of 5a81985... sửa xét va chạm
        }
    }

    @Override
    public boolean isDestroyed() {
        return remainTime <= 0;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======

    @Override
    public void onDestroy() {
        // TODO: effects 
    }
>>>>>>> parent of 5a81985... sửa xét va chạm
    
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
<<<<<<< HEAD
=======

    @Override
    public void onDestroy(GameField field) {
        // TODO: EFFECTS?
    }
    
    private void follow(double delta) {
        Point2D offset = target.getPosition().subtract(position);
        position = position.add(offset.normalize().multiply(delta).multiply(Constants.BULLET_SPEED));
    }
>>>>>>> 41bd985acab06a68b85b8e081bc430aa1eb254d9
    
=======

    public Bullet(Point2D position, Point2D velocity, int damage, double remainTime) {
        this.position = position;
        this.velocity = velocity;
        this.damage = damage;
        this.remainTime = remainTime;
    }    

>>>>>>> parent of 5a81985... sửa xét va chạm
    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }
<<<<<<< HEAD
<<<<<<< HEAD
    
    public double getWidth() {
=======

    public int getWidth() {
>>>>>>> parent of 5a81985... sửa xét va chạm
        return Constants.BULLET_SIZE;
    }

    public int getHeight() {
        return Constants.BULLET_SIZE;
    }
<<<<<<< HEAD
=======
>>>>>>> 41bd985acab06a68b85b8e081bc430aa1eb254d9
=======

    public Point2D getPosition() {
        return position;
    }
>>>>>>> parent of 5a81985... sửa xét va chạm
}