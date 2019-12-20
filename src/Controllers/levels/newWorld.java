package Controllers.levels;

import Controllers.Difficulty.Speed;
import Models.BackGround.BackGroundFactory;
import View.Gui.EndGame;
import View.Gui.Gui;
import Models.Utils.ArrayIterator;
import Models.Utils.ArrayListIterator;
import Models.Clowns.Clown;
import Models.Stick.Stick;
import Models.Factory.PlateFactory;
import Models.Plates.Plate;
import Models.Pool.PlatePool;
import Models.States.StackedState;
import Controllers.ShelfHandler;
import Models.Utils.intersectPlates;
import View.game.GameObject;
import View.game.World;
import View.Gui.Facade;
import javafx.application.Platform;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class newWorld implements World {
    Speed speed;
    PlateFactory pf;
    int time = 0,time_2=0;
    PlatePool pp;
    Stick stick1;
    Stick stick2;
    int width, height;
    String status = "Score: ";
    int score = 0, levelMode;
    long startTime = System.currentTimeMillis();
    List<GameObject> constantObjects;
    List<GameObject> movableObjects;
    List<GameObject> controlableObjects;
    ArrayList<Pair<Stick, Integer>> sticksArray = new ArrayList<>();
    ArrayList<Clown> clownsArray = new ArrayList<>();
    intersectPlates intersection = new intersectPlates();
    //static ArrayList <ArrayList <GameObject> > allData;
    Integer[] clownsX;
    ShelfHandler shelfhandler;
    long startSpecial;
    boolean specialMode=false;
    private BackGroundFactory backGroundFactory = BackGroundFactory.getInstance();
    GameObject storeBackground;
    int storeSpeed;
    ArrayList<Clown> storeClownsArray = new ArrayList<>();

    public void addClownsAndEverything(ArrayList<Clown> clownsArray, ArrayList<Pair<Stick, Integer>> sticksArray, List<GameObject> movableObjects, List<GameObject> controlableObjects, Integer[] clownsX) {
        ArrayListIterator iterator = new ArrayListIterator(clownsArray);
        int currentClown = 0;
        while (iterator.hasNext()) {
            Clown clown = (Clown) iterator.next();
            clownsX[currentClown++] = clown.getX();
            controlableObjects.add(clown);
            movableObjects.add(clown.stick1);
            movableObjects.add(clown.stick2);
            sticksArray.add(new Pair<>(clown.stick1, clown.stick1.getY()));
            sticksArray.add(new Pair<>(clown.stick2, clown.stick2.getY()));
            clown.registerObserver(clown.stick1);
            clown.registerObserver(clown.stick2);
        }
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
        long currentTime = System.currentTimeMillis();
        if(score == 5){
            endGameWin();
            return false;
        }
        if(Gui.checkClosed())return false;
        if((currentTime-startTime)/1000 >= 125){
            endGameLose();
            return false;
        }
        Iterator it = constantObjects.iterator();
        ArrayList removed = new ArrayList();
        for (int i = 0; i < levelMode+1 && (it.hasNext()); i++)
            it.next();

        time++;
        time_2++;
        if (time == 100) {
            time = 0;
        }
       shelfhandler.updateShelfs();
        while (it.hasNext()) {
            Plate m = (Plate) it.next();
            m.update(1);
            if (m.getY() == getHeight()) {
                it.remove();
            }
            int[] z = {score};
            if (intersection.intersect(m, sticksArray, z, movableObjects)) {
                m.setState(new StackedState(m));
                removed.add(m);
            }
            if (m.getType().equals("SpecialPlate")&&intersection.isSpecial){
                startSpecial=System.currentTimeMillis();
                specialMode=true;
                GameObject background1 = backGroundFactory.getBackGround(0,0,1200,600,"boom2.jpg");
                intersection.isSpecial = false;
                storeBackground=constantObjects.get(0);
                constantObjects.set(0,background1);
                storeSpeed=speed.getControlSpeed();
                speed.setControlSpeed(storeSpeed*2);
               /* Iterator iterator = clownsArray.iterator();
                while(iterator.hasNext()){
                    storeClownsArray.add((Clown) iterator.next());
                }*/
                /*for (int i=0; i<clownsArray.size(); i++){
                    Clown newOne;
                    int x=clownsArray.get(i).getX();
                    int y=clownsArray.get(i).getY();
                   if(Facade.clownPath.contains("1")||Facade.clownPath.contains("2")) {
                       newOne= ClownFactory.getInstance().getclown(x,y,"Clown/goku.png",1);
                       clownsArray.set(i,newOne);
                   }
                }*/
                int x=clownsArray.get(0).getX();
                int y=clownsArray.get(0).getY();
                Clown newOne=ClownFactory.getInstance().getclown(x,y,"Clown/clown4.png",1);
                clownsArray.set(0,newOne);
            }
            score = z[0];
        }
        /*  if ((currentTime-startSpecial)/1000>2 && (currentTime-startSpecial)/1000<15 && specialMode){
            GameObject background1 = backGroundFactory.getBackGround(0,0,1200,600,"boom2.jpg");
            constantObjects.set(0,background1);

        }*/
        if ((currentTime-startSpecial)/1000>15 && specialMode){
            specialMode=false;
            constantObjects.set(0,storeBackground);
            speed.setControlSpeed(storeSpeed);
        }
        if (time == 0)
            shelfhandler.throwPlates();
        if(time_2==900){shelfhandler.makeSpecialPlates();time_2=0;}
        it = removed.iterator();
        while (it.hasNext()) {
            constantObjects.remove(it.next());
        }
        ArrayIterator iterator = new ArrayIterator(clownsX);
        ArrayListIterator iterator1 = new ArrayListIterator(clownsArray);
        int diff = clownsArray.get(0).getX() - clownsX[0];
        Clown clown;
        while (iterator.hasNext()) {
            clown = (Clown) iterator1.next();
            Integer x = (Integer) iterator.next();
            if (diff != clown.getX() - x) {
                iterator = new ArrayIterator(clownsX);
                iterator1 = new ArrayListIterator(clownsArray);
                while (iterator.hasNext()) {
                    clown = (Clown) iterator1.next();
                    clown.setX((Integer) iterator.next());
                }
                break;
            }
        }
        iterator1 = new ArrayListIterator(clownsArray);
        int counter = 0;
        while (iterator1.hasNext()) {
            clown = (Clown) iterator1.next();
            clownsX[counter++] = clown.getX();
        }
        SnapShot snapShot=new SnapShot();
        snapShot.addMomentToArray(constantObjects,movableObjects,controlableObjects);
        return true;
    }

    boolean hagarb7aga=false;

    void endGameWin () {
        //Application.launch(EndGame.class);
        if(!hagarb7aga){
            Platform.runLater(()->{
                EndGame endGame =new EndGame(true);
                endGame.start(Gui.habala);
            });
            hagarb7aga=true;
        }
    }

    void endGameLose(){
        if(!hagarb7aga){
            Platform.runLater(()->{
                EndGame endGame =new EndGame(false);
                endGame.start(Gui.habala);
            });
            hagarb7aga=true;
        }

    }

    @Override
    public String getStatus() {
        return status + score + "                     Current Time: "+ ((System.currentTimeMillis() - startTime)/1000-5);
    }

    @Override
    public int getSpeed() {
        return speed.getSpeed();
    }

    @Override
    public int getControlSpeed() {
        return speed.getControlSpeed();
    }

}
