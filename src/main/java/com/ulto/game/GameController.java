package com.ulto.game;

import com.ulto.game.entity.behavior.MoveBehavior;
import com.ulto.game.entity.behavior.SeekBehavior;
import com.ulto.game.entity.drawer.Drawer;
import com.ulto.game.entity.tile.GameTile;
import com.ulto.game.entity.tile.Mountain;
import com.ulto.game.entity.tower.MachineGunTower;
import com.ulto.game.entity.tower.NormalTower;
import com.ulto.game.entity.tower.Tower;
import com.ulto.game.fxml.GameWindow;

import javafx.animation.AnimationTimer;

public class GameController extends AnimationTimer {
    private GameStage stage;
    private GameField field;
    private GameWindow gameWindow;
    
    public GameController(String name) {
        stage = new GameStage(name);
        // TODO: handle exception
        field = new GameField(stage);

        MoveBehavior.setField(field);
        SeekBehavior.setField(field);
    }

    @Override
    public void handle(long now) {
        field.update(now);
        Drawer.batchDraw(field);
        
        gameWindow.setHealth(field.getHealth());
        gameWindow.setGold(field.getGold());
        
        if (field.getHealth() <= 0) {
            gameWindow.gameOver();
        }
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

    public void onSellRequest(double x, double y) {
        GameTile tile = field.getGrid().getCell(x, y);
        if (!(tile instanceof Mountain) || tile.getEntities().isEmpty())
            return; 
        
        Tower tower = (Tower)tile.getEntities().get(0);
        field.earnGold(sellVal(tower));
        field.getEntities().remove(tower);
        tile.getEntities().clear();
    }
    
    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public int sellVal(Tower e) {
        if (e.getClass() == NormalTower.class)
            return 2;
        if (e.getClass() == MachineGunTower.class)
            return 6;
        return 8;
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