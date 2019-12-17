package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.ArrayListIterator;
import eg.edu.alexu.csd.oop.ClassesImplemented.Background;
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
    int time = 0;
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
    public ThirdLevel (int width,int height,String clownPath) {
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        this.width= width;
        this.height= height;
        pf = (PlateFactory) PlateFactory.getInstance();
        pp = (PlatePool)PlatePool.getInstance();
        Clown firstClown = new Clown(500, 480, clownPath, 1);
        controlableObjects.add(firstClown);
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
        Iterator it = constantObjects.iterator();
        ArrayList removed = new ArrayList();
        if(it.hasNext())
        it.next();
        time++;
        if(time == 300){
            time = 0;
        }
        while (it.hasNext()){
            Plate m = (Plate) it.next();
            m.setY((m.getY() + 1));
            if(m.getY() == getHeight()){
                it.remove();
            }
            if (intersect(m)) {
                m.setState(new StackedState(m));
                removed.add(m);
            }
        }
        if(time == 0)
            constantObjects.add(pf.makePlate(11));
        it = removed.iterator();
        while(it.hasNext()){
            constantObjects.remove(it.next());
        }
        return true;
    }


    boolean intersect(Plate m){
        int center = (2*m.getX() + m.getWidth()) / 2;
        if(m.getY()+m.getHeight() == intersectionHeight && center < stick1.getX()+ stick1.getWidth() && center > stick1.getX()) {
            intersectionHeight -= m.getHeight();
            m.setY(intersectionHeight);
            m.setX(( 2*stick1.getX()+ stick1.getWidth())/2 - 30);
            stick1.registerObserver(m);
            movableObjects.add(m);
            if(checkColor(stick1,1)){
                removeLastThree(stick1,1);
                score++;
            }
            return true;
        }
        if(m.getY()+m.getHeight() == intersectionHeight2 && center < stick2.getX()+ stick2.getWidth() && center > stick2.getX()) {
            intersectionHeight2 -= m.getHeight();
            m.setY(intersectionHeight2);
            stick2.registerObserver(m);
            m.setX(( 2*stick2.getX()+ stick2.getWidth())/2 - 30);
            movableObjects.add(m);
            if(checkColor(stick2,2)){
                removeLastThree(stick2,2);
                score++;
            }
            return true;
        }
        return false;
    }

    private boolean checkColor(Stick stick,int stickNo){
        String lastColor="";
        String color = "";
        int count = 0;
        Iterator it = stick.observers.iterator();
        while(it.hasNext()){
            Plate current = (Plate)it.next();
            color = current.getColor();
            if(color.equals(lastColor)) count++;
            else count = 0;
            if(count == 2) return true;
            lastColor = color;
        }
        return false;
    }

    private void removeLastThree(Stick stick,int stickNo){
        Iterator it = new ArrayListIterator(stick.observers);
        for(int i = 0;i <3 ;i++) {
            Plate m = (Plate)getLastAndRemove(stick);
            movableObjects.remove(m);
            if (stickNo == 1) {
                intersectionHeight += m.getHeight();
            } else {
                intersectionHeight2 += m.getHeight();
            }
        }
    }

    private Object getLastAndRemove(Stick stick){
        Iterator it = new ArrayListIterator(stick.observers);
        Plate m = new Plate();
        while(it.hasNext()){
            m = (Plate)it.next();
        }
        it.remove();
        return m;
    }

    @Override
    public String getStatus() {
        return status+ " "+ score;
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
