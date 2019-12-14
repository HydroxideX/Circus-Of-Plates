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
    public BufferedImage[] getSpriteImages() {
        BufferedImage[] spriteImages = new BufferedImage[1];
        try {
            spriteImages[0] = ImageIO.read(new File("Stick.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return spriteImages;
    }
}
