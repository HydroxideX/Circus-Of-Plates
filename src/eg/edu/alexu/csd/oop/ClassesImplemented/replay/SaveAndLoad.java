package eg.edu.alexu.csd.oop.ClassesImplemented.replay;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveAndLoad {
    static ArrayList <ArrayList <GameObject> > allData = new ArrayList<>();
    public static void clearFile(){
        XMLEncoder xmlEncoder = null;
        try {
            allData.clear();
            xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("lastGame.xml")));
            xmlEncoder.writeObject(allData);
            xmlEncoder.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Empty");
        }
    }

    public static void save(List<GameObject> constant, List <GameObject> movable, List <GameObject> controlable) {
        ArrayList <GameObject> allArray = new ArrayList<>();

        allArray.addAll(constant);
        allArray.addAll(movable);
        allArray.addAll(controlable);
        try {
            XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("lastGame.xml")));
            allData = (ArrayList<ArrayList<GameObject>>) xmlDecoder.readObject();
            allData.add(allArray);
            xmlDecoder.close();
            XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("lastGame.xml")));
            xmlEncoder.writeObject(allData);
            xmlEncoder.close();

        } catch (FileNotFoundException e) {
            System.out.println("Wrong ");
        }
    }

    public static ArrayList<ArrayList<GameObject>> load(){
        try {
            XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("lastGame.xml")));
            allData = (ArrayList<ArrayList<GameObject>>) xmlDecoder.readObject();
            xmlDecoder.close();
            return allData;
        } catch (Exception e){
            System.out.println("File Not Found");
        }
        return null;
    }
}
