package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.ArrayList;
import java.util.List;

public class ReplayWorld extends newWorld {
    int index = 0;
    public ReplayWorld(int width,int height,String clownPath)
    {
        this.width=width;
        this.height=height;
    }
    @Override
    public List<GameObject> getConstantObjects() {
        if(index < allData.size())
        return allData.get(index);
        return allData.get(allData.size()-1);
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return new ArrayList<>();
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return new ArrayList<>();
    }


    @Override
    public boolean refresh() {
        if(index == allData.size()) endGame();
        index++;
        return true;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getControlSpeed() {
        return 0;
    }
}
