package eg.edu.alexu.csd.oop.ClassesImplemented.Utils;

import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.IPlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.PlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.ClassesImplemented.States.FallingState;
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
    int minX, minY ,maxX, diff;

    public Randomizer(List<GameObject> movableObjects, List<GameObject> constantObjects,int minX ,int maxX, int minY , int diff) {
        randNum = new Random();
        pf = PlateFactory.getInstance();
        this.movableObjects = movableObjects;
        this.constantObjects = constantObjects;
        platesOnShelf = new ArrayList<GameObject>();
        this.minX = minX ;
        this.minY = minY;
        this.diff = diff;
        this.maxX = maxX;
    }

    public void makePlate(int mode) {
        Plate p;
       if (platesOnShelf.size() > 0) {
            p = (Plate) platesOnShelf.get(platesOnShelf.size() - 1);
            if ((diff==1 && p.getX() - 100 < 0)|(diff==-1 && p.getX() + 100 > 1200)) {
                return;
            }
        }
        p = (Plate) pf.makePlate(mode);
        p.setX(minX);
        p.setY(minY-p.getYError());
        movableObjects.add(p);
        platesOnShelf.add(p);
    }
    public synchronized void  update() {
        for (int i = 0; i < platesOnShelf.size(); i++) {
            Plate p = (Plate) platesOnShelf.get(i);

            if (i == 0 && p.getX() != (int)Math.abs(maxX-50)) {
                p.update(diff);
            }
            else if (i>0) {
                Plate p_2 = (Plate) platesOnShelf.get(i-1);
                if (Math.abs(p_2.getX() - p.getX()) > 100)
                    p.update(diff);
            }
        }
    }

    public void throwPlate(int mode) {
        if (platesOnShelf.size() <10) {
            this.makePlate(mode);
            return;
        }
        int x = (platesOnShelf.size()==1)?0:(randNum.nextInt(platesOnShelf.size()-1)) ;
        Plate p = (Plate) platesOnShelf.get(x);
        platesOnShelf.remove(p);
        movableObjects.remove(p);
        p.setState(new FallingState(p));
        constantObjects.add(p);
        this.makePlate(mode);
    }

}
