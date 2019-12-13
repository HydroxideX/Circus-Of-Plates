package eg.edu.alexu.csd.oop.ClassesImplemented;

import com.sun.prism.Image;
import eg.edu.alexu.csd.oop.game.GameObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class ImageLoader {
    private static ImageLoader img = null;

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        if (img == null) {
            img = new ImageLoader();
        }
        return (ImageLoader) img;
    }

    public BufferedImage getImage(String path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
