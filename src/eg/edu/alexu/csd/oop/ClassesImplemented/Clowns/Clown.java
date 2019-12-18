package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import eg.edu.alexu.csd.oop.ClassesImplemented.ArrayListIterator;
import eg.edu.alexu.csd.oop.ClassesImplemented.Utils.Loader;
import eg.edu.alexu.csd.oop.ClassesImplemented.Observer;

import java.util.ArrayList;

public class Clown extends ImageObject {
    public Stick stick1 = new Stick(465,490,"Resources/Sticks/leftstick_2.png");
    public Stick stick2 = new Stick(700,490,"Resources/Sticks/rightstick_2.png");

    public Clown(int posX, int posY, String clownPath, int type) {
        super(posX, posY, clownPath, type);
        loader = Loader.getInstance();
        if(clownPath.contains("1") || clownPath.contains("2") ) {
            spriteImages[0] = loader.getImage(clownPath, 0.08);
            stick1 = new Stick(this.getX()-15,this.getY()+ 20,"Resources/Sticks/leftstick_2.png");
            stick2 = new Stick(this.getX()+70,this.getY()+20,"Resources/Sticks/rightstick_2.png");
        }
        else {
            spriteImages[0] = loader.getImage(clownPath, 0.08);
            stick1 = new Stick(this.getX()-15,this.getY()+35,"Resources/Sticks/leftstick_2.png");
            stick2 = new Stick(this.getX()+48,this.getY() + 35,"Resources/Sticks/rightstick_2.png");
        }
    }

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


