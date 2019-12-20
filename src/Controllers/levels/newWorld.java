package Controllers.levels;

import Controllers.Difficulty.Speed;
import Models.BackGround.BackGroundFactory;
import Models.Clowns.ClownFactory;
import Models.Logger.GameLogger;
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
import javafx.stage.Stage;
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
    int platesSpeed = 1;
    //static ArrayList <ArrayList <GameObject> > allData;
    Integer[] clownsX;
    ShelfHandler shelfhandler;
    long startSpecial;
    boolean specialModeSeconds = false;
    boolean specialMode=false;
    private BackGroundFactory backGroundFactory = BackGroundFactory.getInstance();
    GameObject storeBackground;
    int storeSpeed;
    ArrayList<Clown> storeClownsArray = new ArrayList<>();
    boolean gameEnded = false;

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
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("info", "Added Starting Clowns");
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

    boolean hagarb7aga=false;
    @Override
    public boolean refresh() {
        if(gameEnded) return false;
        long currentTime = System.currentTimeMillis();
        if (score >= 10) {
            endGameWin();
            gameEnded = true;
            return false;
        }
        if(Gui.checkClosed())return false;
        if((currentTime-startTime)/1000 >= 120){
            endGameLose();
            gameEnded = true;
            return false;
        }
        hagarb7aga=false;
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
            int temp = score;
            int[] z = {score};
            if (intersection.intersect(m, sticksArray, z, movableObjects)) {
                m.setState(new StackedState(m));
                removed.add(m);
            }
            if (m.getType().equals("SpecialPlate")&&intersection.isSpecial){
                startSpecial=System.currentTimeMillis();
                GameObject background1 = backGroundFactory.getBackGround(0,0,1200,600,"boom.jpg");
                intersection.isSpecial = false;
                Iterator iterator = clownsArray.iterator();
                if(!specialMode) {
                    storeBackground=constantObjects.get(0);
                    constantObjects.set(0,background1);
                    while (iterator.hasNext()) {
                        storeClownsArray.add((Clown) iterator.next());
                    }
                }
                boolean first = false;
                for (int i=0; i<clownsArray.size(); i++){
                    Clown newOne;
                    int x=clownsArray.get(i).getX();
                    int y=clownsArray.get(i).getY();
                   if(Facade.clownPath.contains("1")) {
                       first = true;
                       newOne= ClownFactory.getInstance().getclown(x,y,"Clown/goku.png",1);
                   } else if(Facade.clownPath.contains("2")) {
                        first = true;
                        newOne= ClownFactory.getInstance().getclown(x,y,"Clown/goku2.png",1);
                    }else if  (Facade.clownPath.contains("3")){
                       first = false;
                       newOne= ClownFactory.getInstance().getclown(x,y,"Clown/goku3.png",1);
                   }else if  (Facade.clownPath.contains("4")){
                       first = false;
                       newOne= ClownFactory.getInstance().getclown(x,y,"Clown/goku4.png",1);
                   }else {
                       first = false;
                       newOne= ClownFactory.getInstance().getclown(x,y,"Clown/goku5.png",1);
                   }
                    newOne.stick1 = clownsArray.get(i).stick1;
                    newOne.stick2 = clownsArray.get(i).stick2;
                    newOne.registerObserver(newOne.stick1);
                    newOne.registerObserver(newOne.stick2);
                    controlableObjects.set(i,newOne);
                    clownsArray.set(i,newOne);
                }
                specialModeSeconds = true;
                specialMode=true;
            }
            if(specialMode){
                score = temp + (z[0]-temp) * 2;
            } else  {
                score = z[0];
            }
        }

        if ((currentTime-startSpecial)/1000>15 && specialMode) {
            specialMode=false;
            constantObjects.set(0,storeBackground);
            boolean first = false;
            for (int i=0; i<storeClownsArray.size(); i++){
                Clown newOne;
                controlableObjects.set(i,storeClownsArray.get(i));
                storeClownsArray.get(i).x = clownsArray.get(i).getX();
                clownsArray.set(i,storeClownsArray.get(i));
            }
            storeClownsArray.clear();
        }
        if (time == 0)
            shelfhandler.throwPlates();
        if(time_2==2000){shelfhandler.makeSpecialPlates();time_2=0;}
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

    void endGameWin () {
        //Application.launch(EndGame.class);
        if(!hagarb7aga){
            Platform.runLater(()->{
                EndGame endGame =new EndGame(true);
                endGame.start(new Stage());
            });
            hagarb7aga=true;
            GameLogger logger = GameLogger.getInstance();
            logger.addLog("info", "Game Ended");
        }
    }

    void endGameLose(){
        if(!hagarb7aga){
            Platform.runLater(()->{
                EndGame endGame =new EndGame(false);
                endGame.start(new Stage());
            });
            hagarb7aga=true;
            GameLogger logger = GameLogger.getInstance();
            logger.addLog("info", "Game Ended");
        }
    }

    @Override
    public String getStatus() {
        return status + score + "                     Current Time: "+ ((System.currentTimeMillis() - startTime)/1000);
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
