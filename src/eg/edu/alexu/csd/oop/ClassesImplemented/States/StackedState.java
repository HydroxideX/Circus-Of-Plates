package eg.edu.alexu.csd.oop.ClassesImplemented.States;

import eg.edu.alexu.csd.oop.game.GameObject;

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
