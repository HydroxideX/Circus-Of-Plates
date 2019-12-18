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

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class SaveAndLoad {
    ArrayList <ArrayList <GameObject> > allData = new ArrayList<>();

    public void save(GameObject allData1) {
        //this.allData = allData;
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("lastGame.xml")));
            xmlEncoder.writeObject(allData1);
            xmlEncoder.close();

        } catch (FileNotFoundException e) {
            System.out.println("Wrong ");
        }
    }

    public GameObject load(){
        try {
            XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("lastGame.xml")));
            GameObject allData1 = (GameObject) xmlDecoder.readObject();
            xmlDecoder.close();
            return allData1;
        } catch (Exception e){
            System.out.println("File Not Found");
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
        a.save((GameObject) zx);
        v = a.load();
        System.out.println(v);
    }

}
