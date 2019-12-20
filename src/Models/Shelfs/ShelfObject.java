package Models.Shelfs;

import Models.Logger.GameLogger;
import Models.Utils.Loader;
import View.game.GameObject;

import java.awt.image.BufferedImage;

public class ShelfObject implements GameObject, Cloneable {
    private int x, y, width, height;
    private BufferedImage[] img = new BufferedImage[1];
    private Loader loader;
    private Boolean isvisible;

    public ShelfObject(int x, int y) {
        loader = Loader.getInstance();
        img[0] = loader.getImage("Shelfs/shelf.png", 1);
        this.width = img[0].getWidth();
        this.height = img[0].getHeight();
        this.x = x;
        this.y = y;
        this.isvisible = true;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int p0) {
        this.x = p0;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int p0) {
        this.y = p0;

    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public boolean isVisible() {
        return isvisible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return img;
    }

    public Object clone()  {

        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            GameLogger logger = GameLogger.getInstance();
            logger.addLog("severe", "No Object Created");
        }
        return null;
    }
}
