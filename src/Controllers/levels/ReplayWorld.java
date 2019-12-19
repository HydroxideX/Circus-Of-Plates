package Controllers.levels;

import View.game.GameObject;

import java.util.ArrayList;
import java.util.List;

public class ReplayWorld extends newWorld {
    public static ArrayList <ArrayList <GameObject> > allData=new ArrayList<>();

    int index = 0;
    public ReplayWorld (int width,int height,String clownPath)
    {
        this.width=width;
        this.height=height;
    }
    @Override
    public List<GameObject> getConstantObjects() {
        if(index < allData.size())
        return allData.get(index);
        if(allData.size()==0)
            return new ArrayList<>();
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
        if(index == allData.size()) return false;
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
