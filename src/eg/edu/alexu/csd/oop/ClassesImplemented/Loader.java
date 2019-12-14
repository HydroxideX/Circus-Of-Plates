package eg.edu.alexu.csd.oop.ClassesImplemented;

import com.sun.prism.Image;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.game.GameObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Loader {
    private static Loader img = null;
private ClassLoader classLoader;
    private Loader() {
    }

    public static Loader getInstance() {
        if (img == null) {
            img = new Loader();
        }
        return (Loader) img;
    }

    public BufferedImage getImage(String path) {
        classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(path);
        try {
            return ImageIO.read(input);
          //  return ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
   /* public Plate getClass (String name){
        Plate plate ;
        try {
            plate = (Plate) Class.forName(name).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }*/
}
