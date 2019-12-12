package eg.edu.alexu.csd.oop.ClassesImplemented;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import javax.swing.*;
import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
import java.util.List;

public class FirstLevel implements World {
    private Character player = new Character();

    private int width, height, speed, controlSpeed;
    private String status = "12";
    private boolean refreshWorked = true;
    private  List<GameObject> constantObjects;
    private  List<GameObject> movableObjects;
    private   List<GameObject> controlableObjects;
    public FirstLevel (int x,int y) {
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        controlableObjects.add(player);
        width= 100;
        height= 150;
        speed = 10;
        controlSpeed = 50;
        status = "12";
        refreshWorked = true;
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
        return refreshWorked;
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
