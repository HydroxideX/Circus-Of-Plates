package Models.Clowns;

import Models.Utils.ArrayListIterator;
import Models.Stick.Stick;
import Models.Stick.Observer;

import java.io.Serializable;

public class Clown extends ImageObject implements Serializable {
    public Stick stick1;
    public Stick stick2;

    @Override
    public void setY(int mY) {
    }

    @Override
    public void setX(int mX) {
        if(!notifyObservers(mX - this.x)) return;
        this.x = mX;
    }

    @Override
    public boolean notifyObservers(int diff) {
        ArrayListIterator iterator = new ArrayListIterator(observers);
        while (iterator.hasNext()){
            Observer observer = (Observer)iterator.next();
            boolean correct = observer.update(diff);
            if(!correct){
                ArrayListIterator iterator2 = new ArrayListIterator(observers);
                while (iterator2.hasNext()){
                    Observer observer2 = (Observer)iterator2.next();
                    if(observer2 == observer) break;
                    observer2.update(-diff);
                }
                return false;
            }
        }
        return true;
    }

}


