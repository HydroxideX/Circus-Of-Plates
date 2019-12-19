package Models.Utils;

import Models.Stick.Stick;
import Models.Plates.Plate;
import View.game.GameObject;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class intersectPlates {
    public boolean isSpecial=false;
    public boolean intersect(Plate m, ArrayList <Pair<Stick,Integer> > sticksArray, int[] score, List<GameObject> movableObjects){
        ArrayListIterator iterator = new ArrayListIterator(sticksArray);
        while (iterator.hasNext()) {
            Object currentElement = iterator.next();
            int center = (2*m.getX() + m.getWidth()) / 2;
            Pair < Stick, Integer> current = (Pair<Stick, Integer>) currentElement;
            int intersectionHeight = current.getValue();
            Stick stick = current.getKey();
            if(m.getY()+m.getHeight() == intersectionHeight && center-30 < stick.getX()+ stick.getWidth() && center+30 > stick.getX()) {
                if (m.getType().equals("SpecialPlate")) {
                    // constantObjects.remove(m);
                    isSpecial=true;
                    return true;
                } else {
                    intersectionHeight -= m.getHeight();
                    m.setY(intersectionHeight);
                    m.setX((2 * stick.getX() + stick.getWidth()) / 2 - 32);
                    stick.registerObserver(m);
                    movableObjects.add(m);
                    if (checkColor(stick)) {
                        intersectionHeight = removeLastThree(stick, intersectionHeight, movableObjects);
                        score[0]++;
                    }
                    sticksArray.remove(current);
                    current = new Pair<>(stick, intersectionHeight);
                    sticksArray.add(current);
                    return true;
                }
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
