// 
// Decompiled by Procyon v0.5.36
// 

package View.game;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class ArrowsKeyAction extends AbstractAction
{
    private static final long serialVersionUID = 1L;
    private AnimationPanel draw;
    private Direction direction;
    
    public ArrowsKeyAction(final AnimationPanel draw, final Direction direction) {
        this.draw = draw;
        this.direction = direction;
    }
    
    public void incrementX(final boolean right) {
        for (final GameObject o : this.draw.world.getControlableObjects()) {
            final ControlableObject data = this.draw.getControlableData(o);
            data.setOldX(o.getX());
            if (right) {
                o.setX(Math.min(this.draw.getWidth() - o.getWidth(), o.getX() + this.draw.controlSpeed));
            }
            else {
                o.setX(Math.max(0, o.getX() - this.draw.controlSpeed));
            }
            data.setMoved(true);
            if (right) {
                data.setState((data.getState() + 1) % o.getSpriteImages().length);
            }
            else {
                data.setState((data.getState() - 1 + o.getSpriteImages().length) % o.getSpriteImages().length);
            }
        }
    }
    
    public void incrementY(final boolean down) {
        for (final GameObject o : this.draw.world.getControlableObjects()) {
            final ControlableObject data = this.draw.getControlableData(o);
            data.setOldY(o.getY());
            if (down) {
                o.setY(Math.min(this.draw.getHeight() - o.getHeight(), o.getY() + this.draw.controlSpeed));
            }
            else {
                o.setY(Math.max(0, o.getY() - this.draw.controlSpeed));
            }
            data.setMoved(true);
            if (down) {
                data.setState((data.getState() + 1) % o.getSpriteImages().length);
            }
            else {
                data.setState((data.getState() - 1 + o.getSpriteImages().length) % o.getSpriteImages().length);
            }
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (this.draw.gameOver) {
            return;
        }
        switch (this.direction) {
            case UP: {
                this.incrementY(false);
                break;
            }
            case DOWN: {
                this.incrementY(true);
                break;
            }
            case LEFT: {
                this.incrementX(false);
                break;
            }
            case RIGHT: {
                this.incrementX(true);
                break;
            }
        }
    }
}
