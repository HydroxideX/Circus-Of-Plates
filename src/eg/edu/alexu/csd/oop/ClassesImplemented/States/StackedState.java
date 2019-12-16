package eg.edu.alexu.csd.oop.ClassesImplemented.States;

import eg.edu.alexu.csd.oop.game.GameObject;

public class StackedState extends State{
    public StackedState (GameObject g){
       super(g);
    }
    public void Update(int diff){
        int newX = g.getX()+diff;
        g.setX(newX);
    }
}
