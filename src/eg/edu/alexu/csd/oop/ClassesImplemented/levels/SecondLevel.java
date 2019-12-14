package eg.edu.alexu.csd.oop.ClassesImplemented.levels;

import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.Clown;
import eg.edu.alexu.csd.oop.ClassesImplemented.Clowns.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecondLevel implements World {

    private int width;
    private int height;
    private String status;
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private  List<GameObject> constantObjects;
    private  List<GameObject> movableObjects;
    private   List<GameObject> controlableObjects;
    boolean finished = true;
    public SecondLevel (int width,int height) {
        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controlableObjects = new ArrayList<>();
        this.width= width;
        this.height= height;
        ImageObject firstClown = new Clown(100, 100, "Resources/images.jpg", 1);
        controlableObjects.add(firstClown);
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constantObjects;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return movableObjects;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return controlableObjects;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean refresh() {
        GameObject clown;
        Iterator it = controlableObjects.iterator();
       /* while (it.hasNext()) {
            clown = (GameObject) it.next();
            for (GameObject m : movableObjects) {
                m.setY((m.getY() + 1));
                if (m.getY() == getHeight()) {
                    // reuse the star in another position
                    m.setY(-1 * (int) (Math.random() * getHeight()));
                    m.setX((int) (Math.random() * getWidth()));
                }
                m.setX(m.getX() + (Math.random() > 0.5 ? 1 : -1));
            }
            // collecting astronauts
            for (GameObject c : constantObjects) {
                if (c.isVisible()) {
                    if (intersect(c, spaceShip)) {
                        score++;    // get score
                        ((ImageObject) c).setVisible(false);
                    } else if (Math.random() > 0.999)
                        ((ImageObject) c).setVisible(false);    // lost the astronauts
                } else {
                    ((ImageObject) c).setVisible(true);
                    // reuse the astronaut in another position
                    c.setX((int) (getWidth() * 0.9 * Math.random()));
                    c.setY((int) (getHeight() * 0.9 * Math.random()));
                }
            }
         }
        */
        return finished;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public int getSpeed() {
        return 25;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }
}
