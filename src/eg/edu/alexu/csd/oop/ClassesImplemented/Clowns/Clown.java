package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import eg.edu.alexu.csd.oop.ClassesImplemented.Loader;

public class Clown extends ImageObject {


    public Clown(int posX, int posY, String path) {
        super(posX, posY, path);
        loader = Loader.getInstance();
        spriteImages[0] = loader.getImageWithLengthAndWidth(path, 200,200);
    }

    public Clown(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
        loader = Loader.getInstance();
        spriteImages[0] = loader.getImageWithLengthAndWidth(path, 200, 200);
        System.out.println(spriteImages[0].getHeight() + " "+spriteImages[0].getWidth());
    }

    @Override
    public void setY(int mY) {

    }

    @Override
    public void setX(int mX) {
        if(!notifyObservers(mX - this.x)) return;
        this.x = mX;
    }

}
