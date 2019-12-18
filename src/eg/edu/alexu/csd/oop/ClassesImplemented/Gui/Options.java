package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;


public class Options extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox=new VBox();
        vBox.setSpacing(10);
        try {
            vBox.setBackground(
                    new Background(null,
                            Collections.singletonList(new BackgroundImage(
                                    new Image(new FileInputStream("Resources/menuBackground.png"), 300, 400, false, true),
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundPosition.DEFAULT,
                                    BackgroundSize.DEFAULT))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        vBox.setAlignment(Pos.CENTER);
        ImageView clown= null;
        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Buttons/ChooseClown.png")));
            clown.setFitWidth(150);
            clown.setFitHeight(30);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button chooseChar= new Button(null, clown);

        DropShadow finalShadow2 =new DropShadow();
        DropShadow finalShadow1 = finalShadow2;
        DropShadow finalShadow4 = finalShadow1;
        chooseChar.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        chooseChar.setEffect(finalShadow4);
                    }
                });
//Removing the shadow when the mouse cursor is off
        chooseChar.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        chooseChar.setEffect(null);
                    }
                });
        chooseChar.setTranslateY(-20);
        chooseChar.setStyle("-fx-background-color: transparent;");
        chooseChar.setOnAction(e->{
            ChooseChar chooseChar1=new ChooseChar();
            chooseChar1.start(new Stage());
        });


        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Buttons/MusicB.png")));
            clown.setFitWidth(150);
            clown.setFitHeight(30);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button audio= new Button(null, clown);

         finalShadow2 =new DropShadow();
         finalShadow1 = finalShadow2;
        DropShadow finalShadow3 = finalShadow1;
        audio.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        audio.setEffect(finalShadow3);
                    }
                });
//Removing the shadow when the mouse cursor is off
        audio.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        audio.setEffect(null);
                    }
                });
        audio.setTranslateY(-20);
        audio.setStyle("-fx-background-color: transparent;");
        audio.setOnAction(e->{
            Gui.mediaPlayer.setMute(true);
            Gui.muteAduio= !Gui.muteAduio;
            Gui.mediaPlayer.setMute(true);
            if(!Gui.muteAduio) {
                String musicFile = "Resources/Audio/TheNightKing.mp3";     // For example
                Media sound = new Media(new File(musicFile).toURI().toString());
                Gui.mediaPlayer = new MediaPlayer(sound);
                Gui.mediaPlayer.setOnEndOfMedia(new Runnable() {
                    public void run() {
                        Gui.mediaPlayer.seek(Duration.ZERO);
                    }
                });
                Gui.mediaPlayer.play();
            }
        });
        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Buttons/BackB.png")));
            clown.setFitWidth(150);
            clown.setFitHeight(30);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button back= new Button(null, clown);

        finalShadow2 = new DropShadow();
        DropShadow finalShadow = finalShadow2;
        back.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        back.setEffect(finalShadow);
                    }
                });
//Removing the shadow when the mouse cursor is off
        back.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        back.setEffect(null);
                    }
                });
        back.setTranslateY(-20);
        back.setStyle("-fx-background-color: transparent;");

        back.setOnAction(e->{
            primaryStage.close();
        });

        vBox.getChildren().addAll(chooseChar,audio,back);
        primaryStage.setScene(new Scene(vBox,300,400));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
    }
}
