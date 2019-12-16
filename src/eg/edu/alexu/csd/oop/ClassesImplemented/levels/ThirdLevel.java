package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Clown;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.ImageObject;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Stick;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.IPlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.PlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.PlateWithBase;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Pool.PlatePool;
import eg.edu.alexu.csd.oop.ClassesImplemented.States.StackedState;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import javafx.print.PageLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThirdLevel implements World {
    PlateFactory pf;
    PlatePool pp ;
    Stick stick1;
    Stick stick2;
    private int width, height;
    private String status = "Score: ";
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private  List<GameObject> constantObjects;
    private  List<GameObject> movableObjects;
    private   List<GameObject> controlableObjects;
    private int intersectionHeight,intersectionHeight2;
    public ThirdLevel (int width,int height) {
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        this.width= width;
        this.height= height;
        pf = (PlateFactory) PlateFactory.getInstance();
        pp = (PlatePool)PlatePool.getInstance();
        Clown xr = new Clown(500, 480, "Resources/Clown/clown1.png", 1);
        controlableObjects.add(xr);
       /* stick1 = new Stick(465,490,"Resources/Sticks/leftstick_2.png");
        movableObjects.add(stick1);
        stick2 = new Stick(700,490,"Resources/Sticks/rightstick_2.png");
        movableObjects.add(stick2);
        xr.registerObserver(stick1);
        xr.registerObserver(stick2);
        intersectionHeight = stick1.getY();
        intersectionHeight2 = stick2.getY();*/
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
        Iterator it = movableObjects.iterator();
        ArrayList removed = new ArrayList();
        while (it.hasNext()){
            Plate m = (Plate) it.next() ;
            m.setY((m.getY() + 1));
            if(m.getY() == getHeight()){
               // pp.add( m);
                it.remove();
            }
            /*if (intersect(m)) {
                m.setState(new StackedState(m));
                removed.add(m);
                movableObjects.add(m);
            }*/
        }
        if(movableObjects.size() < 10)
        movableObjects.add(pf.makePlate());
        /*it = removed.iterator();
        while(it.hasNext()){
            constantObjects.remove(it.next());
        }*/
        return true;
    }


    boolean intersect(Plate m){
        int center = (2*m.getX() + m.getWidth()) / 2;
        if(m.getY() == intersectionHeight && center < stick1.getX()+ stick1.getWidth() && center > stick1.getX()) {
            intersectionHeight -= m.getHeight();
            m.setY(intersectionHeight);
            m.setX(( 2*stick1.getX()+ stick1.getWidth())/2 - 30);
            stick1.registerObserver(m);
            return true;
        }
        if(m.getY() == intersectionHeight2 && center < stick2.getX()+ stick2.getWidth() && center > stick2.getX()) {
            intersectionHeight2 -= m.getHeight();
            m.setY(intersectionHeight2);
            stick2.registerObserver(m);
            m.setX(( 2*stick2.getX()+ stick2.getWidth())/2 - 30);
            return true;
        }
        return false;
    }

    @Override
    public String getStatus() {
        return status+ " "+ score;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }
}
