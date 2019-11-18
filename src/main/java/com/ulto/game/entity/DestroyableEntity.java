package com.ulto.game.entity;

import com.ulto.game.GameField;

public interface DestroyableEntity {
    public boolean isDestroyed();
    public void onDestroy(GameField field);
}