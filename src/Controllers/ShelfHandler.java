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

    public ShelfHandler( List<GameObject> movingObjects,List<GameObject> constatntObjects, int mode) {
        this.constatntObjects = constatntObjects;
        this.movingObjects = movingObjects;
        shelfObjects = new ArrayList<Shelf>();
        shelfs = new ArrayList<ShelfObject>();
        this.mode = mode;
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("info", "Shelf Handler Created");
    }

    public void addShelf(ShelfObject sh) {
        shelfs.add(sh);
        minY = sh.getY();
        shelfObjects.add(new Shelf(movingObjects, constatntObjects, minX, maxX, minY, direction));
        minX = (minX == 1200) ? 0 : 1200;
        maxX = (minX == 1200) ? 0 : 1200;
        direction = -direction;
    }

    public void throwPlates() {
        for (int i = 0; i < shelfObjects.size(); i++) shelfObjects.get(i).throwPlate(mode);
    }

    public void makePlates() {
        for (int i = 0; i < shelfObjects.size(); i++) shelfObjects.get(i).makePlate(mode);
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
