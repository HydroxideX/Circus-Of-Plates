package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.BackGround.Background;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.ImageObject;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates.Plate;
import eg.edu.alexu.csd.oop.ClassesImplemented.Shelfs.ShelfObject;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SnapShot {
    public void addMomentToArray(List<GameObject>constantObjects,List<GameObject>movableObjects,List<GameObject>controlableObjects){
        ArrayList<GameObject> allArray = new ArrayList<>();
        iterateAndAddArray(constantObjects,allArray);
        iterateAndAddArray(movableObjects,allArray);
        iterateAndAddArray(controlableObjects,allArray);
        ReplayWorld.allData.add(allArray);
    }

    private void iterateAndAddArray(List<GameObject> temp , ArrayList<GameObject> array){
        Iterator it= temp.iterator();
        while (it.hasNext()){
            GameObject current = cloneGameObject((GameObject) it.next());
            array.add(current);
        }
    }

    private GameObject cloneGameObject(GameObject x){
        if(x.getClass().getName().toLowerCase().contains("clown") || x.getClass().getName().toLowerCase().contains("stick")){
            try {
                ImageObject v = (ImageObject) ((ImageObject) x).clone();
                return v;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        } else if(x.getClass().getName().toLowerCase().contains("shelf")){
            try {
                ShelfObject v = (ShelfObject) ((ShelfObject) x).clone();
                return v;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }else if(x.getClass().getName().toLowerCase().contains("background")){
            try {
                Background v = (Background) ((Background) x).clone();
                return v;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }else {
            try {
                Plate v = (Plate) ((Plate) x).clone();
                return v;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
