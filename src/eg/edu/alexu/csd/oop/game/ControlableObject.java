// 
// Decompiled by Procyon v0.5.36
// 

package eg.edu.alexu.csd.oop.game;

class ControlableObject extends MovableObject
{
    private boolean moved;
    
    public ControlableObject(final GameObject gameObject) {
        super(gameObject);
        this.moved = false;
    }
    
    public boolean isMoved() {
        return this.moved;
    }
    
    public void setMoved(final boolean moved) {
        this.moved = moved;
    }
}
