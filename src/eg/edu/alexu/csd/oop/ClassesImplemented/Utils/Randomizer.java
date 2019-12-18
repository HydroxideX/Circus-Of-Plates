package eg.edu.alexu.csd.oop.ClassesImplemented.Utils;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;

public class Randomizer {
    private static Randomizer rand =null;
    private static ArrayList<GameObject> movableObjects , constObjects;
 public Randomizer(ArrayList<GameObject> movableObjects ,ArrayList<GameObject> constantObjects) {

        this.movableObjects = movableObjects ;
        this.constObjects = constantObjects;
    }

}
