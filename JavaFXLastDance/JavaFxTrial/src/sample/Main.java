package sample;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;

import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.util.ArrayList;


public class Main extends Application {

    public void start(Stage primaryStage) {
        HBox hb = new HBox(15);
        hb.setAlignment(Pos.BOTTOM_CENTER);

        String[] type = {"Project", "Quiz","midterm","final"};
        double[] grade = {20,10,30,40};

        double height = 10;
        double width = 50;
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(20,15,5,15));

        Rectangle r1 = new Rectangle(0,0,width,height*grade[0]);
        r1.setFill(new Color(0.5,0.86,0.12,0.5));
        Rectangle r2 = new Rectangle(0,0,width,height*grade[1]);
        r2.setFill(Color.BLUE);
        Rectangle r3 = new Rectangle(0,0,width,height*grade[2]);
        r3.setFill(new Color(0.14,0.21,0.89,0.3));
        Rectangle r4 = new Rectangle(0,0,width,height*grade[3]);
        r1.widthProperty().bind(pane.heightProperty());
        r2.heightProperty().bind((pane.heightProperty().divide(2)));
        Text t1 = new Text(0,0,type[0] + " -- " + grade[0] + "%");
        Text t2 = new Text(0,0,type[1] + " -- " + grade[1] + "%");
        Text t3 = new Text(0,0,type[2] + " -- " + grade[2] + "%");
        Text t4 = new Text(0,0,type[3] + " -- " + grade[3] + "%");

        hb.getChildren().addAll(getVBox(t1,r1), getVBox(t2,r2),getVBox(t3,r3),getVBox(t4,r4));
        pane.getChildren().add(hb);
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_15_15"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public double getMax(double[] arr){
        double max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public VBox getVBox(Text t, Rectangle r){
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.BOTTOM_LEFT);
        vBox.getChildren().addAll(t,r);
        return vBox;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
