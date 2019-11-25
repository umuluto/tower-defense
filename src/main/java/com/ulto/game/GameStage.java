package com.ulto.game;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tile.Mountain;
import com.ulto.game.entity.tile.Road;
import com.ulto.game.entity.tile.Spawner;
import com.ulto.game.entity.tile.Target;
import com.ulto.game.util.Vector;

public class GameStage {
    private GameGrid grid = new GameGrid();
    private List<GameEntity> entities = new ArrayList<>();

    public GameStage(String name) {
        InputStream stream = GameStage.class.getResourceAsStream(name);
        Scanner in = new Scanner(stream);
        Pair<Integer, Integer> target = null;

        for (int i = 0; i < Constants.NUM_ROW; ++i) {
            for (int j = 0; j < Constants.NUM_COL; ++j) {
                int x = j * Constants.TILE_SIZE;
                int y = i * Constants.TILE_SIZE;

                GameTile tile = null;
                switch (in.nextInt()) {
                    case 0:
                        tile = new Road(x, y);
                        break;
                    case 1:
                        tile = new Mountain(x, y);
                        break;
                    case 2:
                        tile = new Spawner(x, y);
                        entities.add(tile);
                        break;
                    case 3:
                        target = new Pair<>(i, j);
                        tile = new Target(x, y);
                        entities.add(tile);
                        break;
                }
                grid.setCell(i, j, tile);

                grid.getCell(i, j).draw();
            }
        }

        pathFind(target);
        
        in.close();
    }

    private void pathFind(Pair<Integer, Integer> target) {
        int di[] = new int[] {-1, 0, 1, 0};
        int dj[] = new int[] {0, 1, 0, -1};

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(target);

        Road currentCell, otherCell;
        int i, j, u, v;

        while (!queue.isEmpty()) {
            i = queue.peek().getA();
            j = queue.poll().getB();
            currentCell = (Road)grid.getCell(i, j);

            for (int k = 0; k < 4; ++k) {
                u = i + di[k];
                v = j + dj[k];
                if (!GameGrid.inGrid(u, v) || grid.getCell(u, v) instanceof Mountain) continue;
                otherCell = (Road)grid.getCell(u, v);
                if (otherCell.getDistance() == Integer.MAX_VALUE) {
                    queue.add(new Pair<>(u, v));
                    continue;
                }
                if (otherCell.getDistance() < currentCell.getDistance()) {
                    currentCell.setDistance(otherCell.getDistance() + 1);
                    currentCell.setDirection(new Vector(v - j, u - i));
                }
            }
        }
    }

    public GameGrid getGrid() {
        return grid;
    }

    public List<GameEntity> getEntities() {
        return entities;
    }
}
