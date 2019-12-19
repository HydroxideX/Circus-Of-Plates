// 
// Decompiled by Procyon v0.5.36
// 

package View.game;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

class SpinTimerListener implements ActionListener
{
    AnimationPanel panel;
    JLabel statusBar;
    
    public SpinTimerListener(final AnimationPanel panel, final JLabel statusBar) {
        this.panel = panel;
        this.statusBar = statusBar;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        this.statusBar.setText(this.panel.world.getStatus());
        if (!this.panel.world.refresh()) {
            this.panel.gameOver = true;
        }
        for (final GameObject o : this.panel.world.getConstantObjects()) {
            final ConstantObject data = this.panel.getConstantData(o);
            data.setState((data.getState() + 1) % o.getSpriteImages().length);
            final int height;
            final int width = height = o.getWidth();
            final int x = o.getX();
            final int y = o.getY();
            this.panel.repaint(x, y, width, height);
        }
        for (final GameObject o : this.panel.world.getMovableObjects()) {
            final MovableObject data2 = this.panel.getMovableData(o);
            data2.setState((data2.getState() + 1) % o.getSpriteImages().length);
            final int height;
            final int width = height = o.getWidth();
            int x = data2.getOldX();
            int y = data2.getOldY();
            this.panel.repaint(x, y, width, height);
            x = o.getX();
            y = o.getY();
            data2.setOldX(x);
            data2.setOldY(y);
            this.panel.repaint(x, y, width, height);
        }
        for (final GameObject o : this.panel.world.getControlableObjects()) {
            final ControlableObject data3 = this.panel.getControlableData(o);
            final int delta = 20;
            final int height2;
            final int width2 = height2 = o.getWidth() + 2 * delta;
            if (data3.isMoved()) {
                final int x2 = data3.getOldX() - delta;
                final int y2 = data3.getOldY() - delta;
                this.panel.repaint(x2, y2, width2, height2);
            }
            final int x2 = o.getX() - delta;
            final int y2 = o.getY() - delta;
            this.panel.repaint(x2, y2, width2, height2);
            data3.setMoved(false);
        }
    }
}
