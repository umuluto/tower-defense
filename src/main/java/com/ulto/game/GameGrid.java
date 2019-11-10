package com.ulto.game;

import com.ulto.game.entity.enemy.Enemy;
import com.ulto.game.entity.tile.GameTile;

public class GameGrid {
    private GameTile[][] grid = new GameTile[Constants.NUM_ROW][Constants.NUM_COL];

    public GameTile findCell(double x, double y) {
        int u = (int)x / Constants.TILE_SIZE;
        int v = (int)y / Constants.TILE_SIZE;
        return grid[v][u];
    }

    public GameTile getCell(int i, int j) {
        return grid[i][j];
    }

    public void setCell(int i, int j, GameTile cell) {
        grid[i][j] = cell;
    }

    public void reposition(Enemy e, GameTile cell) {
        e.getCell().getEntities().remove(e);
        cell.getEntities().add(e);
    }
}