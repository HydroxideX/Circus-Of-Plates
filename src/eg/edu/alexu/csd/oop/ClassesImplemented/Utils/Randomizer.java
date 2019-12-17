package eg.edu.alexu.csd.oop.ClassesImplemented.Utils;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;

public class Randomizer {
    private static Randomizer rand =null;
    private ArrayList<GameObject> movableObjects , constObjects;
    private Randomizer() {
    }

    public static synchronized Randomizer getInstance(ArrayList<GameObject> movableObjects ,ArrayList<GameObject> constantObjects) {
        if (rand == null) {
            rand = new Randomizer();
        }
        this.movableObjects = movableObjects ;
        this.constObjects = constantObjects;
        return rand;
    }

}
