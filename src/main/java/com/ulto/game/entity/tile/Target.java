package com.ulto.game.entity.tile;

import com.ulto.game.GameField;
import com.ulto.game.Pair;
import com.ulto.game.entity.DestroyableEntity;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.UpdatableEntity;
import com.ulto.game.entity.drawer.Drawer;

public class Target extends Road implements UpdatableEntity {
    public Target(int x, int y) {
        super(x, y, 0);
        direction = new Pair<>(0, 0);
    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }

    @Override
    public void update(GameField field) {
        for (GameEntity e : entities)
            ((DestroyableEntity)e).onAttack(999999);
    }
}