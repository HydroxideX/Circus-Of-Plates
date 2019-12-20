package View.Gui;

import Models.Logger.GameLogger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Collections;

public class HowToPlay extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Button back;
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
        ImageView clown;
        clown = new ImageView(new Image("Resources/Buttons/BackB.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(30);
        back= new Button(null, clown);

        DropShadow finalShadow2 = new DropShadow();
        back.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> back.setEffect(finalShadow2));
//Removing the shadow when the mouse cursor is off
        back.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        back.setEffect(null);
                    }
                });
        back.setTranslateY(-58);
        back.setStyle("-fx-background-color: transparent;");

        back.setOnAction(e->{
            Gui gui=new Gui();
            gui.start(primaryStage);

        });
        clown = new ImageView(new Image("Resources/Buttons/HowToPlay.png"));
        clown.setFitWidth(150);
        clown.setFitHeight(50);
        Label label=new Label(null,clown);
        vBox.setOnKeyPressed(ke -> {
                    KeyCode kc = ke.getCode();
                    if(kc.equals(KeyCode.ESCAPE)||kc.equals(KeyCode.BACK_SPACE))
                    {
                        back.fire();
                    }
                });
        label.setTranslateY(-20);
        Text text=new Text();
        text.setText("Play With The Clown To Collect The Falling Plates. A Stack is a Group Of Three Plates With The Same Color, If A Stick Has A Stack Of Plates The Stack Disappears And The Score Increases By One If The Score Reaches Five The player Wins If 120 Seconds Pass Before Reaching A Score Of Five The Player Loses, Now Go, Play Well And Claim Your Victory!");
        text.setWrappingWidth(240);
        text.setTranslateY(-40);
        text.setTranslateX(+5);
        text.setFont(Font.font(text.getFont().getSize()+2));
        vBox.getChildren().addAll(label,text,back);
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("info", "How To Play Added");
        primaryStage.setScene(new Scene(vBox,300,400));
    }
}
