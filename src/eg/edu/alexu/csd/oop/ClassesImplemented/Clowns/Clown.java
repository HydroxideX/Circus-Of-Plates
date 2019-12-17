package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import eg.edu.alexu.csd.oop.ClassesImplemented.ArrayListIterator;
import eg.edu.alexu.csd.oop.ClassesImplemented.Utils.Loader;
import eg.edu.alexu.csd.oop.ClassesImplemented.Observer;

public class Clown extends ImageObject {


    public Clown(int posX, int posY, String path) {
        super(posX, posY, path);
        loader = Loader.getInstance();
        spriteImages[0] = loader.getImageWithLengthAndWidth(path, 200,200);
    }

    public Clown(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
        loader = Loader.getInstance();
        spriteImages[0] = loader.getImageWithLengthAndWidth(path, 200, 200);
        System.out.println(spriteImages[0].getHeight() + " "+spriteImages[0].getWidth());
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
