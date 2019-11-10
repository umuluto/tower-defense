package com.ulto.game.entity;

public interface DestroyableEntity {
    public boolean isDestroyed();
    public void onAttack(int damage);
    public void onDestroy();
}