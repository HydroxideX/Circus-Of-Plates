package eg.edu.alexu.csd.oop.ClassesImplemented.replay;

import eg.edu.alexu.csd.oop.ClassesImplemented.BackGround.BackGroundFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.BackGround.Background;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Clown;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.ClownFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Stick.Stick;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Factory.PlateFactory;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.ClassesImplemented.Stick.StickFactory;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveAndLoadIO implements java.io.Serializable
{

    public void saveData(Object allData)
    {
        try
        {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("lastGame.xml"));
            os.writeObject(allData);
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public GameObject loadData()
    {
        try {
        GameObject allData;
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("lastGame.xml"));
            allData = (GameObject) is.readObject();
            is.close();
            return allData;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args){
        // Clown firstClown = new Clown(200, 400, "Clown/clown1.png", 1);
        PlateFactory x = (PlateFactory) PlateFactory.getInstance();
        Plate zx = (Plate) x.makePlate(5);
        SaveAndLoad a = new SaveAndLoad();
        ClownFactory clownFactory = ClownFactory.getInstance();
        StickFactory stickFactory = StickFactory.getInstance();
        BackGroundFactory backGroundFactory = BackGroundFactory.getInstance();
        GameObject background = backGroundFactory.getBackGround(0,0,1200,600,"images.jpg");
        Clown clown = clownFactory.getclown(0,0,"Clown/clown1.png",1);
        Stick stick = stickFactory.getstick(0,0,"Sticks/rightstick_2.png");
        a.save( background);
        GameObject v = a.load();
        System.out.println(v);
        a.save((GameObject) clown);
        v = a.load();
        System.out.println(v);
        a.save((GameObject) stick);
        v = a.load();
        System.out.println(v);
    }
}