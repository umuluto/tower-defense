package com.ulto.game;

import com.ulto.game.entity.drawer.Drawer;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tile.Mountain;
import com.ulto.game.fxml.GameWindow;
import java.util.Map;

import javafx.animation.AnimationTimer;

public class GameController extends AnimationTimer {
    private GameStage stage;
    private GameField field;
    private GameWindow gameWindow;
    
    public GameController(String name) {
        stage = new GameStage(name);
        // TODO: handle exception
        field = new GameField(stage);
    }

    @Override
    public void handle(long now) {
        field.update(now);
        Drawer.batchDraw(field);
        
        gameWindow.setHealth(field.getHealth());
        gameWindow.setGold(field.getGold());
    }
    
    public void onBuildRequest(String type, double x, double y) {
        double inset = (Constants.TILE_SIZE - Constants.TOWER_SIZE) / 2f;
        GameTile tile = field.getGrid().getCell(x, y);
        if (!(tile instanceof Mountain) || !tile.getEntities().isEmpty())
            return; 
        if (!field.spendGold(cost(type)))
            return;
        
        field.spawn(type, tile.getX() + inset, tile.getY() + inset);
    }
    
    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
    
    private int cost(String type) {
        switch (type) {
            case "NormalTower":
                return 5;
            case "MachineGunTower":
                return 15;
            case "SniperTower":
                return 30;
        }
        
        return 0;
    }
}