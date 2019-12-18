package eg.edu.alexu.csd.oop.ClassesImplemented.Gui;

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
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;

public class ChooseChar extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView clown= null;
        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Clown/clown1.png")));
            clown.setFitWidth(70);
            clown.setFitHeight(85);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button clown1 = new Button(null, clown);
        DropShadow shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        DropShadow finalShadow3 = shadow;
        DropShadow finalShadow7 = finalShadow3;
        clown1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        clown1.setEffect(finalShadow7);
                    }
                });
//Removing the shadow when the mouse cursor is off
        clown1.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        clown1.setEffect(null);
                    }
                });
        clown1.setTranslateY(-30);
        clown1.setStyle("-fx-background-color: transparent;");
        clown1.setOnAction(e->{
            Levels.clownPath="Resources/Clown/clown1.png";
        });
        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Clown/clown2.png")));
            clown.setFitWidth(70);
            clown.setFitHeight(85);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button clown2=new Button(null,clown);
        shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        finalShadow3 = shadow;
        DropShadow finalShadow = finalShadow3;
        clown2.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        clown2.setEffect(finalShadow);
                    }
                });
//Removing the shadow when the mouse cursor is off
        clown2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        clown2.setEffect(null);
                    }
                });

        clown2.setTranslateY(-30);

        clown2.setStyle("-fx-background-color: transparent;");
        clown2.setOnAction(e->{
            Levels.clownPath="Resources/Clown/clown2.png";
        });
        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Clown/clown3.png")));
            clown.setFitWidth(70);
            clown.setFitHeight(85);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button clown3=new Button(null,clown);
        shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        finalShadow3 = shadow;
        DropShadow finalShadow4 = finalShadow3;
        clown3.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        clown3.setEffect(finalShadow4);
                    }
                });
//Removing the shadow when the mouse cursor is off
        clown3.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        clown3.setEffect(null);
                    }
                });

        clown3.setTranslateY(-30);

        clown3.setStyle("-fx-background-color: transparent;");
        clown3.setOnAction(e->{
            Levels.clownPath="Resources/Clown/clown3.png";
        });   try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Clown/clown4.png")));
            clown.setFitWidth(70);
            clown.setFitHeight(85);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button clown4=new Button(null,clown);
        shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        finalShadow3 = shadow;
        DropShadow finalShadow5 = finalShadow3;
        clown4.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        clown4.setEffect(finalShadow5);
                    }
                });
//Removing the shadow when the mouse cursor is off
        clown4.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        clown4.setEffect(null);
                    }
                });

        clown4.setStyle("-fx-background-color: transparent;");
        clown4.setTranslateY(-30);

        clown4.setOnAction(e->{
            Levels.clownPath="Resources/Clown/clown4.png";
        });try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Clown/clown5.png")));
            clown.setFitWidth(70);
            clown.setFitHeight(85);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button clown5=new Button(null,clown);
        shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        finalShadow3 = shadow;
        DropShadow finalShadow6 = finalShadow3;
        clown5.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        clown5.setEffect(finalShadow6);
                    }
                });
//Removing the shadow when the mouse cursor is off
        clown5.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        clown5.setEffect(null);
                    }
                });

        clown5.setStyle("-fx-background-color: transparent;");
        clown5.setTranslateY(-30);

        clown5.setOnAction(e->{
            Levels.clownPath="Resources/Clown/clown5.png";
        });
        HBox hBox=new HBox();
        VBox vBox=new VBox();
        vBox.setSpacing(10);
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

        try {
            clown = new ImageView(new Image(new FileInputStream("Resources/Buttons/BackB.png")));
            clown.setFitWidth(170);
            clown.setFitHeight(30);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Button back= new Button(null, clown);
        DropShadow finalShadow1 = new DropShadow();
        DropShadow finalShadow2 = finalShadow1;
        back.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        back.setEffect(finalShadow2);
                    }
                });
//Removing the shadow when the mouse cursor is off
        back.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        back.setEffect(null);
                    }
                });
        back.setTranslateY(-40);
        back.setStyle("-fx-background-color: transparent;");

        back.setOnAction(e->{
            primaryStage.close();
        });
        back.setOnAction(event -> primaryStage.close());
        HBox hBox1 =new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(clown3,clown4,clown5);
        HBox hBox2 =new HBox();
       // hBox2.setAlignment(Pos.CENTER);
        //hBox2.getChildren().addAll(clown5);
        hBox.getChildren().addAll(clown1,clown2);
        vBox.getChildren().addAll(hBox,hBox1,back);
        primaryStage.setScene(new Scene(vBox,300,400));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.showAndWait();
    }
}
