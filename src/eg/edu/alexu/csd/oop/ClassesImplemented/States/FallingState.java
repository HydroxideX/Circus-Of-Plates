package eg.edu.alexu.csd.oop.ClassesImplemented.States;

import eg.edu.alexu.csd.oop.game.GameObject;

public class FallingState extends State {
    GameObject g ;
    public FallingState (GameObject g){
       super(g);
    }
    public void Update(int diff){
        int newY = g.getY()+diff;
        g.setY(newY);
    }
}
