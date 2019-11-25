package com.ulto.game.entity.tower;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.GameGrid;
import com.ulto.game.entity.Bullet;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.enemy.Enemy;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tile.Road;
import com.ulto.game.util.Vector;


public abstract class Tower extends GameEntity {
    private final Vector position;

    private final int damage;
    private final double range;
    private final double delay;
    public double lastShotTime = Integer.MIN_VALUE;

    private Enemy currentTarget = null;

    @Override
    public void update(GameField field) {
        // if (field.getTime() - lastShotTime < delay) return;
        // if (currentTarget == null || currentTarget.isDestroyed() || !inRange(currentTarget))
        //     currentTarget = heaviestInRange(field);
        // if (currentTarget == null)
        //     return;
            
        // shoot(field, currentTarget);
        // lastShotTime = field.getTime();
    }

    // public void shoot(GameField field, Enemy target) {
    //     double remainTime = range / Constants.BULLET_SPEED;
    //     field.getEntities().add(new Bullet(getCenter(), target, damage, remainTime));
    // }

    // private Enemy heaviestInRange(GameField field) {
    //     double centerX = getX() + Constants.TOWER_SIZE / 2f;
    //     double centerY = getY() + Constants.TOWER_SIZE / 2f;

    //     GameGrid grid = field.getGrid();

    //     int minDistance = Integer.MAX_VALUE;
    //     double maxWeight = Integer.MIN_VALUE;
    //     GameEntity heaviestEntity = null;

    //     for (double u = centerX - range; u <= centerX + range; u += Constants.TILE_SIZE) {
    //         for (double v = centerY - range; v <= centerY + range; v += Constants.TILE_SIZE) {
    //             if (!GameGrid.inGrid(u, v)) continue;
    //             GameTile currentTile = grid.getCell(u, v);

    //             if (!(currentTile instanceof Road) || !inRange(currentTile)) continue;
                
    //             Road road = (Road)currentTile;
    //             if (road.getDistance() > minDistance) continue;
    //             maxWeight = Integer.MIN_VALUE;

    //             for (GameEntity entity : currentTile.getEntities()) {
    //                 Enemy e = (Enemy)entity;
    //                 if (!inRange(e)) continue;

    //                 if (cellWeight(e, road) > maxWeight) {
    //                     minDistance = road.getDistance();
    //                     maxWeight = cellWeight(e, road);
    //                     heaviestEntity = e;
    //                 }
    //             }
    //         }
    //     }

    //     return (Enemy)heaviestEntity;
    // }
    
    // private double cellWeight(Enemy enemy, Road cell) {
    //     Vector offset = enemy.getPosition().minus(cell.getPosition());
    //     return cell.getDirection().dot(offset);
    // }

    // private boolean inRange(GameTile tile) {
    //     return inRange(tile.getX(), tile.getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);
    // }

    // private boolean inRange(Enemy e) {
    //     return inRange(e.getX(), e.getY(), e.getWidth(), e.getHeight());
    // }

    // private boolean inRange(double u, double v, double w, double h) {
    //     return inRange(u, v)
    //             || inRange(u, v + h)
    //             || inRange(u + w, v)
    //             || inRange(u + w, v + h);
    // }

    // private boolean inRange(double u, double v) {
    //     double centerX = getX() + Constants.TOWER_SIZE / 2f;
    //     double centerY = getY() + Constants.TOWER_SIZE / 2f;
    //     return Math.sqrt((centerX - u) * (centerX - u) + (centerY - v) * (centerY - v)) < range;
    // }

    protected Tower(Vector position, int damage, double range, double delay) {
        this.position = position;
        this.damage = damage;
        this.range = range;
        this.delay = delay;
    }

    protected Tower(double x, double y, int damage, double range, double delay) {
        this(new Vector(x, y), damage, range, delay);
    }

    // public Point2D getCenter() {
    //     return new Point2D(getX() + getWidth()/2f, getY() + getHeight()/2f);
    // }

    // public double getX() {
    //     return position.getX();
    // }

    // public double getY() {
    //     return position.getY();
    // }

    // public Point2D getPosition() {
    //     return position;
    // }

    // public double getWidth() {
    //     return Constants.TOWER_SIZE;
    // }

    // public double getHeight() {
    //     return Constants.TOWER_SIZE;
    // }

    // public int getDamage() {
    //     return damage;
    // }

    // public double getRange() {
    //     return range;
    // }

    // public double getDelay() {
    //     return delay;
    // }
}