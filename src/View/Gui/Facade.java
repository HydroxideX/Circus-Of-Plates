package View.Gui;

import Controllers.levels.*;
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
        newWorld World;
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
            World=new ThirdLevel(1200, 600,clownPath);
            final GameEngine.GameController gameController = GameEngine.start("Murder Of The Clown",World, menuBar,JFrame.DISPOSE_ON_CLOSE, Color.WHITE);

            newMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.changeWorld(World);
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

            World=new SecondLevel(1200, 600,clownPath);
            final GameEngine.GameController gameController = GameEngine.start("Murder Of The Clown",World, menuBar, JFrame.DISPOSE_ON_CLOSE, Color.WHITE);

            newMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.changeWorld(World);
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

            World=new FirstLevel(1200, 600,clownPath);
            final GameEngine.GameController gameController = GameEngine.start("Murder Of The Clown", World, menuBar, JFrame.DISPOSE_ON_CLOSE, Color.WHITE);

            newMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.changeWorld(World);
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
            World=new ReplayWorld(1200, 600,clownPath);
            final GameEngine.GameController gameController = GameEngine.start("Murder Of The Clown", World, menuBar, JFrame.DISPOSE_ON_CLOSE, Color.WHITE);

            newMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.changeWorld(World);
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
