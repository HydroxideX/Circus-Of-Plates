// 
// Decompiled by Procyon v0.5.36
// 

package View.game;

import java.awt.image.BufferedImage;

public interface GameObject
{
    int getX();
    
    void setX(final int p0);
    
    int getY();
    
    void setY(final int p0);
    
    int getWidth();
    
    int getHeight();
    
    boolean isVisible();
    
    BufferedImage[] getSpriteImages();
}
