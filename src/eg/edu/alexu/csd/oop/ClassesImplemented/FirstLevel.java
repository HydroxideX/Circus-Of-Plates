package eg.edu.alexu.csd.oop.ClassesImplemented;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import javax.swing.*;
import java.awt.*;
import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
import java.util.List;

public class FirstLevel implements World {

    private int width, height, speed, controlSpeed;
    private String status = "12";
    private static int MAX_TIME = 1 * 60 * 1000;	// 1 minute
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private  List<GameObject> constantObjects;
    private  List<GameObject> movableObjects;
    private   List<GameObject> controlableObjects;
    public FirstLevel (int x,int y) {
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        ImageObject xr = new ImageObject(100, 100, "Resources/images.jpg", 1);
        controlableObjects.add(xr);
        width= 1000;
        height= 1500;
        speed = 10;
        controlSpeed = 50;
        status = "12";
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
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME; // time end and game over
        GameObject spaceShip = controlableObjects.get(0);
        return !timeout;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getControlSpeed() {
        return controlSpeed;
    }
}
