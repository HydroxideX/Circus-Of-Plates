package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

import eg.edu.alexu.csd.oop.ClassesImplemented.NotYahiasAwesomeGame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Levels extends Application {
    public static String clownPath="Resources/Clown/clown1.png";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox=new VBox();
        Button level1=new Button("Easy");
        level1.setOnAction(e->{
            NotYahiasAwesomeGame notYahiasAwesomeGame=new NotYahiasAwesomeGame("level1",clownPath);
            notYahiasAwesomeGame.Start();
            primaryStage.close();
        });
        Button level2 =new Button("Medium");
        level2.setOnAction(e->{
            NotYahiasAwesomeGame notYahiasAwesomeGame=new NotYahiasAwesomeGame("level2",clownPath);
            notYahiasAwesomeGame.Start();
            primaryStage.close();

        });
        Button level3=new Button("Hard");
        level3.setOnAction(e->{
            NotYahiasAwesomeGame notYahiasAwesomeGame=new NotYahiasAwesomeGame("level3",clownPath);
            notYahiasAwesomeGame.Start();
            primaryStage.close();
        });
        vBox.getChildren().addAll(level1,level2,level3);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
    }
}
