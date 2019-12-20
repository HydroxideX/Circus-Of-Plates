package Models.States;

import Models.Logger.GameLogger;
import View.game.GameObject;

public class FallingState implements IState {
    GameObject g ;
    public FallingState (GameObject g){
      this.g = g;
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("fine", "Plate Transitioned to Falling State");
    }
    public void Update(int diff){
        int newY = g.getY()+diff;
        g.setY(newY);
    }
}
