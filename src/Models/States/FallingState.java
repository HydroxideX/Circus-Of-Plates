package Models.States;

import View.game.GameObject;

public class FallingState implements IState {
    GameObject g ;
    public FallingState (GameObject g){
      this.g = g;
    }
    public void Update(int diff){
        int newY = g.getY()+diff;
        g.setY(newY);
    }
}
