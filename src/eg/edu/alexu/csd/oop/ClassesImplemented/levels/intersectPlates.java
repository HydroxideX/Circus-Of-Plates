package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.ArrayListIterator;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Clown;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Stick;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.game.GameObject;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class intersectPlates {
    boolean intersect(Plate m, ArrayList <Pair<Stick,Integer> > sticksArray, int[] score, List<GameObject> movableObjects){
        ArrayListIterator iterator = new ArrayListIterator(sticksArray);
        while (iterator.hasNext()) {
            Object currentElement = iterator.next();
            int center = (2*m.getX() + m.getWidth()) / 2;
            Pair < Stick, Integer> current = (Pair<Stick, Integer>) currentElement;
            int intersectionHeight = current.getValue();
            Stick stick = current.getKey();
            if(m.getY()+m.getHeight() == intersectionHeight && center-30 < stick.getX()+ stick.getWidth() && center+30 > stick.getX()) {
                intersectionHeight -= m.getHeight();
                m.setY(intersectionHeight);
                m.setX(( 2*stick.getX()+ stick.getWidth())/2 - 30);
                stick.registerObserver(m);
                movableObjects.add(m);
                if(checkColor(stick)){
                    intersectionHeight = removeLastThree(stick, intersectionHeight,movableObjects);
                    score[0]++;
                }
                sticksArray.remove(current);
                current = new Pair<>(stick,intersectionHeight);
                sticksArray.add(current);
                return true;
            }
        }
        return false;
    }

    private boolean checkColor(Stick stick){
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

    private int removeLastThree(Stick stick,Integer stickHeight, List <GameObject> movableObjects){
        Iterator it = new ArrayListIterator(stick.observers);
        for(int i = 0;i <3 ;i++) {
            Plate m = (Plate)getLastAndRemove(stick);
            movableObjects.remove(m);
            stickHeight +=  m.getHeight();
        }
        return stickHeight;
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
}
