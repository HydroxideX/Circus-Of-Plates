package View.Gui;

import Controllers.levels.FirstLevel;
import Controllers.levels.ReplayWorld;
import Controllers.levels.SecondLevel;
import Controllers.levels.ThirdLevel;
import View.game.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Facade {
    private static String levelName;
    public static String clownPath;
    public Facade(String levelName, String clownPath)
    {
        Facade.levelName =levelName;
        Facade.clownPath =clownPath;
    }
    public void Start () {
        JMenuBar  menuBar = new JMenuBar();;
        JMenu menu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menuBar.add(menu);
        if(levelName.equals("level3")) {

            final GameEngine.GameController gameController = GameEngine.start("Murder Of The Clown", new ThirdLevel(1200, 600,clownPath), menuBar,JFrame.DISPOSE_ON_CLOSE, Color.WHITE);

            newMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.changeWorld(new ThirdLevel(1200, 600, clownPath));
                }
            });

            pauseMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.pause();
                }
            });
            resumeMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.resume();
                }
            });
        }
        else if(levelName.equals("level2")) {

            final GameEngine.GameController gameController = GameEngine.start("Murder Of The Clown", new SecondLevel(1200, 600,clownPath), menuBar, JFrame.DISPOSE_ON_CLOSE, Color.WHITE);

            newMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.changeWorld(new SecondLevel(1200, 600, clownPath));
                }
            });

            pauseMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.pause();
                }
            });
            resumeMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.resume();
                }
            });
        }
        else if(levelName.equals("level1")) {

            final GameEngine.GameController gameController = GameEngine.start("Murder Of The Clown", new FirstLevel(1200, 600,clownPath), menuBar, JFrame.DISPOSE_ON_CLOSE, Color.WHITE);

            newMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.changeWorld(new FirstLevel(1200, 600, clownPath));
                }
            });

            pauseMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.pause();
                }
            });
            resumeMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.resume();
                }
            });
        }
        else {
            final GameEngine.GameController gameController = GameEngine.start("Murder Of The Clown", new ReplayWorld(1200, 600,clownPath), menuBar, JFrame.DISPOSE_ON_CLOSE, Color.WHITE);

            newMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.changeWorld(new ReplayWorld(1200, 600, clownPath));
                }
            });

            pauseMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.pause();
                }
            });
            resumeMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.resume();
                }
            });
        }
    }
}
