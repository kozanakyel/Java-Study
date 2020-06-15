package sample;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Circle circle = new Circle(125,100,50);
        circle.setFill(Color.MAGENTA);
        circle.setStroke(Color.BLACK);

        Rectangle rectangle = new Rectangle(0,0,25,50);
        rectangle.setFill(Color.ORANGE);

        BorderPane pane = new BorderPane();


        pane.getChildren().addAll(circle);
        pane.getChildren().add(rectangle);


        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circle);
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        circle.setOnMousePressed(e -> pt.pause());
        circle.setOnMousePressed(e -> pt.play());

        Scene scene = new Scene(pane,250,200);
        primaryStage.setTitle("PathTransitionDem: ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
