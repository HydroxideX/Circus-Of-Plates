package Controllers.levels;

import Controllers.Difficulty.Hard;
import Models.BackGround.BackGroundFactory;
import Models.Clowns.Clown;
import Models.Clowns.ClownFactory;
import Models.Factory.PlateFactory;
import Models.Pool.PlatePool;
import Models.Shelfs.ShelfObject;
import Models.Stick.StickFactory;
import Controllers.ShelfHandler;
import View.game.GameObject;

import java.util.ArrayList;

public class ThirdLevel extends newWorld {
    int swapTime = 0;
    public ThirdLevel (int width,int height,String clownPath) {
        speed = new Hard();
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        ReplayWorld.allData.clear();
        BackGroundFactory backGroundFactory = BackGroundFactory.getInstance();
        ClownFactory clownFactory = ClownFactory.getInstance();
        StickFactory stickFactory = StickFactory.getInstance();
        this.width= width;
        this.height= height;
        this.levelMode = 3;
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

   /* public boolean refresh() {
        Iterator it = constantObjects.iterator();
        ArrayList removed = new ArrayList();
        if(it.hasNext())
            it.next();
        time++;
        if(time == 150){
            time = 0;
        }
        swapTime++;
        if(swapTime == 150) {
            swapTime = 0;
        }
        while (it.hasNext()){
            Plate m = (Plate) it.next();
            if(swapTime == 0) m.setX((int) (Math.random()*1000));
            m.update(1);
            if(m.getY() == getHeight()){
                it.remove();
            }
            int[] z = {score};
            if (intersection.intersect(m,sticksArray,z,movableObjects)) {
                m.setState(new StackedState(m));
                removed.add(m);
            }
            score = z[0];
        }
        if(time == 0)
            constantObjects.add(pf.makePlate(5));
        it = removed.iterator();
        while(it.hasNext()){
            constantObjects.remove(it.next());
        }
        ArrayIterator iterator = new ArrayIterator(clownsX);
        ArrayListIterator iterator1 = new ArrayListIterator(clownsArray);
        int diff = clownsArray.get(0).getX() - clownsX[0];
        Clown clown;
        while (iterator.hasNext()) {
            clown = (Clown) iterator1.next();
            Integer x = (Integer) iterator.next();
            if (diff != clown.getX() - x){
                iterator = new ArrayIterator(clownsX);
                iterator1 = new ArrayListIterator(clownsArray);
                while (iterator.hasNext()) {
                    clown = (Clown) iterator1.next();
                    clown.setX((Integer) iterator.next());
                }
                break;
            }
        }
        iterator1 = new ArrayListIterator(clownsArray);
        int counter = 0;
        while (iterator1.hasNext()) {
            clown = (Clown) iterator1.next();
            clownsX[counter++] = clown.getX();
        }
        return true;
    }*/
}