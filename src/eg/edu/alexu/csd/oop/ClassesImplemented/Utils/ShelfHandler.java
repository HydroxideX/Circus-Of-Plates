package eg.edu.alexu.csd.oop.ClassesImplemented.Utils;

import eg.edu.alexu.csd.oop.ClassesImplemented.Shelfs.Shelf;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;
import java.util.List;

public class ShelfHandler {
    private List<GameObject> constatntObjects, movingObjects;
    private List<Randomizer> shelfObjects;
    private List<Shelf> shelfs;
    private int minX = 0, maxX = 1200, minY, direction = 1, mode;

    public ShelfHandler( List<GameObject> movingObjects,List<GameObject> constatntObjects, int mode) {
        this.constatntObjects = constatntObjects;
        this.movingObjects = movingObjects;
        shelfObjects = new ArrayList<Randomizer>();
        shelfs = new ArrayList<Shelf>();
        this.mode = mode;
    }

    public void addShelf(Shelf sh) {
        shelfs.add(sh);
        minY = sh.getY();
        shelfObjects.add(new Randomizer(movingObjects, constatntObjects, minX, maxX, minY, direction));
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
    public synchronized void updateShelfs() {
        for (int i = 0; i < shelfObjects.size(); i++) shelfObjects.get(i).update();

    }
}
