package View.Gui;

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
import javafx.stage.Stage;

import java.util.Collections;


public class Options extends Application {

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
        clown = new ImageView(new Image("Resources/Buttons/ChooseClown.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
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
            chooseChar1.start(primaryStage);
        });


        clown = new ImageView(new Image("Resources/Buttons/MusicB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
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
            Music music=new Music();
            music.start(primaryStage);
        });
        clown = new ImageView(new Image("Resources/Buttons/BackB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
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
            Gui gui=new Gui();
            gui.start(primaryStage);

        });

        vBox.getChildren().addAll(chooseChar,audio,back);
        primaryStage.setScene(new Scene(vBox,300,400));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.showAndWait();
    }
}
