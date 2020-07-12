package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        // Create three polylines and set their properties
        Polyline polyline1 = new Polyline();
        pane.getChildren().add(polyline1);
        polyline1.setStroke(Color.BLACK);
        ObservableList<Double> list = polyline1.getPoints();
        double x1 = 40.0;
        double y1 = 190.0;
        double y2 = 20.0;
        double x3 = 125.0;
        list.addAll(x1, y1, x1, y2, x3, y2, x3, y1 * .60);

        Polyline polyline2 = new Polyline();
        pane.getChildren().add(polyline2);
        polyline2.setStroke(Color.BLACK);
        ObservableList<Double> list2 = polyline2.getPoints();
        list2.addAll((x1 + x3) * .5, y1 * .5, x3, y1 * .25,
                x3 + (x3 - x1) * .5, y1 * .5);

        Polyline polyline3 = new Polyline();
        pane.getChildren().add(polyline3);
        polyline3.setStroke(Color.BLACK);
        ObservableList<Double> list3 = polyline3.getPoints();
        list3.addAll((x1 + x3) * .6, y1 * .80, x3, y1 * .60,
                x3 + (x3 - x1) * .3, y1 * .80);

        // Create a circle and set its properties
        Circle circle = new Circle(x3, y1 * .25, 15);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        // Create an arc and set its properties
        Arc arc = new Arc(x1, y1 + 1, 25, 15, 0, 180);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        pane.getChildren().add(arc);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Exercise_14_17"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }


    public static void main(String[] args) {
        launch(args);
    }
}

class GridPane extends Pane {
    public GridPane(){
        Line line1 = new Line(0,200/3,200,200/3);
        line1.startYProperty().bind(heightProperty().divide(3));
        line1.endYProperty().bind(heightProperty().divide(3));
        line1.endXProperty().bind(widthProperty());
        line1.setStroke(Color.BLUE);

        Line line2 = new Line();
        line2.startYProperty().bind(line1.startYProperty().multiply(2));
        line2.endYProperty().bind(line1.endYProperty().multiply(2));
        line2.endXProperty().bind(widthProperty());
        line2.setStroke(Color.BLUE);

        Line line3 = new Line();
        line3.startXProperty().bind(widthProperty().divide(3));
        line3.endXProperty().bind(widthProperty().divide(3));
        line3.endYProperty().bind(heightProperty());
        line3.setStroke(Color.RED);

        Line line4 = new Line();
        line4.startXProperty().bind(line3.startXProperty().multiply(2));
        line4.endXProperty().bind(line3.endXProperty().multiply(2));
        line4.endYProperty().bind(heightProperty());
        line4.setStroke(Color.RED);

        getChildren().addAll(line1, line2, line3, line4);
    }
}
