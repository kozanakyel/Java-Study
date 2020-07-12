package sample;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        Arc arc = new Arc(100,50,75,25,0,-180);
        arc.setFill(Color.AQUA);
        arc.setStroke(Color.CHOCOLATE);

        Circle ball = new Circle(100,75,10);

        pane.getChildren().addAll(arc,ball);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(arc);
        pt.setNode(ball);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(4000));
        ft.setNode(ball);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        pane.setOnMousePressed(e -> {
            pt.play();
            ft.play();
        });

        pane.setOnMouseReleased(e -> {
            pt.pause();
            ft.pause();
        });

        Scene scene = new Scene(pane,200,200);
        primaryStage.setTitle("ball transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
