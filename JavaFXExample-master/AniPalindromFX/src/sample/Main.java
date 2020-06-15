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
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        Arc arc = new Arc(100, 50, 75, 25, 0, -180);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);

        Circle circle = new Circle(100, 75, 10);

        pane.getChildren().addAll(arc, circle);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        //the path is arc
        pt.setPath(arc);
        //moving subject is circle(node)
        pt.setNode(circle);
        pt.setOrientation(
               PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT
        );
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        FadeTransition ft =
                new FadeTransition(Duration.millis(4000), circle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        pane.setOnMousePressed(e -> {
            pt.pause();
            ft.pause();
        });

        pane.setOnMouseReleased(e -> {
            pt.play();
            ft.play();
        });

        Scene scene = new Scene(pane, 200, 100);
        primaryStage.setTitle("Animation palindrome");
        primaryStage.setScene(scene);
        primaryStage.show();

        Pane pane1 = new Pane();

        Text text = new Text("Mal degnegi donuyor mınako:))");
        pane1.getChildren().add(text);

        PathTransition pt1 = new PathTransition(Duration.millis(10000),
                new Line(-50, 50, 250,50), text);
        pt1.setCycleCount(Timeline.INDEFINITE);
        pt1.play();

        pane.setOnMousePressed(e1 -> {
            pt1.pause();
        });

        pane.setOnMouseReleased(e1 -> {
            pt1.play();
        });

        Stage stage1 = new Stage();
        Scene scene1 = new Scene(pane1, 200, 100);
        stage1.setTitle("MAL DEGNEK");
        stage1.setScene(scene1);
        stage1.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
