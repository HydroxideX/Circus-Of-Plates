package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Clown;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.ImageObject;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Stick;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.PlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.PlateWithBase;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Pool.PlatePool;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import javafx.print.PageLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThirdLevel implements World {
    PlateFactory pf;
    PlatePool pp ;
    private int width, height;
    private String status;
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private  List<GameObject> constantObjects;
    private  List<GameObject> movableObjects;
    private   List<GameObject> controlableObjects;
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
        Stick xrz = new Stick(465,490,"Resources/Sticks/leftstick_2.png");
        movableObjects.add(xrz);
        Stick xry = new Stick(590,485,"Resources/Sticks/rightstick_2.png");
        movableObjects.add(xry);
        xr.registerObserver(xrz);
        xr.registerObserver(xry);
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
        //GameObject spaceShip = controlableObjects.get(0);
        Iterator<GameObject> it = constantObjects.iterator();
        while (it.hasNext()){
            GameObject m = it.next() ;
            m.setY((m.getY() + 1));
            if(m.getY()==getHeight()){
                // reuse the star in another position
                pp.add((Plate) m);
                it.remove();
            }
        }
        constantObjects.add(pf.makePlate());
        return true;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }
}
