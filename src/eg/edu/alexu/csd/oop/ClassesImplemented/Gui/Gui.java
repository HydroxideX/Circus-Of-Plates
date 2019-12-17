package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;


public class Gui extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    static MediaPlayer mediaPlayer;
    static boolean muteAduio=false;
    @Override
    public void start(Stage primaryStage) {
        String musicFile = "Resources/Audio/LightOfTheSeven.mp3";     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());
         mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();
        VBox vBox =new VBox();
        Button play=new Button("New Game");
        Button exit=new Button("Exit");
        Button options=new Button("Options");
        play.setOnAction(e->{
            Levels levels=new Levels();
            levels.start(new Stage());
        });
        exit.setOnAction(e->{
            System.exit(0);
        });
        options.setOnAction(e->{
            Options options1 = new Options();
            options1.start(new Stage());
        });
        vBox.getChildren().addAll(play,options,exit);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.setTitle("Circus of Plates");
        primaryStage.show();
    }
}
