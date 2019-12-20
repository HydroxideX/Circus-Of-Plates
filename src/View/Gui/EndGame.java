package View.Gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Collections;

public class EndGame extends Application {
    public static void main(String[] args) {
        //launch(args);
    }
    private boolean won;
    public EndGame(boolean won)
    {
        this.won=won;
    }
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

        Label label = new Label();
        Label label2 = new Label();
        if(won) {
            label.setText("You Are A SuperHero");
            label2.setText("Congratulations You Won");
        }else {
            label.setText("You Are A Loser");
            label2.setText("Congratulations You Lost");
        }
        label2.setFont(Font.font("Cambria", 15));
        label.setFont(Font.font("Cambria", 25));
        ImageView clown;
        clown = new ImageView(new Image("Resources/yahia.jpg"));
        clown.setFitWidth(70);
        clown.setFitHeight(90);
        Button button=new Button(null,clown);
        DropShadow shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> button.setEffect(shadow));
//Removing the shadow when the mouse cursor is off
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> button.setEffect(null));
        button.setTranslateY(-20);
        button.setStyle("-fx-background-color: transparent;");
        button.setOnAction(e->primaryStage.close());
        vBox.getChildren().addAll(label,label2,button);
        vBox.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(vBox,300,400));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image("Resources/Buttons/title.jpg"));
        primaryStage.show();
    }
}
