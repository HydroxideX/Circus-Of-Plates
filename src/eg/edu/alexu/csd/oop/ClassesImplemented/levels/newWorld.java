package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.ArrayListIterator;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Clown;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Stick;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.PlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Pool.PlatePool;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shelfs.Shelf;
import eg.edu.alexu.csd.oop.ClassesImplemented.Utils.Randomizer;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class newWorld implements World {
    PlateFactory pf;
    int time = 0;
    PlatePool pp ;
    Stick stick1;
    Stick stick2;
    int width, height;
    String status = "Score: ";
    int score = 0;
    long startTime = System.currentTimeMillis();
    List<GameObject> constantObjects;
    List<GameObject> movableObjects;
    List<GameObject> controlableObjects;
    ArrayList<Pair<Stick,Integer>> sticksArray = new ArrayList<>();
    ArrayList <Clown> clownsArray = new ArrayList<>();
    intersectPlates intersection = new intersectPlates();
    Integer[] clownsX;
    Randomizer rm ;

    public void addClownsAndEverything(ArrayList <Clown> clownsArray, ArrayList<Pair<Stick,Integer>> sticksArray,List<GameObject> movableObjects, List<GameObject> controlableObjects, Integer[] clownsX){
        ArrayListIterator iterator = new ArrayListIterator(clownsArray);
        int currentClown = 0;
        while(iterator.hasNext()){
            Clown clown = (Clown)iterator.next();
            clownsX[currentClown++] = clown.getX();
            controlableObjects.add(clown);
            movableObjects.add(clown.stick1);
            movableObjects.add(clown.stick2);
            sticksArray.add(new Pair<>(clown.stick1,clown.stick1.getY()));
            sticksArray.add(new Pair<>(clown.stick2,clown.stick2.getY()));
            clown.registerObserver(clown.stick1);
            clown.registerObserver(clown.stick2);
        }

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
        return false;
    }

    @Override
    public String getStatus() {
        return status + score;
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
