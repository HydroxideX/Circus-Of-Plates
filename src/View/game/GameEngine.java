// 
// Decompiled by Procyon v0.5.36
// 

package View.game;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JMenuBar;

public class GameEngine
{
    public static GameController start(final String title, final World world) {
        return start(title, world, null, 3);
    }
    
    public static GameController start(final String title, final World world, final JMenuBar menuBar) {
        return start(title, world, menuBar, 3);
    }
    
    public static GameController start(final String title, final World world, final int onFrameCloseAction) {
        return start(title, world, null, onFrameCloseAction);
    }
    
    public static GameController start(final String title, final World world, final Color background) {
        return start(title, world, null, 3, background);
    }
    
    public static GameController start(final String title, final World world, final JMenuBar menuBar, final int onFrameCloseAction) {
        return start(title, world, menuBar, onFrameCloseAction, null);
    }
    
    public static GameController start(final String title, final World world, final JMenuBar menuBar, final Color background) {
        return start(title, world, menuBar, 3, background);
    }
    
    public static GameController start(final String title, final World world, final int onFrameCloseAction, final Color background) {
        return start(title, world, null, onFrameCloseAction, background);
    }
    
    public static GameController start(final String title, final World world, final JMenuBar menuBar, final int onFrameCloseAction, final Color background) {
        final GameController controller = new Controller(title, world, menuBar, onFrameCloseAction, background);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                controller.resume();
            }
        });
        return controller;
    }
    
    private static class Controller implements GameController
    {
        private final Timer timer;
        private final AnimationPanel panel;
        
        private Controller(final String title, final World world, final JMenuBar menuBar, final int onFrameCloseAction, final Color background) {
            this.panel = new AnimationPanel(world);
            final JFrame frame = new JFrame(title);
            frame.getContentPane().add(this.panel);
            if (menuBar != null) {
                frame.setJMenuBar(menuBar);
            }
            frame.setDefaultCloseOperation(onFrameCloseAction);
            frame.pack();
            this.panel.setBackground((background == null) ? Color.WHITE : background);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            final JPanel statusPanel = new JPanel();
            statusPanel.setBorder(new BevelBorder(1));
            frame.add(statusPanel, "South");
            statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 16));
            statusPanel.setLayout(new BoxLayout(statusPanel, 0));
            final JLabel statusLabel = new JLabel("");
            statusLabel.setHorizontalAlignment(2);
            statusPanel.add(statusLabel);
            frame.setVisible(true);
            this.timer = new Timer(world.getSpeed(), new SpinTimerListener(this.panel, statusLabel));
        }
        
        @Override
        public void pause() {
            this.timer.stop();
        }
        
        @Override
        public void resume() {
            this.timer.restart();
        }
        
        @Override
        public void changeWorld(final World world) {
            this.panel.init(world);
        }
    }
    
    public interface GameController
    {
        void pause();
        
        void resume();
        
        void changeWorld(final World p0);
    }
}
