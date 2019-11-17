package com.ulto.game;

import java.io.InputStream;
import java.util.*;

import com.sun.deploy.security.SelectableSecurityManager;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tile.Mountain;
import com.ulto.game.entity.tile.Road;
import com.ulto.game.entity.tile.Spawner;
import com.ulto.game.entity.tile.Target;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

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

                // TODO: UNCOMMENT THIS
                // grid.getCell(i, j).draw();
            }
        }

        pathFind(target);

        // TODO: COMMENT THIS OUT
        // draw the map
        //random number
        Random random = new Random();
        int n = 0;

        Group moutainPane = new Group();
        for (int i = 0; i < Constants.NUM_ROW; ++i) {
            for (int j = 0; j < Constants.NUM_COL; ++j) {
                grid.getCell(i, j).draw();
                if(grid.getCell(i,j) instanceof Mountain){
                    n = random.nextInt(60);
                    ImageView imageView = new ImageView(Constants.grass);

                    if(n < 1) {
                        //imageView = new ImageView(Constants.img_tree0);
                        imageView = new ImageView(Constants.img_tree1);
                    }
                    else if(n>12 && n<14) {
                        //imageView = new ImageView(Constants.img_tree0);
                        imageView = new ImageView(Constants.img_tree2);
                    }
                    else if(n>19 && n<21) {
                        //imageView = new ImageView(Constants.img_tree0);
                        imageView = new ImageView(Constants.img_tree3);
                    }

                    imageView.setY(i * Constants.TILE_SIZE);
                    imageView.setX(j * Constants.TILE_SIZE);
                    moutainPane.getChildren().add(imageView);
                }
                else if(grid.getCell(i,j) instanceof Road){
                    ImageView imageView = new ImageView(Constants.img_road);
                    imageView.setY(i * Constants.TILE_SIZE);
                    imageView.setX(j * Constants.TILE_SIZE);
                    moutainPane.getChildren().add(imageView);
                }
                /*
                if(grid.getCell(i,j) instanceof Target){
                    ImageView imageView = new ImageView(Constants.img_target);
                    imageView.setY(i * Constants.TILE_SIZE);
                    imageView.setX(j * Constants.TILE_SIZE);
                    moutainPane.getChildren().add(imageView);
                }*/
                //target not correct way

                //if use else if, spawner not appeared
                if(grid.getCell(i,j) instanceof Spawner){
                    ImageView imageView = new ImageView(Constants.img_spawner);
                    imageView.setY(i * Constants.TILE_SIZE);
                    imageView.setX(j * Constants.TILE_SIZE);
                    moutainPane.getChildren().add(imageView);
                }
            }
        }

        Scene scene = new Scene(moutainPane,1000,1000);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

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
