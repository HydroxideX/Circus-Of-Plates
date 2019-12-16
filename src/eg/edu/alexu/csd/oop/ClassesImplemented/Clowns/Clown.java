package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

public class Clown extends ImageObject {


    public Clown(int posX, int posY, String path) {
        super(posX, posY, path);
        spriteImages[0] = loader.getImageWithLengthAndWidth(path, 190,100);
}

    public Clown(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
        spriteImages[0] = loader.getImageWithLengthAndWidth(path, 190,100);
    }

    @Override
    public void setY(int mY) {

    }

    @Override
    public void setX(int mX) {
        notifyObservers(mX - this.x);
        this.x = mX;
    }

}
