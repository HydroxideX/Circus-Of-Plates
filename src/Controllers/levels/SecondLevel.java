package Controllers.levels;

import Controllers.Difficulty.Medium;
import Models.BackGround.BackGroundFactory;
import Models.Clowns.Clown;
import Models.Clowns.ClownFactory;
import Models.Factory.PlateFactory;
import Models.Logger.GameLogger;
import Models.Pool.PlatePool;
import Models.Shelfs.ShelfObject;
import Models.Stick.StickFactory;
import Controllers.ShelfHandler;
import View.game.GameObject;

import java.util.ArrayList;

public class SecondLevel extends newWorld {

    public SecondLevel (int width,int height,String clownPath) {
        speed = new Medium();
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        ReplayWorld.allData.clear();
        BackGroundFactory backGroundFactory = BackGroundFactory.getInstance();
        ClownFactory clownFactory = ClownFactory.getInstance();
        StickFactory stickFactory = StickFactory.getInstance();
        this.width= width;
        this.height= height;
        this.levelMode = 2;
        pf = (PlateFactory) PlateFactory.getInstance();
        pp = (PlatePool)PlatePool.getInstance();
        GameObject background = backGroundFactory.getBackGround(0,0,1200,600,"images.jpg");
        constantObjects.add(background);
        Clown firstClown = clownFactory.getclown(200, 400, clownPath, 1);
        clownsArray.add(firstClown);
        clownsX = new Integer[clownsArray.size()];
        addClownsAndEverything(clownsArray,sticksArray,movableObjects,controlableObjects,clownsX);
        shelfhandler = new ShelfHandler(movableObjects,constantObjects,levelMode *3);
        ShelfObject sh;
        for(int i=1 ;i<=levelMode ; i++) {
            sh = new ShelfObject(0, 30*i+35*(i-1));
            shelfhandler.addShelf(sh);
            constantObjects.add(sh);
        }
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("fine", "World Created");
    }
}
