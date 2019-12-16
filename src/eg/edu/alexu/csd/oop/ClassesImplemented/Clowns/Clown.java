package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import eg.edu.alexu.csd.oop.ClassesImplemented.Observer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
        notifyObservers(mX-this.x);
        this.x = mX;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }


}
