package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import eg.edu.alexu.csd.oop.ClassesImplemented.Observer;

import java.util.ArrayList;

public class Stick extends ImageObject implements Observer {

    private ArrayList observers = new ArrayList();


    public Stick(int posX, int posY, String path) {
        super(posX, posY, path);
    }

    @Override
    public void update(int diff) {
        this.setX(this.getX()+diff);
        notifyObservers(diff);
    }
}
