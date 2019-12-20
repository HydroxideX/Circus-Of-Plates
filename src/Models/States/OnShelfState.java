package Models.States;

import Models.Logger.GameLogger;
import View.game.GameObject;

public class OnShelfState implements IState {
    GameObject g ;
    public OnShelfState (GameObject g){
        this.g = g;
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("fine", "Plate Transitioned to OnShelfState");
    }
    @Override
    public void Update(int diff) {
        g.setX(g.getX()+diff);
    }
}
