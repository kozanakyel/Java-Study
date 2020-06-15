package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {
    private CirclePane circlePane = new CirclePane();

    @Override
    public void start(Stage primaryStage) throws Exception{
       HBox hBox = new HBox();
       hBox.setSpacing(10);
       hBox.setAlignment(Pos.CENTER);
       Button btEnlarge = new Button("enlarge");
       Button btShrink = new Button("shrink");
       hBox.getChildren().add(btEnlarge);
       hBox.getChildren().add(btShrink);

       btEnlarge.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               circlePane.enlarge();
           }
       });
       btShrink.setOnAction(e -> circlePane.shrink());

       Text text = new Text(20,20,"Programming is fun");
       text.setOnMouseClicked(e ->{
           text.setX(e.getX());
           text.setY(e.getY());
       });

       circlePane.setOnMouseClicked(e -> {
           if (e.getButton() == MouseButton.PRIMARY){
               circlePane.enlarge();}
           else if (e.getButton() == MouseButton.SECONDARY){
               circlePane.shrink();}
       });

       circlePane.setOnKeyPressed(e -> {
           if (e.getCode() == KeyCode.E){
               circlePane.enlarge();
           }
           else if(e.getCode() == KeyCode.S){
               circlePane.shrink();}
       });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setTop(text);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox,Pos.CENTER);

        Scene scene = new Scene(borderPane,200,150);
        primaryStage.setTitle("Control circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class CirclePane extends StackPane {
    private  Circle circle = new Circle(50);

    public CirclePane(){
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.MAGENTA);
    }

    public void enlarge(){
        circle.setRadius(circle.getRadius() + 2);
    }

    public  void shrink(){
        circle.setRadius(circle.getRadius() > 2 ?
                circle.getRadius() - 2 : circle.getRadius());
    }
}

