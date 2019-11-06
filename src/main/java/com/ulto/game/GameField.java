package com.ulto.game;

import com.ulto.game.entity.GameEntity;
import com.ulto.game.entity.GameTile;

import java.util.ArrayList;
import java.util.List;

import com.ulto.game.Constants;

public class GameField {
    private String levelName;

    private GameTile[][] grid = new GameTile[Constants.NUM_ROW][Constants.NUM_COL];
    private List<GameEntity> entities = new ArrayList<>();

    public GameField(GameStage stage) {
        this.grid = stage.getGrid();
    }   
}