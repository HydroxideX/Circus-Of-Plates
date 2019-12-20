package Models.States;

import Models.Logger.GameLogger;
import View.game.GameObject;

public class StackedState implements IState {
    GameObject g;

    public StackedState(GameObject g) {
        this.g = g;
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("fine", "Plate transitioned To Stacked State");
    }

    public void Update(int diff) {
        int newX = g.getX() + diff;
        g.setX(newX);
    }
}
