package eg.edu.alexu.csd.oop.ClassesImplemented.Utils;

import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.IPlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.PlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {
    private static IPlateFactory pf;
    Random randNum;
    //private  Randomizer rand =null;
    private List<GameObject> movableObjects, constantObjects;
    private List<GameObject> platesOnShelf;
    int minX = 0;

    public Randomizer(List<GameObject> movableObjects, List<GameObject> constantObjects) {
        randNum = new Random();
        pf = PlateFactory.getInstance();
        this.movableObjects = movableObjects;
        this.constantObjects = constantObjects;
        platesOnShelf = new ArrayList<GameObject>();
        /*for (int i = 0; i < 10; i++) {
            Plate p = (Plate) pf.makePlate(3);
            p.setX(0);
            platesOnShelf.add(p);
            movableObjects.add(p);
        }*/
    }

    public void makePlate(int mode) {
        Plate p;
        if (movableObjects.size() > 3) {
            p = (Plate) movableObjects.get(movableObjects.size() - 1);
            if (/*movableObjects.size() > 10 ||*/ p.getX() - 100 < 0) {
                //System.out.println(p.getX());
                return;
            }
        }
        p = (Plate) pf.makePlate(3);
        p.setX(minX + 50);
        p.setY(45);
        System.out.println(p.getX());
        movableObjects.add(p);
        platesOnShelf.add(p);
        //System.out.println(movableObjects.size() + " ");
    }

    public void update() {
        for (int i = 2; i < movableObjects.size(); i++) {
            Plate p = (Plate) movableObjects.get(i);
            //System.out.println(p.getX());
            if (i  == 2 && p.getX() != 1150)
                p.update(1);
            else if (i-1 >1){
                Plate p_2 = (Plate) movableObjects.get(i - 1);
                System.out.println(p.getX() +" "+p_2.getX());
                if (p_2.getX() - p.getX() > 100)
                    p.update(1);
            }
        }
    }

    public void throwPlate(int sticks, int diff) {
    }
     /*
     int x = randNum.nextInt(movableObjects.size()-sticks)+sticks;
        //List<GameObject> removed = new ArrayList<GameObject>();
     for(int i=0 ;i<x ; i++){
         int y = randNum.nextInt(movableObjects.size()-sticks)+sticks;
         Plate g = (Plate) movableObjects.get(y);
         movableObjects.remove(g);
         constantObjects.add(g);
         g.setState(new FallingState(g));
     }
     for(int i=0 ;i<x ;i++)movableObjects.add( pf.makePlate(diff));
         }*/

}
