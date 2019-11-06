package com.ulto.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ulto.game.entity.GameTile;
import com.ulto.game.entity.tile.Mountain;
import com.ulto.game.entity.tile.Road;

public class GameStage {
    private GameTile[][] grid = new GameTile[Constants.NUM_ROW][Constants.NUM_COL];

    public GameStage(String name) throws FileNotFoundException {
        File level = new File(name);
        Scanner in = new Scanner(level);

        for (int i = 0; i < Constants.NUM_ROW; ++i) {
            for (int j = 0; j < Constants.NUM_COL; ++j) {
                int x = j * Constants.TILE_SIZE;
                int y = i * Constants.TILE_SIZE;
                switch (in.nextInt()) {
                    case 1: 
                        grid[i][j] = new Mountain(x, y);
                        break;
                    case 0: 
                        grid[i][j] = new Road(x, y);
                        break;
                }

                grid[i][j].draw();
            }
        }

        in.close();
    }

    public GameTile[][] getGrid() {
        return grid;
    }
}