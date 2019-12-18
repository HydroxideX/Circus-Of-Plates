package eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory;

import eg.edu.alexu.csd.oop.ClassesImplemented.States.FallingState;
import eg.edu.alexu.csd.oop.ClassesImplemented.Utils.Loader;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Pool.PlatePool;
import eg.edu.alexu.csd.oop.ClassesImplemented.States.OnShelfState;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;
import java.util.Random;

public class PlateFactory implements IPlateFactory {
    private static IPlateFactory pf = null;
    private static Loader loader;
    private static PlatePool platePool;
    private BufferedImage spriteImages;
    private Random rand;
    private String[] avaColors = new String[]{"blue", "black", "red", "darkred", "yellow" , "orange", "gold" , "cyan" , "green", "purple", "pink"};
    private String dest = "Resources/plates/", fileType = ".png";
    private String[] Types ;
    private String []classesNames ;

    private PlateFactory() {
        platePool = PlatePool.getInstance();
        loader = Loader.getInstance();
        rand = new Random();
        classesNames = loader.getSupportedClasses(Plate.class);
        Types = loader.getSupportedPlateTypes(classesNames);
    }

    public static synchronized IPlateFactory getInstance() {
        if (pf == null) {
            pf = new PlateFactory();
        }
        return (IPlateFactory) pf;
    }

    public GameObject makePlate(int mode) {
        if(mode >avaColors.length || mode<0)return null;
        int randNum = rand.nextInt(mode);
        String color = avaColors[randNum];
        randNum = rand.nextInt(4);
        String plateType = Types[randNum];
        String plateClassName = classesNames[randNum];
        Plate plate ;
        if (platePool.exists(color + plateType)) {
            plate = platePool.get(color + plateType);
        }
        else {
            spriteImages = loader.getImage(dest + color + plateType + fileType , 0.7);
            plate =(Plate) loader.getNewInstance(plateClassName);
            plate.setSpriteImages(spriteImages);
            plate.setColor(color);
        }
        plate.setX(rand.nextInt(950));
        plate.setY(0);
        plate.isVisible = true;
        plate.setState(new FallingState(plate));
        return (GameObject) plate;
    }
}
