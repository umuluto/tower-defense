package com.ulto.game.entity;

public interface DestroyableEntity {
    public boolean isDestroyed();
    public void onDestroy();
}