package eg.edu.alexu.csd.oop.ClassesImplemented;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;

public class Background implements GameObject {
    private int x,y,width,height;
    BufferedImage[] spriteImages = new BufferedImage[1];
    public Background(int x, int y, int width, int height ,String path){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Loader loader = Loader.getInstance();
        spriteImages[0] = loader.getImageWithLengthAndWidth(path, height, width);
    }
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int p0) {
        x = p0;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int p0) {
        y = p0;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }
}
