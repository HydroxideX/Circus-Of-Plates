// 
// Decompiled by Procyon v0.5.36
// 

package eg.edu.alexu.csd.oop.game;

class MovableObject extends ConstantObject
{
    private int oldX;
    private int oldY;
    
    public MovableObject(final GameObject gameObject) {
        this.oldX = gameObject.getX();
        this.oldY = gameObject.getY();
    }
    
    public int getOldX() {
        return this.oldX;
    }
    
    public void setOldX(final int oldMX) {
        this.oldX = oldMX;
    }
    
    public int getOldY() {
        return this.oldY;
    }
    
    public void setOldY(final int oldMY) {
        this.oldY = oldMY;
    }
}
