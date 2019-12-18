package eg.edu.alexu.csd.oop.ClassesImplemented.Utils;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;
import java.util.Random;

public class Randomizer {
    private static Randomizer rand =null;
    private static ArrayList<GameObject> movableObjects , constObjects;
    Random randNum ;
 public Randomizer(ArrayList<GameObject> movableObjects ,ArrayList<GameObject> constantObjects) {
     randNum= new Random();
        this.movableObjects = movableObjects ;
        this.constObjects = constantObjects;
    }
    public void throwPlate (){
     int x = randNum.nextInt(movableObjects.size()-2)+1;
    }
}
