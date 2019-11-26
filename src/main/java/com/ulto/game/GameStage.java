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

import javafx.geometry.Point2D;

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
                int code = in.nextInt();

                GameTile tile = null;
                switch (code) {
                    case 0:
                        tile = new Road(x, y);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                        tile = new Mountain(x, y);
                        break;
                    case 50:
                        tile = new Spawner(x, y);
                        entities.add(tile);
                        break;
                    case 51:
                        target = new Pair<>(i, j);
                        tile = new Target(x, y);
                        entities.add(tile);
                        break;
                }
                grid.setCell(i, j, tile);

                grid.getCell(i, j).draw(code);
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
                    currentCell.setDirection(new Point2D(v - j, u - i));
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
