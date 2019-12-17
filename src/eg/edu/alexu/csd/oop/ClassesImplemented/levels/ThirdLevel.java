package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.ArrayIterator;
import eg.edu.alexu.csd.oop.ClassesImplemented.ArrayListIterator;
import eg.edu.alexu.csd.oop.ClassesImplemented.Background;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Clown;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.PlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Pool.PlatePool;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shelfs.Shelf;
import eg.edu.alexu.csd.oop.ClassesImplemented.States.StackedState;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

public class ThirdLevel extends newWorld {

    public ThirdLevel (int width,int height,String clownPath) {
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        this.width= width;
        this.height= height;
        pf = (PlateFactory) PlateFactory.getInstance();
        pp = (PlatePool)PlatePool.getInstance();
        GameObject background = new Background(0,0,1000,700,"Resources/images.jpg");
        constantObjects.add(background);
        stick1 = new Stick(465,490,"Resources/Sticks/leftstick_2.png");
        movableObjects.add(stick1);
        stick2 = new Stick(700,490,"Resources/Sticks/rightstick_2.png");
        movableObjects.add(stick2);
        firstClown.registerObserver(stick1);
        firstClown.registerObserver(stick2);
        intersectionHeight = stick1.getY();
        intersectionHeight2 = stick2.getY();


        constantObjects.add(new Shelf(0 , 50));
        constantObjects.add(new Shelf(0 , 100));

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
        Clown firstClown = new Clown(200, 480, clownPath, 1);
        clownsArray.add(firstClown);
        Clown secondClown = new Clown(500, 480, clownPath, 1);
        clownsArray.add(secondClown);
        clownsX = new Integer[clownsArray.size()];
        addClownsAndEverything(clownsArray,sticksArray,movableObjects,controlableObjects,clownsX);
    }

    @Override
    public boolean refresh() {
        Iterator it = constantObjects.iterator();
        ArrayList removed = new ArrayList();
        for(int i=0 ;i<3 && it.hasNext() ; i++)
        it.next();
        time++;
        if(time == 300){
            time = 0;
        }
        while (it.hasNext()){
            Plate m = (Plate) it.next();
            m.update(1);
            //m.setY((m.getY() + 1));
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
            constantObjects.add(pf.makePlate(3));
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
        return 2;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }
}
