package com.ulto.game;

import java.util.List;

import com.ulto.game.entity.Destroyable;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.enemy.BossEnemy;
import com.ulto.game.entity.enemy.NormalEnemy;
import com.ulto.game.entity.enemy.SmallerEnemy;
import com.ulto.game.entity.enemy.TankerEnemy;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tower.MachineGunTower;
import com.ulto.game.entity.tower.NormalTower;

public class GameField {
    private WaveCreater waveCreater = new WaveCreater();

    private int health = Constants.STARTING_HEALTH;
    private int gold = Constants.STARTING_GOLD;
    
    private double time;
    private double delta;

    private GameGrid grid = null;
    private List<GameEntity> entities = null;

    public GameField(GameStage stage) {
        this.grid = stage.getGrid();
        this.entities = stage.getEntities();
    }   

    public void update(long now) {
        double newTime = Math.min(time + 0.016, now / Constants.NPS);
        delta = newTime - time;
        time = newTime;
        
        waveCreater.update(this);
        
        int oldSize = entities.size();
        GameEntity e;
        for (int i = 0; i < oldSize; ++i) {
            e = entities.get(i);
            ((Updatable)e).update(this);
        }

        Destroyable de;
        for (int i = 0; i < entities.size(); ++i) {
            e = entities.get(i);
            if (e instanceof Destroyable) {
                de = (Destroyable)e;
                if (de.isDestroyed()) {
                    de.onDestroy(this);
                    entities.remove(i--);
                }
            }
        }
    }

    public void spawn(String type, double x, double y) {
        GameEntity newEntity = null;
        GameTile cell = grid.getCell(x, y);
        switch (type) {
            case "NormalEnemy":
                newEntity = new NormalEnemy(x, y);
                break;
            case "SmallerEnemy":
                newEntity = new SmallerEnemy(x, y);
                break;
            case "TankerEnemy":
                newEntity = new TankerEnemy(x, y);
                break;
            case "BossEnemy":
                newEntity = new BossEnemy(x, y);
                break;
            case "NormalTower":
                newEntity = new NormalTower(x, y);
                break;
            case "MachineGunTower":
                newEntity = new MachineGunTower(x, y);
                break;
            case "SniperTower":
                newEntity = new MachineGunTower(x, y);
                break;

        }

        entities.add(newEntity);
        cell.getEntities().add(newEntity);
    }

    public double getTime() {
        return time;
    }

    public GameGrid getGrid() {
        return grid;
    }

    public List<GameEntity> getEntities() {
        return entities;
    }

    public double getDelta() {
            return delta;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void takeDamage(int damage) {
        health = Math.max(health - damage, 0);
    }
    
    public int getGold() {
        return gold;
    }
    
    public boolean spendGold(int amount) {
        if (amount > gold)
            return false;
        gold -= amount;
        return true;
    }
    
    public void earnGold(int amount) {
        gold += amount;
    }
    
    public WaveCreater getWaveCreater() {
        return waveCreater;
    }
}