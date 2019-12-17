package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Options extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox=new VBox();
        Button chooseChar=new Button("Choose Character");
        chooseChar.setOnAction(e->{

        });
        Button audio =new Button("Audio");
        audio.setOnAction(e->{

        });
        Button back=new Button("Back");
        back.setOnAction(e->{
            primaryStage.close();
        });
        vBox.getChildren().addAll(chooseChar,audio,back);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
    }
}
