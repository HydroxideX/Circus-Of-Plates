package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import eg.edu.alexu.csd.oop.ClassesImplemented.Observer;

import java.util.ArrayList;

public class Stick extends ImageObject {

    private ArrayList observers;

    public Stick(int posX, int posY, String path) {
        super(posX, posY, path);
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers(int diff) {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(diff);
        }
    }
}
