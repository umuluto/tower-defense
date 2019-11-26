package com.ulto.game.entity;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.GameGrid;

public interface GridCrawler {
    int di[] = new int[] {-1, 0, 1, 0};
    int dj[] = new int[] {0, 1, 0, -1};

    double getX();
    double getY();

    default void register(GameField field) {
        GameGrid grid = field.getGrid();

        int j = (int)getX() / Constants.TILE_SIZE;
        int i = (int)getY() / Constants.TILE_SIZE;

        for (int k = 0; k < 4; ++k) {
            if (GameGrid.inGrid(i + di[k], j + dj[k])) {
                grid.getCell(i + di[k], j + dj[k])
                    .getEntities()
                    .add((GameEntity)this);
            }
        }
    }

    default void deregister(GameField field) {
        GameGrid grid = field.getGrid();

        int j = (int)getX() / Constants.TILE_SIZE;
        int i = (int)getY() / Constants.TILE_SIZE;

        for (int k = 0; k < 4; ++k) {
            if (GameGrid.inGrid(i + di[k], j + dj[k])) {
                grid.getCell(i + di[k], j + dj[k])
                    .getEntities()
                    .remove((GameEntity)this);
            }
        }
    }
}