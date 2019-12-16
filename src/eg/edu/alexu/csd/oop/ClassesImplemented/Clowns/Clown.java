package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import eg.edu.alexu.csd.oop.ClassesImplemented.Observer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Clown extends ImageObject {
    private ArrayList observers = new ArrayList();

    public Clown(int posX, int posY, String path) {
        super(posX, posY, path);
    }

    public Clown(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
    }

    @Override
    public void setY(int mY) {

    }

    @Override
    public void setX(int mX) {
        notifyObservers(this.x-mX);
        this.x = mX;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(int diff) {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(diff);
        }
    }

}
