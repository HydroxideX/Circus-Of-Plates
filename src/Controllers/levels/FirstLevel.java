package Controllers.levels;

import Models.BackGround.BackGroundFactory;
import Models.Clowns.Clown;
import Models.Clowns.ClownFactory;
import Models.Factory.PlateFactory;
import Models.Pool.PlatePool;
import Models.Shelfs.ShelfObject;
import Models.Stick.StickFactory;
import Models.Utils.ShelfHandler;
import View.game.GameObject;

import java.util.ArrayList;

public class FirstLevel extends newWorld {

    public FirstLevel (int width,int height,String clownPath) {
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        ReplayWorld.allData.clear();
        BackGroundFactory backGroundFactory = BackGroundFactory.getInstance();
        ClownFactory clownFactory = ClownFactory.getInstance();
        StickFactory stickFactory = StickFactory.getInstance();
        this.width= width;
        this.height= height;
        this.levelMode = 1;
        pf = (PlateFactory) PlateFactory.getInstance();
        pp = (PlatePool)PlatePool.getInstance();
        GameObject background = backGroundFactory.getBackGround(0,0,1200,600,"images.jpg");
        constantObjects.add(background);
        Clown firstClown = clownFactory.getclown(200, 400, clownPath, 1);
        clownsArray.add(firstClown);
        clownsX = new Integer[clownsArray.size()];
        addClownsAndEverything(clownsArray,sticksArray,movableObjects,controlableObjects,clownsX);
        shelfhandler = new ShelfHandler(movableObjects,constantObjects,this.levelMode *3);
        ShelfObject sh;
        for(int i=1 ;i<=levelMode ; i++) {
            sh = new ShelfObject(0, 30*i+35*(i-1));
            shelfhandler.addShelf(sh);
            constantObjects.add(sh);
        }
    }

    @Override
    public int getSpeed() {
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }
}
