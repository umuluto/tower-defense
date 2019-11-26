package com.ulto.game.entity.enemy;

import com.ulto.game.Drawable;
import com.ulto.game.GameField;
import com.ulto.game.Updatable;
import com.ulto.game.entity.Destroyable;
import com.ulto.game.entity.EnemyCollider;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.GridCrawler;
import com.ulto.game.entity.Movable;
import com.ulto.game.entity.Seeker;
import com.ulto.game.util.Vector;

public abstract class Enemy implements GameEntity, Updatable, Drawable, Movable,
    Seeker, EnemyCollider, GridCrawler, Destroyable {
    private Vector position;

    private double width;
    private double height;

    private double maxSpeed;
    private Vector velocity = Vector.ZERO;

    private int health;
    private int reward;

    public Enemy(Vector position, double width, double height, double maxSpeed,
                 int health, int reward) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.maxSpeed = maxSpeed;
        this.health = health;
        this.reward = reward;
    }

    public Enemy(double x, double y, double width, double height,
                 double maxSpeed, int health, int reward) {
        this(new Vector(x, y), width, height, maxSpeed, health, reward);
    }    

    @Override
    public Vector getPosition() {
        return position;
    }

    @Override
    public void setPosition(Vector position) {
        this.position = position;
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
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

    @Override
    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double speed) {
        this.maxSpeed = speed;
    }

    @Override
    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @Override
    public void update(GameField field) {
        seek(field);
        deregister(field);
        move(field);
        register(field);
        handleCollision(field);
    }

    @Override
    public boolean isDestroyed() {
        return health <= 0;
    }

    @Override
    public void onDestroy(GameField field) {
        deregister(field);
    }

    public void onAttack(int damage) {
        health -= damage;
    }
}