package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.ArrayIterator;
import eg.edu.alexu.csd.oop.ClassesImplemented.ArrayListIterator;
import eg.edu.alexu.csd.oop.ClassesImplemented.Background;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Clown;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.PlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Pool.PlatePool;
import eg.edu.alexu.csd.oop.ClassesImplemented.States.StackedState;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ThirdLevel extends newWorld {
    int swapTime = 0;
    public ThirdLevel (int width,int height,String clownPath) {
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        this.width= width;
        this.height= height;
        pf = (PlateFactory) PlateFactory.getInstance();
        pp = (PlatePool)PlatePool.getInstance();
        GameObject background = new Background(0,0,1200,600,"Resources/images.jpg");
        constantObjects.add(background);
        Clown firstClown = new Clown(200, 400, clownPath, 1);
        clownsArray.add(firstClown);
        clownsX = new Integer[clownsArray.size()];
        addClownsAndEverything(clownsArray,sticksArray,movableObjects,controlableObjects,clownsX);
    }

    @Override
    public boolean refresh() {
        Iterator it = constantObjects.iterator();
        ArrayList removed = new ArrayList();
        if(it.hasNext())
            it.next();
        time++;
        if(time == 150){
            time = 0;
        }
        swapTime++;
        if(swapTime == 300) {
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