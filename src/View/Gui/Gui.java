package View.Gui;

import Models.Logger.GameLogger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.FocusModel;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;


public class Gui extends Application {
    public static Stage habala=new Stage();
    static boolean creation=false;
    Label mute;
    public static void main(String[] args) {
        launch(args);
    }
    static MediaPlayer mediaPlayer;
    static boolean muteAudio=false;
    static ArrayList<MediaPlayer> mediaPlayers;
    static File[] directoryListing;
    private int keyBoardCounter=0;
    Button play;
    Button options;
    Button exit;
    static Stage primaryStage;
    @Override

    public void start(Stage primaryStage1) {
        primaryStage=primaryStage1;
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
         play = new Button(null, clown);
        DropShadow shadow = new DropShadow();
        DropShadow finalShadow3 = shadow;
        play.setEffect(shadow);
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
        play.setTranslateY(-40);
        play.setStyle("-fx-background-color: transparent;");
        clown = new ImageView(new Image("Resources/Buttons/QuitB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
         exit = new Button(null, clown);
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
        exit.setTranslateY(-40);
        exit.setStyle("-fx-background-color: transparent;");
        clown = new ImageView(new Image("Resources/Buttons/OptionsB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
         options = new Button(null, clown);
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

        options.setTranslateY(-40);
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
         mute=new Label("M : Mute");
        Label how=new Label("F1 : How TO Play");
        how.setFont( Font.font("Cambria", 10));
        mute.setFont( Font.font("Cambria", 10));
        how.setTranslateY(-65);
        how.setTranslateX(+82);
        mute.setTranslateY(-50);
        mute.setTranslateX(+65);
        vBox.setOnKeyPressed(ke -> {
            KeyCode kc = ke.getCode();
            if(play.getEffect()!=null) keyBoardCounter=0;
            if(options.getEffect()!=null) keyBoardCounter=1;
            if(exit.getEffect()!=null) keyBoardCounter=2;
            if(kc.equals(KeyCode.UP))
            {
                keyBoardCounter--;
                if(keyBoardCounter==-1)keyBoardCounter=3;
                addShadows();
            }
            if(kc.equals((KeyCode.DOWN)))
            {
                keyBoardCounter++;
                keyBoardCounter=keyBoardCounter%3;
                addShadows();
            }
            if(kc.equals(KeyCode.ENTER))
            {
                if(keyBoardCounter==0)play.fire();
                else if(keyBoardCounter==1)options.fire();
                else exit.fire();
            }
            if(kc.equals(KeyCode.F1))
            {
                HowToPlay howToPlay=new HowToPlay();
                howToPlay.start(primaryStage);
            }
            if(kc.equals(KeyCode.M))
            {
                setMute();
            }
            if(kc.equals(KeyCode.ESCAPE)||kc.equals(KeyCode.BACK_SPACE)) {
                exit.fire();
            }
        });
        vBox.getChildren().addAll(mute,how,play,options,exit);
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
    public static boolean  checkClosed()
    {
        return primaryStage.isFocused();
    }
    public void setMute()
    {
        mute.setText("M : mute");
        Gui.mediaPlayer.setMute(true);
        Gui.muteAudio = !Gui.muteAudio;
        if (!Gui.muteAudio) {
            Gui.mediaPlayer.setMute(false);
        }
        else mute.setText("M : Unmute");
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("info", "Mute triggered");

    }
    private void addShadows() {
        options.setEffect(null);
        exit.setEffect(null);
        play.setEffect(null);
        if(keyBoardCounter==0)
        {
            play.setEffect(new DropShadow());
        }
        else if(keyBoardCounter==1)
        {
            options.setEffect(new DropShadow());
        }
        else {
            exit.setEffect(new DropShadow());
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
        File dir2 = new File("Resources/Plates");
        File[] f = dir2.listFiles();

        File dir = new File("Resources/Audio");
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
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("info", "Music Added");
    }
}
