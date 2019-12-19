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

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;


public class Gui extends Application {
static boolean creation=false;
    public static void main(String[] args) {
        launch(args);
    }
    static MediaPlayer mediaPlayer;
    static boolean muteAudio=false;
    static ArrayList<MediaPlayer> mediaPlayers;
    static File[] directoryListing;
    @Override
    public void start(Stage primaryStage) {

        VBox vBox =new VBox();
        vBox.setSpacing(15);
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
        clown = new ImageView(new Image("Resources/Buttons/PlayB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
        Button play = new Button(null, clown);
        DropShadow shadow = new DropShadow();
        DropShadow finalShadow3 = shadow;
        play.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        play.setEffect(finalShadow3);
                    }
                });
//Removing the shadow when the mouse cursor is off
        play.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        play.setEffect(null);
                    }
                });
        play.setTranslateY(-20);
        play.setStyle("-fx-background-color: transparent;");
        clown = new ImageView(new Image("Resources/Buttons/QuitB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
        Button exit = new Button(null, clown);
        DropShadow finalShadow4 = shadow;
        exit.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        exit.setEffect(finalShadow4);
                    }
                });
//Removing the shadow when the mouse cursor is off
        exit.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        exit.setEffect(null);
                    }
                });
        exit.setTranslateY(-20);
        exit.setStyle("-fx-background-color: transparent;");
        clown = new ImageView(new Image("Resources/Buttons/OptionsB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
        Button options = new Button(null, clown);
        DropShadow finalShadow5 = shadow;
        options.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        options.setEffect(finalShadow5);
                    }
                });
//Removing the shadow when the mouse cursor is off
        options.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        options.setEffect(null);
                    }
                });

        options.setTranslateY(-20);
        options.setStyle("-fx-background-color: transparent;");
        play.setOnAction(e->{

                Levels level=new Levels();
                level.start(primaryStage);
        });
        exit.setOnAction(e->{
            System.exit(0);
        });
        options.setOnAction(e->{
            Options options1 = new Options();
            options1.start(primaryStage);
        });
        vBox.getChildren().addAll(play,options,exit);
        primaryStage.setScene(new Scene(vBox,300,400));
        primaryStage.setTitle("Circus of Plates");

        if(!creation)
        {
            primaryStage.initStyle(StageStyle.UNDECORATED);
            creation=true;
            playMusic();
            primaryStage.show();
            primaryStage.getIcons().add(new Image("Resources/Buttons/title.jpg"));
        }
    }
    public void playMusic()
    {
        /*String musicFile = "Resources/Audio/ComeAndGetYourLove.mp3";     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();*/
       // String path=getClass().getClassLoader().getResource("database.properties").getFile().toString();
        File dir = new File(getClass().getClassLoader().getResource("Resources/Audio").getFile());
        boolean x=dir.exists();
        directoryListing = dir.listFiles();
        mediaPlayers=new ArrayList<>();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                 Media sound = new Media(new File(child.getPath()).toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayers.add(mediaPlayer);
            }
            mediaPlayer=mediaPlayers.get(0);
            for (int i = 0; i < mediaPlayers.size(); i++) {
                final MediaPlayer player     = mediaPlayers.get(i);
                final MediaPlayer nextPlayer = mediaPlayers.get((i + 1) % mediaPlayers.size());
                player.setOnEndOfMedia(new Runnable() {
                    @Override public void run() {
                        if(muteAudio)
                            nextPlayer.setMute(true);
                        mediaPlayer=nextPlayer;
                        mediaPlayer.play();
                    }
                });
            }

            mediaPlayer=mediaPlayers.get((int) (Math.random()*(mediaPlayers.size()-1)));
            mediaPlayer.play();
        }
    }
}
