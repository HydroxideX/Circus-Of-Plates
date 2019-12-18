package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.BackGround.BackGroundFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.BackGround.Background;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Clown;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.ClownFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.PlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Pool.PlatePool;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shelfs.Shelf;
import eg.edu.alexu.csd.oop.ClassesImplemented.Stick.StickFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Utils.ShelfHandler;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;

public class SecondLevel extends newWorld {

    public SecondLevel (int width,int height,String clownPath) {
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        BackGroundFactory backGroundFactory = BackGroundFactory.getInstance();
        ClownFactory clownFactory = ClownFactory.getInstance();
        StickFactory stickFactory = StickFactory.getInstance();
        this.width= width;
        this.height= height;
        this.levelMode = 2;
        pf = (PlateFactory) PlateFactory.getInstance();
        pp = (PlatePool)PlatePool.getInstance();
        GameObject background = backGroundFactory.getBackGround(0,0,1200,600,"Resources/images.jpg");
        constantObjects.add(background);
        Clown firstClown = clownFactory.getclown(200, 400, clownPath, 1);
        clownsArray.add(firstClown);
        clownsX = new Integer[clownsArray.size()];
        addClownsAndEverything(clownsArray,sticksArray,movableObjects,controlableObjects,clownsX);
        shelfhandler = new ShelfHandler(movableObjects,constantObjects,levelMode *3);
        Shelf sh;
        for(int i=1 ;i<=levelMode ; i++) {
            sh = new Shelf(0, 30*i+35*(i-1));
            shelfhandler.addShelf(sh);
            constantObjects.add(sh);
        }
    }


    @Override
    public int getSpeed() {
        return 5;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }
}
