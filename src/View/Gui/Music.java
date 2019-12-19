package View.Gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.Collections;

public class Music extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Stage x;
    Button mute;
    @Override
    public void start(Stage primaryStage) {
        x = primaryStage;
        VBox vBox = new VBox();
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
        ImageView clown = null;
        clown = new ImageView(new Image("Resources/Buttons/BackB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
        Button back = new Button(null, clown);
        DropShadow finalShadow1 = new DropShadow();
        DropShadow finalShadow2 = finalShadow1;
        DropShadow finalShadow = finalShadow2;
        back.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        back.setEffect(finalShadow);
                    }
                });
//Removing the shadow when the mouse cursor is off
        back.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        back.setEffect(null);
                    }
                });
        back.setTranslateY(-20);
        back.setStyle("-fx-background-color: transparent;");

        back.setOnAction(e -> {
            Options options=new Options();
            options.start(primaryStage);
        });

        mute = new Button(null, clown);
        changeSoundIcon();
        finalShadow2 = new DropShadow();
        finalShadow1 = finalShadow2;
        DropShadow finalShadow3 = finalShadow1;
        mute.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        mute.setEffect(finalShadow3);
                    }
                });
//Removing the shadow when the mouse cursor is off
        mute.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        mute.setEffect(null);
                    }
                });
        mute.setTranslateY(-20);
        mute.setStyle("-fx-background-color: transparent;");
        mute.setOnAction(e -> {
            Gui.mediaPlayer.setMute(true);
            Gui.muteAudio = !Gui.muteAudio;
            if (!Gui.muteAudio) {
                Gui.mediaPlayer.setMute(false);
            }
            changeSoundIcon();
        });
        Label label = new Label("Choose Music");
        ChoiceBox dropBox = new ChoiceBox<>();
        dropBox.setMaxWidth(53);
        for (File x : Gui.directoryListing) {
            dropBox.getItems().add(x.getName());
        }
        dropBox.setOnAction(e -> {
            Gui.muteAudio = false;
            changeSoundIcon();
            int index = 0;
            for (File temp : Gui.directoryListing) {
                if (temp.getPath().contains((CharSequence) dropBox.getValue())) {
                    Media sound = new Media(new File(temp.getPath()).toURI().toString());
                    MediaPlayer mediaPlayerT = new MediaPlayer(sound);
                    //mediaPlayerT.play();

                    Gui.mediaPlayer.pause();
                    Gui.mediaPlayer = Gui.mediaPlayers.get(index);
                    Gui.mediaPlayer.play();
                    break;
                }
                index++;
            }
        });
        vBox.setOnKeyPressed(ke -> {
            KeyCode kc = ke.getCode();
                    if(kc.equals(KeyCode.ESCAPE))
                        back.fire();
                });
            HBox hbox = new HBox(5);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(label, dropBox);
        hbox.setTranslateY(-20);
        vBox.getChildren().addAll(mute, hbox, back);
        primaryStage.setScene(new Scene(vBox, 300, 400));
        primaryStage.setTitle("Circus of Plates");
        //primaryStage.initStyle(StageStyle.UNDECORATED);
       // primaryStage.show();
    }

    private void changeSoundIcon() {
        ImageView clown= null;
        if(Gui.muteAudio)
        {
            clown = new ImageView(new Image("Resources/Buttons/Mute.png"));
            clown.setFitWidth(60);
            clown.setFitHeight(30);

        }
        else{
            clown = new ImageView(new Image("Resources/Buttons/Sound.png"));
            clown.setFitWidth(60);
            clown.setFitHeight(30);

        }
        mute.setGraphic(clown);
    }
}
