package com.ulto.game.entity.tile;

import com.ulto.game.GameField;
import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.drawer.Drawer;
import com.ulto.game.entity.enemy.Enemy;

public class Target extends Road {
    public Target(int x, int y) {
        super(x, y, 0);
    }

    @Override
    public void draw() {
        Drawer.draw(this);
    }

    @Override
    public void update(GameField field) {
        for (GameEntity e : entities) {
            ((Enemy)e).onAttack(Integer.MAX_VALUE);
            field.takeDamage(1);
        }
    }
}