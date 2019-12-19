package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

import eg.edu.alexu.csd.oop.ClassesImplemented.Facade;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Collections;

public class Levels extends Application {
    public static String clownPath="Clown/clown2.png";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox=new VBox();
        vBox.setSpacing(10);
        vBox.setBackground(
                new Background(null,
                        Collections.singletonList(new BackgroundImage(
                                new Image("Resources/menuBackground.png", 300, 400, false, true),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                BackgroundSize.DEFAULT))));
        vBox.setAlignment(Pos.CENTER);
        ImageView clown= null;
        clown = new ImageView(new Image("Resources/Buttons/EasyB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
        Button level1 = new Button(null, clown);
        DropShadow shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        DropShadow finalShadow3 = shadow;
        level1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        level1.setEffect(finalShadow3);
                    }
                });
//Removing the shadow when the mouse cursor is off
        level1.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        level1.setEffect(null);
                    }
                });
        level1.setTranslateY(-20);
        level1.setStyle("-fx-background-color: transparent;");
        level1.setOnAction(e->{
            Facade facade =new Facade("level1",clownPath);
            facade.Start();
           // playMusic();
            Gui gui=new Gui();
            gui.start(primaryStage);
            primaryStage.toBack();
        });
        clown = new ImageView(new Image("Resources/Buttons/MediumB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
        Button level2 = new Button(null, clown);
         shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        DropShadow finalShadow = shadow;
        level2.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        level2.setEffect(finalShadow);
                    }
                });
//Removing the shadow when the mouse cursor is off
        level2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        level2.setEffect(null);
                    }
                });

        level2.setTranslateY(-20);
        level2.setStyle("-fx-background-color: transparent;");
        level2.setOnAction(e->{
            Facade facade =new Facade("level2",clownPath);
            facade.Start();
            //playMusic();
            Gui gui=new Gui();
            gui.start(primaryStage);
            primaryStage.toBack();

        });
        clown = new ImageView(new Image("Resources/Buttons/HardB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
        Button level3 = new Button(null, clown);
        shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        DropShadow finalShadow1 = finalShadow;
        DropShadow finalShadow4 = finalShadow1;
        level3.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        level3.setEffect(finalShadow4);
                    }
                });
//Removing the shadow when the mouse cursor is off
        level3.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        level3.setEffect(null);
                    }
                });
        level3.setTranslateY(-20);
        level3.setStyle("-fx-background-color: transparent;");
        level3.setOnAction(e->{
            Facade facade =new Facade("level3",clownPath);
            facade.Start();
            playMusic();
            Gui gui=new Gui();
            gui.start(primaryStage);
            primaryStage.toBack();
        });
        clown = new ImageView(new Image("Resources/Buttons/BackB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
        Button back= new Button(null, clown);
         finalShadow1 = finalShadow;
        DropShadow finalShadow2 = finalShadow1;
        DropShadow finalShadow6 = finalShadow2;
        back.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        back.setEffect(finalShadow6);
                    }
                });
//Removing the shadow when the mouse cursor is off
        back.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        back.setEffect(null);
                    }
                });
        back.setTranslateY(-30);
        back.setStyle("-fx-background-color: transparent;");

        back.setOnAction(e->{
            //primaryStage.close();
           /* Gui.levels=Gui.current;
            Gui.current=Gui.gui;
            Gui.current.show();*/
            Gui gui=new Gui();
            gui.start(primaryStage);
        });
        clown = new ImageView(new Image("Resources/Buttons/replayB.png"));
        clown.setFitWidth(60);
        clown.setFitHeight(30);
        finalShadow1 = finalShadow;
        finalShadow2 = finalShadow1;
        DropShadow finalShadow5 = finalShadow2;
        Button replay=new Button(null,clown);
        replay.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        replay.setEffect(finalShadow5);
                    }
                });
//Removing the shadow when the mouse cursor is off
        replay.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        replay.setEffect(null);
                    }
                });
        replay.setTranslateY(-20);
        replay.setStyle("-fx-background-color: transparent;");
        replay.setOnAction(e->{
            try
           {
               Facade facade =new Facade("ay 7aga",clownPath);
               facade.Start();
               //playMusic();
               Gui gui=new Gui();
               gui.start(primaryStage);
               primaryStage.toBack();
           }catch (Exception ex)
           {
               Alert a = new Alert(Alert.AlertType.NONE);
               a.setAlertType(Alert.AlertType.ERROR);
               a.setHeaderText("Play a game to watch the Replay!");
               // show the dialog
               a.show(); }
        });
        vBox.getChildren().addAll(level1,level2,level3,replay,back);
        primaryStage.setScene(new Scene(vBox,300,400));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
       // primaryStage.showAndWait();
    }
    private void playMusic()
    {
        Gui.mediaPlayer.setMute(true);
        if(!Gui.muteAudio)
        {
            Gui.mediaPlayer.pause();
            Gui.mediaPlayer = Gui.mediaPlayers.get(0);
           Gui.mediaPlayer.play();
        }
    }
}
