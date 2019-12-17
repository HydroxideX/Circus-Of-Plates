package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

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


public class Options extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox=new VBox();
        Button chooseChar=new Button("Choose Character");
        chooseChar.setOnAction(e->{
            ChooseChar chooseChar1=new ChooseChar();
            chooseChar1.start(new Stage());
        });
        Button audio =new Button("Mute Audio");
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
        Button back=new Button("Back");
        back.setOnAction(e->{
            primaryStage.close();
        });
        vBox.getChildren().addAll(chooseChar,audio,back);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
    }
}
