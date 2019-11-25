package com.ulto.game.entity;

import com.ulto.game.GameField;

public interface Destroyable {
    public boolean isDestroyed();
    public void onDestroy(GameField field);
}