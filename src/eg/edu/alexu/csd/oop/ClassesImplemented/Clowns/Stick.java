package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import eg.edu.alexu.csd.oop.ClassesImplemented.Loader;
import eg.edu.alexu.csd.oop.ClassesImplemented.Observer;

import java.util.ArrayList;

public class Stick extends ImageObject implements Observer {

    private ArrayList observers = new ArrayList();


    public Stick(int posX, int posY, String path) {
        super(posX, posY, path);
        loader = Loader.getInstance();
        spriteImages[0] = loader.getImage(path, 0.1);
    }

    @Override
    public boolean update(int diff) {
        if(this.getX() + diff < 0) return false;
        if(this.getX() + this.getWidth() > 1000) return false;
        this.setX(this.getX()+diff);
        notifyObservers(diff);
        return true;
    }
}