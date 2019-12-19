// 
// Decompiled by Procyon v0.5.36
// 

package View.game;

enum Direction
{
    UP("UP", 0, 38), 
    DOWN("DOWN", 1, 40), 
    LEFT("LEFT", 2, 37), 
    RIGHT("RIGHT", 3, 39);
    
    private int key;
    
    private Direction(final String name, final int ordinal, final int key) {
        this.key = key;
    }
    
    public int getKey() {
        return this.key;
    }
}
