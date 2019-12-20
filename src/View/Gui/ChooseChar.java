package View.Gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Collections;

public class ChooseChar extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Button back;
    Button clown1;
    Button clown2;
    Button clown4;
    Button clown5;
    Button clown3;
    private int keyBoardCounter=0;
    @Override
    public void start(Stage primaryStage) {
        ImageView clown= null;
        clown = new ImageView(new Image("Resources/Clown/clown1.png"));
        clown.setFitWidth(70);
        clown.setFitHeight(85);
         clown1 = new Button(null, clown);
        DropShadow shadow = new DropShadow();
        clown1.setEffect(shadow);
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
            back.fire();
        });
        clown = new ImageView(new Image("Resources/Clown/clown2.png"));
        clown.setFitWidth(70);
        clown.setFitHeight(85);
         clown2=new Button(null,clown);
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
            Levels.clownPath="Clown/clown2.png";
            back.fire();

        });
        clown = new ImageView(new Image("Resources/Clown/clown3.png"));
        clown.setFitWidth(70);
        clown.setFitHeight(85);
         clown3=new Button(null,clown);
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
            Levels.clownPath="Clown/clown3.png";
            back.fire();

        });
        clown = new ImageView(new Image("Resources/Clown/clown4.png"));
        clown.setFitWidth(70);
        clown.setFitHeight(85);
         clown4=new Button(null,clown);
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
            Levels.clownPath="Clown/clown4.png";
            back.fire();

        });
        clown = new ImageView(new Image("Resources/Clown/clown5.png"));
        clown.setFitWidth(70);
        clown.setFitHeight(85);
         clown5=new Button(null,clown);
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
            Levels.clownPath="Clown/clown5.png";
            back.fire();
        });
        HBox hBox=new HBox();
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

        clown = new ImageView(new Image("Resources/Buttons/BackB.png"));
        clown.setFitWidth(170);
        clown.setFitHeight(30);
         back= new Button(null, clown);
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
            Options options=new Options();
            options.start(primaryStage);
        });

        vBox.setOnKeyPressed(ke -> {
            KeyCode kc = ke.getCode();
            if(clown1.getEffect()!=null) keyBoardCounter=0;
            if(clown2.getEffect()!=null) keyBoardCounter=1;
            if(clown3.getEffect()!=null) keyBoardCounter=2;
            if(clown4.getEffect()!=null) keyBoardCounter=3;
            if(clown5.getEffect()!=null) keyBoardCounter=4;
            if(back.getEffect()!=null) keyBoardCounter=5;
            if(kc.equals(KeyCode.UP))
            {
                keyBoardCounter--;
                if(keyBoardCounter==-1)keyBoardCounter=5;
                addShadows();
            }
            if(kc.equals((KeyCode.DOWN)))
            {
                keyBoardCounter++;
                keyBoardCounter=keyBoardCounter%6;
                addShadows();
            }
            if(kc.equals(KeyCode.ENTER))
            {
                if(keyBoardCounter==0)clown1.fire();
                else if(keyBoardCounter==1)clown2.fire();
                else if(keyBoardCounter==2)clown3.fire();
                else if(keyBoardCounter==3)clown4.fire();
                else if(keyBoardCounter==4)clown5.fire();
                else if(keyBoardCounter==5)back.fire();
                else back.fire();
            }
            if(kc.equals(KeyCode.ESCAPE)||kc.equals(KeyCode.BACK_SPACE))
                back.fire();
        });

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
       // primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.showAndWait();
    }
    private void addShadows() {
        clown1.setEffect(null);
        clown2.setEffect(null);
        clown3.setEffect(null);
        clown4.setEffect(null);
        clown5.setEffect(null);
        back.setEffect(null);
        if(keyBoardCounter==0)
        {
            clown1.setEffect(new DropShadow());
        }
        else if(keyBoardCounter==1)
        {
            clown2.setEffect(new DropShadow());
        }else if(keyBoardCounter==2)
        {
            clown3.setEffect(new DropShadow());
        }else if(keyBoardCounter==3)
        {
            clown4.setEffect(new DropShadow());
        }else if(keyBoardCounter==4)
        {
            clown5.setEffect(new DropShadow());
        }
        else {
            back.setEffect(new DropShadow());
        }
    }

}
