package Models.Stick;

import Models.Clowns.ImageObject;

import java.io.Serializable;

public class Stick extends ImageObject implements Observer, Serializable {

    @Override
    public boolean update(int diff) {
        if(this.getX() + diff < 0) return false;
        if(this.getX() + this.getWidth() + diff > 1200) return false;
        this.setX(this.getX()+diff);
        notifyObservers(diff);
        return true;
    }

}