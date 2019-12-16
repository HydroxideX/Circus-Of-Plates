package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import eg.edu.alexu.csd.oop.ClassesImplemented.ArrayListIterator;
import eg.edu.alexu.csd.oop.ClassesImplemented.Loader;
import eg.edu.alexu.csd.oop.ClassesImplemented.Observer;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageObject implements GameObject {
    BufferedImage[] spriteImages = new BufferedImage[1];
    private ArrayList observers = new ArrayList();
    Loader loader;
    int x;
    private int y;
    private boolean visible;
    private int type;

    public ImageObject(int posX, int posY, String path) {
        this(posX, posY, path, 0);
    }

    public ImageObject(int posX, int posY, String path, int type) {
        this.x = posX;
        this.y = posY;
        this.type = type;
        this.visible = true;
        loader = Loader.getInstance();
        spriteImages[0] = loader.getImage(path, 0.1);
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int mX) {
        this.x = mX;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int mY) {
        this.y = mY;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }


    @Override
    public int getWidth() {
        return spriteImages[0].getHeight();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getWidth();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(int diff) {
        ArrayListIterator iterator = new ArrayListIterator(observers);
        while (iterator.hasNext()){
            Observer observer = (Observer)iterator.next();
            observer.update(diff);
        }
    }
}
