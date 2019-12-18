package eg.edu.alexu.csd.oop.ClassesImplemented.Stick;

import eg.edu.alexu.csd.oop.ClassesImplemented.Utils.Loader;

public class StickFactory {
    static StickFactory stickUniqueFactory = new StickFactory();
    private StickFactory (){
    }

    public static StickFactory getInstance(){
        return stickUniqueFactory;
    }

    public Stick getstick(int x, int y,String path){
        Stick stick= new Stick();
        stick.setX(x);
        stick.setY(y);
        stick.setVisible(true);
        Loader loader = Loader.getInstance();
        stick.spriteImages[0] = loader.getImage(path, 0.1);
        return stick;
    }
}
