package com.ulto.game;

import com.ulto.game.entity.enemy.Enemy;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.util.Vector;

import javafx.util.Pair;

public class GameGrid {
    private GameTile[][] grid = new GameTile[Constants.NUM_ROW][Constants.NUM_COL];
    
    public GameTile[][] getGrid() {
        return grid;
    }

    public GameTile getCell(double x, double y) {
        int u = (int)x / Constants.TILE_SIZE;
        int v = (int)y / Constants.TILE_SIZE;
        return grid[v][u];
    }

    public GameTile getCell(Vector pos) {
        return getCell(pos.getX(), pos.getY());
    }

    public GameTile getCell(int i, int j) {
        return grid[i][j];
    }

    public void setCell(int i, int j, GameTile cell) {
        grid[i][j] = cell;
    }

    public static boolean inGrid(int i, int j) {
        return 0 <= i && i < Constants.NUM_ROW && 0 <= j && j < Constants.NUM_COL;
    }

    public static boolean inGrid(double x, double y) {
        return 0 <= x && x < Constants.SCREEN_WIDTH && 0 <= y && y < Constants.SCREEN_HEIGHT;
    }

    public static boolean inGrid(Vector pos) {
        return inGrid(pos.getX(), pos.getY());
    }
}