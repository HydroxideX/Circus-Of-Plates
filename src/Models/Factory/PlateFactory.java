package Models.Factory;

import Models.Logger.GameLogger;
import Models.Plates.SpecialPlate;
import Models.Utils.Loader;
import Models.Plates.Plate;
import Models.Pool.PlatePool;
import Models.States.OnShelfState;
import View.game.GameObject;

import java.awt.image.BufferedImage;
import java.util.Random;

public class PlateFactory implements IPlateFactory {
    private static IPlateFactory pf = null;
    private static Loader loader;
    private static PlatePool platePool;
    private BufferedImage spriteImages;
    private Random rand;
    private String[] avaColors = new String[]{"blue", "black", "red", "yellow" , "orange", "gold" , "green", "purple", "pink"};
    private String dest = "Plates/", fileType = ".png";
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
        randNum = rand.nextInt(Types.length);
        String plateType = Types[randNum];
        String plateClassName = classesNames[randNum];
        Plate plate ;
        if (platePool.exists(color + plateType)) {
            plate = platePool.get(color + plateType);
        }
        else {
            spriteImages = loader.getImage((dest +color + plateType.toLowerCase() + fileType), 0.7);
            plate =(Plate) loader.getNewInstance(plateClassName);
            plate.setSpriteImages(spriteImages);
            plate.setColor(color);
        }
        plate.isVisible = true;
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("info", "Plate Created");
        plate.setState(new OnShelfState(plate));
        return (GameObject) plate;
    }
    public GameObject makeSpecialPlate(){
        Plate plate ;
        spriteImages = loader.getImage(dest + "special" + fileType , 0.7);
        plate =(Plate) new SpecialPlate();
        plate.setSpriteImages(spriteImages);
        plate.isVisible = true;
        plate.setState(new OnShelfState(plate));
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("config", "Special Plate Created");
        return (GameObject) plate;
    }
}
