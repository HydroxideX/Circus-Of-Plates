package Models.States;

import View.game.GameObject;

public class OnShelfState implements IState {
    GameObject g ;
    public OnShelfState (GameObject g){
        this.g = g;
    }
    @Override
    public void Update(int diff) {
        g.setX(g.getX()+diff);
    }
}
