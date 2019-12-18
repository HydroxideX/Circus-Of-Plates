package eg.edu.alexu.csd.oop.ClassesImplemented.Stick;

import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.ImageObject;
import eg.edu.alexu.csd.oop.ClassesImplemented.Utils.Loader;
import eg.edu.alexu.csd.oop.ClassesImplemented.Observer;

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