package eg.edu.alexu.csd.oop.ClassesImplemented.Utils;

import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.IPlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.PlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.ClassesImplemented.States.FallingState;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Randomizer {
    private static Randomizer rand =null;
    private static List<GameObject> movableObjects , constantObjects;
    private static IPlateFactory pf ;
    Random randNum ;
 public Randomizer(List<GameObject> movableObjects , List<GameObject> constantObjects) {
     randNum= new Random();
     pf = PlateFactory.getInstance();
        this.movableObjects = movableObjects ;
        this.constantObjects = constantObjects;
    }
    public void throwPlate (int sticks,int diff){
     int x = randNum.nextInt(movableObjects.size()-sticks)+sticks;
        List<GameObject> removed = new ArrayList<GameObject>();
     for(int i=0 ;i<x ; i++){
         int y = randNum.nextInt(movableObjects.size()-sticks)+sticks;
         Plate g = (Plate) movableObjects.get(y);
         movableObjects.remove(g);
         constantObjects.add(g);
         g.setState(new FallingState(g));
     }
     for(int i=0 ;i<x ;i++)movableObjects.add( pf.makePlate(diff));
         }
}
