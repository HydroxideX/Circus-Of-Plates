// 
// Decompiled by Procyon v0.5.36
// 

package eg.edu.alexu.csd.oop.game;

import java.util.List;

public interface World
{
    List<GameObject> getConstantObjects();
    
    List<GameObject> getMovableObjects();
    
    List<GameObject> getControlableObjects();
    
    int getWidth();
    
    int getHeight();
    
    boolean refresh();
    
    String getStatus();
    
    int getSpeed();
    
    int getControlSpeed();
}
