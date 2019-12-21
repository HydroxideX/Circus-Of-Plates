package Controllers;

import Models.Logger.GameLogger;
import Models.Shelfs.ShelfObject;
import Models.Shelfs.Shelf;
import View.game.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShelfHandler {
    private List<GameObject> constatntObjects, movingObjects;
    private List<Shelf> shelfObjects;
    private List<ShelfObject> shelfs;
    private int minX = 0, maxX = 1200, minY, direction = 1, mode;
    GameLogger logger ;
    public ShelfHandler( List<GameObject> movingObjects,List<GameObject> constatntObjects, int mode) {
        this.constatntObjects = constatntObjects;
        this.movingObjects = movingObjects;
        shelfObjects = new ArrayList<Shelf>();
        shelfs = new ArrayList<ShelfObject>();
        this.mode = mode;
        logger= GameLogger.getInstance();
        logger.addLog("config", "Shelf Handler Created");
    }

    public void addShelf(ShelfObject sh) {
        shelfs.add(sh);
        minY = sh.getY();
        shelfObjects.add(new Shelf(movingObjects, constatntObjects, minX, maxX, minY, direction));
        minX = (minX == 1200) ? 0 : 1200;
        maxX = (minX == 1200) ? 0 : 1200;
        direction = -direction;
    logger.addLog("fine","A new Shelf was added to the screen");
        }

    public void throwPlates() {
        for (int i = 0; i < shelfObjects.size(); i++) shelfObjects.get(i).throwPlate(mode);
        logger.addLog("finest","plates were thrown Successfully from all Shelfs");

    }

    public void makePlates() {
        for (int i = 0; i < shelfObjects.size(); i++) shelfObjects.get(i).makePlate(mode);
        logger.addLog("finest","New plates were added Successfully to all Shelfs");
    }

    public void makeSpecialPlates(){
        Random rand =new Random();
        int randNum =  (shelfObjects.size()==1)?0:rand.nextInt(shelfObjects.size());
        shelfObjects.get(randNum).makeSpecialPlate();
    }
    public synchronized void updateShelfs() {
        for (int i = 0; i < shelfObjects.size(); i++) shelfObjects.get(i).update();

    }
}
