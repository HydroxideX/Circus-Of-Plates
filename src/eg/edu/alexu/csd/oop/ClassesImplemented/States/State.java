package eg.edu.alexu.csd.oop.ClassesImplemented.States;

import eg.edu.alexu.csd.oop.game.GameObject;

public class State {
    GameObject g ;
    public State (GameObject g){
        this.g = g ;
    }
    public void Update(int diff){
        int newY = g.getY()+diff , newX = g.getX()+diff;
        g.setY(newY);
        g.setX(newX);
    }

}
