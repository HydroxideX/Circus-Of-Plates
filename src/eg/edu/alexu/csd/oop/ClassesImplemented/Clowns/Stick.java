package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import eg.edu.alexu.csd.oop.ClassesImplemented.Utils.Loader;
import eg.edu.alexu.csd.oop.ClassesImplemented.Observer;

public class Stick extends ImageObject implements Observer {

    public Stick(int posX, int posY, String path) {
        super(posX, posY, path);
        loader = Loader.getInstance();
        spriteImages[0] = loader.getImage(path, 0.1);
    }

    @Override
    public boolean update(int diff) {
        if(this.getX() + diff < 0) return false;
        if(this.getX() + this.getWidth() + diff > 1000) return false;
        this.setX(this.getX()+diff);
        notifyObservers(diff);
        return true;
    }

}