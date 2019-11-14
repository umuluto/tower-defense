package com.ulto.game;

import java.util.List;

import com.ulto.game.entity.DestroyableEntity;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.UpdatableEntity;
import com.ulto.game.entity.enemy.NormalEnemy;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tower.NormalTower;

public class GameField {
    // private long debugTime = 0;
    private double time;
    private double delta;

    private GameGrid grid = null;
    private List<GameEntity> entities = null;

    public GameField(GameStage stage) {
        this.grid = stage.getGrid();
        this.entities = stage.getEntities();
    }   

    public void update(long now) {
        // System.out.println(now - debugTime);
        // debugTime = now;
        double newTime = Math.min(time + 0.016, now / Constants.NPS);
        delta = newTime - time;
        time = newTime;
        
        int oldSize = entities.size();
        GameEntity e;
        for (int i = 0; i < oldSize; ++i) {
            e = entities.get(i);
            // if (e instanceof UpdatableEntity)
                ((UpdatableEntity)e).update(this);
        }

        DestroyableEntity de;
        for (int i = 0; i < entities.size(); ++i) {
            e = entities.get(i);
            if (e instanceof DestroyableEntity) {
                de = (DestroyableEntity)e;
                if (de.isDestroyed()) {
                    de.onDestroy();
                    entities.remove(i--);
                }
            }
        }
    }

    public void spawn(String type, double x, double y) {
        GameEntity newEntity = null;
        GameTile cell = grid.getCell(x, y);
        switch (type) {
            case "ne":
                newEntity = new NormalEnemy(x, y, cell);
                break;
            case "nt":
                newEntity = new NormalTower(x, y);
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
}