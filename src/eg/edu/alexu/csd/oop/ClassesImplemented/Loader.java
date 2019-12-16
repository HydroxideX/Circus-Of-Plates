package eg.edu.alexu.csd.oop.ClassesImplemented;

import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.game.GameObject;
import org.imgscalr.Scalr;
import org.reflections.Reflections;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Loader {
    private static Loader img = null;
    private Reflections ref = new Reflections();
    private ClassLoader classLoader;

    private Loader() {
    }

    public static synchronized Loader getInstance() {
        if (img == null) {
            img = new Loader();
        }
        return img;
    }

    public BufferedImage getImage(String path, double scale) {
        // System.out.println(path);
        classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(path.toLowerCase());
        BufferedImage bufferedImage;
        try {
            // return Thumbnails.of(ImageIO.read(new File(path))).scale(scale).asBufferedImage();
            bufferedImage = ImageIO.read(new File(path));
            int width = (int) (bufferedImage.getWidth() * scale), height = (int) (bufferedImage.getHeight() * scale);
            bufferedImage = Scalr.resize(bufferedImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, width, height, Scalr.OP_ANTIALIAS);
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BufferedImage getImageWithLengthAndWidth(String path, int length, int width) {
        // System.out.println(path);
        classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(path.toLowerCase());
        BufferedImage bufferedImage;
        try {
            // return Thumbnails.of(ImageIO.read(new File(path))).scale(scale).asBufferedImage();
            bufferedImage = ImageIO.read(new File(path));
            bufferedImage = Scalr.resize(bufferedImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, width, length, Scalr.OP_ANTIALIAS);
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] getSupportedClasses(Class<?> classToFind) {
        Set<Class<? extends GameObject>> c = ref.getSubTypesOf(GameObject.class);
        ArrayList<String> supportedClasses = new ArrayList<String>();
        Iterator<Class<? extends GameObject>> it = c.iterator();
        int i = 0;
        while (it.hasNext()) {
            Class<?> classTemp = it.next();
            if (classToFind.isAssignableFrom(classTemp) && !classToFind.equals(classTemp)) {
                supportedClasses.add(classTemp.getName());
                //System.out.println(supportedClasses.get(i));
                i++;
            }
        }
        String[] s = new String[supportedClasses.size()];
        for (int j = 0; j < supportedClasses.size(); j++) s[j] = supportedClasses.get(j);
        return s;
    }

    public String[] getSupportedPlateTypes(String[] classNames) {
        int sz = classNames.length;
        String[] supportedTypes = new String[sz];
        for (int i = 0; i < sz; i++) {
            Plate g = (Plate) this.getNewInstance(classNames[i]);
            if (g != null) supportedTypes[i] = g.getType();
            //  System.out.println(supportedTypes[i]);

        }
        return supportedTypes;
    }

    public GameObject getNewInstance(String s) {
        try {
            return (GameObject) Class.forName(s).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
