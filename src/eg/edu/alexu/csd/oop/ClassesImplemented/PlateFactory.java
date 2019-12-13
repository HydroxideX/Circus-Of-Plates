package eg.edu.alexu.csd.oop.ClassesImplemented;

import eg.edu.alexu.csd.oop.game.GameObject;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PlateFactory implements IPlateFactory {
    private static IPlateFactory pf = null;
    private static ImageLoader imgLoad;
    private static PlatePool platePool;
    private BufferedImage spriteImages;
    private Random rand ;
    private String[] avaColors = new String[]{"BLUE", "BLACK", "RED", "PURBLE", "LIGHT PURBLE", "DARKPURBLE", "DARKBLACK"};
private String dest = "Resources/plates/" , fileType = ".png";


    private PlateFactory() {
        platePool = PlatePool.getInstance();
        imgLoad = ImageLoader.getInstance();
        rand = new Random();
    }

    public static IPlateFactory getInstance() {
        if (pf == null) {
            pf = new PlateFactory();
        }
        return (IPlateFactory) pf;
    }

    public GameObject makePlate() {
        int randNum = rand.nextInt(6);
        String color = avaColors[randNum];
        Plate plate;
        if (platePool.exists(color)) {
            plate = platePool.get(color);
            plate.setX(rand.nextInt(1960));
            plate.setY(0);
            plate.isVisible = true;
            return (GameObject) plate;
        }
        spriteImages = imgLoad.getImage(dest + color + fileType);
        plate = new Plate(rand.nextInt(1960), 0, spriteImages.getWidth(), spriteImages.getHeight(), color, spriteImages);
        return (GameObject) plate;
    }
}
