package Models.States;

import View.game.GameObject;

public class StackedState implements IState {
    GameObject g;

    public StackedState(GameObject g) {
        this.g = g;
    }

    public void Update(int diff) {
        int newX = g.getX() + diff;
        g.setX(newX);
    }
}
