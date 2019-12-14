package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Clown;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.ArrayList;
import java.util.List;

public class ThirdLevel implements World {

    private int width, height;
    private String status;
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private  List<GameObject> constantObjects;
    private  List<GameObject> movableObjects;
    private   List<GameObject> controlableObjects;
    public ThirdLevel (int width,int height) {
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        this.width= width;
        this.height= height;
        ImageObject xr = new Clown(100, 100, "Resources/images.jpg", 1);
        controlableObjects.add(xr);
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constantObjects;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return movableObjects;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return controlableObjects;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }



    @Override
    public boolean refresh() {
        GameObject spaceShip = controlableObjects.get(0);
        return true;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public int getSpeed() {
        return 50;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }
}
