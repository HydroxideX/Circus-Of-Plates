package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Clown extends ImageObject {
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
        this.x = mX;
    }

}
