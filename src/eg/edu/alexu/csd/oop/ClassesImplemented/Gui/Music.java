package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;

public class Music extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button mute;
    @Override
    public void start(Stage primaryStage) {
        VBox vBox=new VBox();
        vBox.setSpacing(15);
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
            clown = new ImageView(new Image(new FileInputStream("Resources/Buttons/BackB.png")));
            clown.setFitWidth(150);
            clown.setFitHeight(30);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button back= new Button(null, clown);
        DropShadow finalShadow1 = new DropShadow();
        DropShadow finalShadow2 = finalShadow1;
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
        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Buttons/Sound.png")));
            clown.setFitWidth(60);
            clown.setFitHeight(30);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         mute= new Button(null, clown);

        finalShadow2 =new DropShadow();
        finalShadow1 = finalShadow2;
        DropShadow finalShadow3 = finalShadow1;
        mute.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        mute.setEffect(finalShadow3);
                    }
                });
//Removing the shadow when the mouse cursor is off
        mute.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        mute.setEffect(null);
                    }
                });
        mute.setTranslateY(-20);
        mute.setStyle("-fx-background-color: transparent;");
        mute.setOnAction(e->{
            Gui.mediaPlayer.setMute(true);
            Gui.muteAduio= !Gui.muteAduio;
            if(!Gui.muteAduio) {
                Gui.mediaPlayer.setMute(false);
            }
            changeSoundIcon();
        });
        Label label=new Label("Choose Music");
        ChoiceBox dropBox =new ChoiceBox<>();
        dropBox.setMaxWidth(53);
        for (File x:Gui.directoryListing) {
            dropBox.getItems().add(x.getName());
        }
        dropBox.setOnAction(e->{
            Gui.muteAduio=false;
            changeSoundIcon();
            int index=0;
            for(File temp:Gui.directoryListing)
            {
                if(temp.getPath().contains((CharSequence) dropBox.getValue()))
                {
                    Media sound = new Media(new File(temp.getPath()).toURI().toString());
                    MediaPlayer mediaPlayerT = new MediaPlayer(sound);
                    //mediaPlayerT.play();

                            Gui.mediaPlayer.pause();
                            Gui.mediaPlayer=Gui.mediaPlayers.get(index);
                            Gui.mediaPlayer.play();
                            break;
                }
                index++;
            }
        });
        HBox hbox=new HBox(5);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(label,dropBox);
        hbox.setTranslateY(-20);
        vBox.getChildren().addAll(mute,hbox,back);
        primaryStage.setScene(new Scene(vBox,300,400));
        primaryStage.setTitle("Circus of Plates");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();


    }

    private void changeSoundIcon() {
        ImageView clown= null;
        if(Gui.muteAduio)
        {
            try {
                clown = new ImageView(new Image(new FileInputStream("Resources/Buttons/Mute.png")));
                clown.setFitWidth(60);
                clown.setFitHeight(30);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        else{
            try {
                clown = new ImageView(new Image(new FileInputStream("Resources/Buttons/Sound.png")));
                clown.setFitWidth(60);
                clown.setFitHeight(30);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        mute.setGraphic(clown);
    }
}