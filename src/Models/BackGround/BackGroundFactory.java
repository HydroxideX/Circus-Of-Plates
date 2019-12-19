package Models.BackGround;

import Models.Utils.Loader;

public class BackGroundFactory {
    private static BackGroundFactory backgroundFactory = new BackGroundFactory();
    private BackGroundFactory(){
    }

    public static BackGroundFactory getInstance(){
        return backgroundFactory;
    }


    public Background getBackGround(int x,int y,int width,int height, String path){
        Background background= new Background();
        background.setX(x);
        background.setY(y);
        background.width = width;
        background.height = height;
        Loader loader = Loader.getInstance();
        background.spriteImages[0] = loader.getImageWithLengthAndWidth(path, height, width);
        return background;
    }
}
