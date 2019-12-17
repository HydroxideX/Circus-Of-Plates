package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

import eg.edu.alexu.csd.oop.ClassesImplemented.NotYahiasAwesomeGame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Gui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox =new VBox();
        Button play=new Button("New Game");
        Button exit=new Button("Exit");
        Button options=new Button("Options");
        play.setOnAction(e->{
            Levels levels=new Levels();
            levels.start(new Stage());
        });
        exit.setOnAction(e->{
            System.exit(0);
        });
        options.setOnAction(e->{
            Options options1 = new Options();
            options1.start(new Stage());
        });
        vBox.getChildren().addAll(play,options,exit);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.setTitle("Circus of Plates");
        primaryStage.show();
    }
}
