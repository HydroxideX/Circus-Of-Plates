package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ChooseChar extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView clown= null;
        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Clown/clown1.png")));
            clown.setFitWidth(100);
            clown.setFitHeight(100);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button clown1 = new Button(null, clown);
        clown1.setStyle("-fx-base: mistyrose;");
        clown1.setOnAction(e->{
            Levels.clownPath="Resources/Clown/clown1.png";
        });
        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Clown/clown2.png")));
            clown.setFitWidth(100);
            clown.setFitHeight(100);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button clown2=new Button(null,clown);
        clown2.setStyle("-fx-base: mistyrose;");
        clown2.setOnAction(e->{
            Levels.clownPath="Resources/Clown/clown2.png";
        });
        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Clown/clown3.png")));
            clown.setFitWidth(100);
            clown.setFitHeight(100);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button clown3=new Button(null,clown);
        clown3.setStyle("-fx-base: mistyrose;");
        clown3.setOnAction(e->{
            Levels.clownPath="Resources/Clown/clown3.png";
        });   try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Clown/clown4.png")));
            clown.setFitWidth(100);
            clown.setFitHeight(100);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button clown4=new Button(null,clown);
        clown4.setStyle("-fx-base: mistyrose;");
        clown4.setOnAction(e->{
            Levels.clownPath="Resources/Clown/clown4.png";
        });try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Clown/clown5.png")));
            clown.setFitWidth(100);
            clown.setFitHeight(100);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button clown5=new Button(null,clown);
        clown5.setStyle("-fx-base: mistyrose;");
        clown5.setOnAction(e->{
            Levels.clownPath="Resources/Clown/clown5.png";
        });
        HBox hBox=new HBox();
        VBox vBox=new VBox();
        Button back=new Button("Back");
        back.setOnAction(event -> primaryStage.close());
        hBox.getChildren().addAll(clown1,clown2,clown3,clown4,clown5);
        vBox.getChildren().addAll(hBox,back);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.showAndWait();
    }
}
