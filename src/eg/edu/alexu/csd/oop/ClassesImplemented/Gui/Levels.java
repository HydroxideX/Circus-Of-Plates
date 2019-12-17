package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

import eg.edu.alexu.csd.oop.ClassesImplemented.NotYahiasAwesomeGame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;

public class Levels extends Application {
    public static String clownPath="Resources/Clown/clown1.png";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox=new VBox();
        Button level1=new Button("Easy");
        level1.setOnAction(e->{
            NotYahiasAwesomeGame notYahiasAwesomeGame=new NotYahiasAwesomeGame("level1",clownPath);
            notYahiasAwesomeGame.Start();
            playMusic();
            primaryStage.close();
        });
        Button level2 =new Button("Medium");
        level2.setOnAction(e->{
            NotYahiasAwesomeGame notYahiasAwesomeGame=new NotYahiasAwesomeGame("level2",clownPath);
            notYahiasAwesomeGame.Start();
            playMusic();
            primaryStage.close();
        });
        Button level3=new Button("Hard");
        level3.setOnAction(e->{
            NotYahiasAwesomeGame notYahiasAwesomeGame=new NotYahiasAwesomeGame("level3",clownPath);
            notYahiasAwesomeGame.Start();
            playMusic();
            primaryStage.close();
        });
        vBox.getChildren().addAll(level1,level2,level3);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
    }
    private void playMusic()
    {
        Gui.mediaPlayer.setMute(true);
        if(!Gui.muteAduio)
        {
            String musicFile = "Resources/Audio/NyaNya.mp3";     // For example
            Media sound = new Media(new File(musicFile).toURI().toString());
            Gui.mediaPlayer = new MediaPlayer(sound);
           Gui. mediaPlayer.setOnEndOfMedia(new Runnable() {
                public void run() {
                    Gui.mediaPlayer.seek(Duration.ZERO);
                }
            });
           Gui.mediaPlayer.play();
        }
    }
}
