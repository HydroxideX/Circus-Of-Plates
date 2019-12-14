package eg.edu.alexu.csd.oop.ClassesImplemented;

import com.sun.prism.Image;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.game.GameObject;
import org.reflections.Reflections;

import java.io.File;
import java.lang.reflect.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Loader {
    private static Loader img = null;
    private Reflections ref = new Reflections();
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
       // System.out.println(path);
        classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(path.toLowerCase());
        try {
            return  ImageIO.read(new File(path));
          //  return ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String [] getSupportedTypes (){
        Plate plate ;
        Set<Class<? extends Plate>> c = ref.getSubTypesOf(Plate.class);
        String [] supportedTypes = new String[c.size()];
        Iterator<Class<? extends Plate>> it = c.iterator();
        int i = 0;
        while(it.hasNext()){
            try {
                plate = it.next().newInstance() ;
                supportedTypes[i++] = plate.getType();
                System.out.println(supportedTypes[i-1]);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return supportedTypes;
        /*
        try {
            plate = (Plate) Class.forName(name).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }*/
    }
}
