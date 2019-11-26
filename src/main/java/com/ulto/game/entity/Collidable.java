package com.ulto.game.entity;

import java.util.Optional;

import com.ulto.game.Constants;
import com.ulto.game.GameField;
import com.ulto.game.GameGrid;

public interface Collidable {
    int di[] = new int[] {-1, 0, 1, 0};
    int dj[] = new int[] {0, 1, 0, -1};

    double getX();
    double getY();
    double getWidth();
    double getHeight();

    default void handleCollision(GameField field) {
        GameGrid grid = field.getGrid();

        int j = (int)getX() / Constants.TILE_SIZE;
        int i = (int)getY() / Constants.TILE_SIZE;

        Optional<Collidable> collider = null;
        for (int k = 0; k < 4; ++k) {
            if (!GameGrid.inGrid(i + di[k], j + dj[k]))
                continue;

            collider = grid.getCell(i + di[k], j + dj[k])
                                .getEntities()
                                .stream()
                                .filter(e -> e instanceof Collidable)
                                .filter(e -> e != this)
                                .map(e -> (Collidable)e)
                                .filter(this::hasCollision)
                                .findAny();

            if (collider.isPresent()) break;
        }

        collider.ifPresent(this::onCollision);
    }

    default boolean hasCollision(Collidable e) {
            return getX() < e.getX() + e.getWidth()
                    && getX() + getWidth() > e.getX()
                    && getY() < e.getY() + e.getHeight()
                    && getY() + getHeight() > e.getY();
    }

    void onCollision(Collidable e);
}