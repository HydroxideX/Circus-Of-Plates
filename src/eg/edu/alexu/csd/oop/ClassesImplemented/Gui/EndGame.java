package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Collections;

public class EndGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private boolean won=false;
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
        Button button=new Button("OK");
        button.setOnAction(e->primaryStage.hide());
        vBox.getChildren().addAll(label,label2,button);
        vBox.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(vBox,300,400));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image("Resources/Buttons/title.jpg"));
        primaryStage.show();
       /* primaryStage.setScene(new Scene(new VBox()));
        primaryStage.show();
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.ERROR);
        if(won){
            a.setHeaderText("You Are A SuperHero");
            a.setContentText("Congratulations You Won");
        }
        else
        {
            a.setHeaderText("You Are A Loser");
            a.setContentText("Congratulations You Lost");
        }
        a.showAndWait();*/
    }
}
