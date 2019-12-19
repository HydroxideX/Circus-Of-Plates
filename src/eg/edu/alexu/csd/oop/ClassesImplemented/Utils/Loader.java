package eg.edu.alexu.csd.oop.ClassesImplemented.Utils;

import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.ISpecial;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.game.GameObject;
import org.imgscalr.Scalr;
import org.reflections.Reflections;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.security.CodeSource;
import java.util.*;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Loader {
    private static Loader img = null;
    private Reflections ref = new Reflections();
    private ClassLoader classLoader;
    private HashMap<String, BufferedImage> imgs;

    private Loader() {
        imgs = new HashMap<String, BufferedImage>();
        loadAllImages();
    }

    public static synchronized Loader getInstance() {
        if (img == null) {
            img = new Loader();
        }
        return img;
    }

    public void loadAllImages() {
        File[] f = new File(getClass().getClassLoader().getResource("resources/plates").getFile()).listFiles();
        for (File child : f) {
            String s = child.getPath().split("\\w+(\\\\?)(resources\\\\)")[1];
           // System.out.println(child.getName() + " " + s);
            imgs.put(child.getName(), getImage(s));
        }
    }

    public BufferedImage getImage(String path) {
        BufferedImage image = null;
        System.out.println(path);
        path = path.toLowerCase();
        //System.out.println(path);
        if (imgs.containsKey(path)) {
            //System.out.println(path);
            return imgs.get(path);
        } else {
            try {
                image = ImageIO.read(getClass().getClassLoader().getResource(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }

    public BufferedImage getImage(String path, double scale) {
        /*classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(path.toLowerCase());*/
        BufferedImage bufferedImage;
        bufferedImage = getImage(path);
        int width = (int) (bufferedImage.getWidth() * scale), height = (int) (bufferedImage.getHeight() * scale);
        bufferedImage = Scalr.resize(bufferedImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, width, height, Scalr.OP_ANTIALIAS);
        return bufferedImage;
    }

    public BufferedImage getImageWithLengthAndWidth(String path, int length, int width) {
        classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(path.toLowerCase());
        BufferedImage bufferedImage;
        bufferedImage = getImage(path);
        bufferedImage = Scalr.resize(bufferedImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, width, length, Scalr.OP_ANTIALIAS);
        return bufferedImage;
    }


    public String[] getSupportedClasses(Class<?> classToFind) {
        Set<Class<? extends GameObject>> c = ref.getSubTypesOf(GameObject.class);
        ArrayList<String> supportedClasses = new ArrayList<String>();
        Iterator<Class<? extends GameObject>> it = c.iterator();
        int i = 0;
        while (it.hasNext()) {
            Class<?> classTemp = it.next();
            if (classToFind.isAssignableFrom(classTemp) && !classToFind.equals(classTemp) && !ISpecial.class.isAssignableFrom(classTemp)) {
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
