package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Create a pane
        Pane pane = new Pane();

        double[] scores = {20, 10, 30, 40};

        String[] grades = {"Project", "Quiz", "Midterm", "Final"};

        // Create four text objects
        Text t1 = new Text(110, 80,  grades[0] + " -- " + scores[0] + "%");
        Text t2 = new Text(80, 15,   grades[1] + " -- " + scores[1] + "%");
        Text t3 = new Text(5, 100,   grades[2] + " -- " + scores[2] + "%");
        Text t4 = new Text(100, 180, grades[3] + " -- " + scores[3] + "%");

        // Create four Arcs
        Arc arc1 = new Arc(100, 100, 80, 80, 0, 360 * (scores[0] / 100));
        arc1.setFill(Color.RED);
        arc1.setType(ArcType.ROUND);

        Arc arc2 = new Arc(100, 100, 80, 80, arc1.getStartAngle() +
                arc1.getLength(), 360 * (scores[1] / 100));
        arc2.setFill(Color.BLUE);
        arc2.setType(ArcType.ROUND);

        Arc arc3 = new Arc(100, 100, 80, 80, arc2.getStartAngle() +
                arc2.getLength(), 360 * (scores[2] / 100));
        arc3.setFill(Color.GREEN);
        arc3.setType(ArcType.ROUND);

        Arc arc4 = new Arc(100, 100, 80, 80, arc3.getStartAngle() +
                arc3.getLength(), 360 * (scores[3] / 100));
        arc4.setFill(Color.ORANGE);
        arc4.setType(ArcType.ROUND);
        pane.getChildren().addAll(arc1, arc2, arc3, arc4, t1, t2, t3, t4);

        Polygon polygon = new Polygon();
        pane.getChildren().add(polygon);
        polygon.setFill(Color.GOLD);
        polygon.setRotate(20);
        ObservableList<Double> list = polygon.getPoints();

        final double WIDTH = 200, HEIGHT = 200;
        double centerX  = WIDTH, centerY = HEIGHT;
        double radius = Math.min(WIDTH,HEIGHT) * 0.4;

        for(int i = 0; i < 8; i++){
            list.add(centerX + radius*Math.cos(2*i*Math.PI/8));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
        }
        Text text = new Text("STOP");
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD,40));
        text.setFill(Color.WHITE);
        pane.getChildren().add(text);

        Scene scene = new Scene(pane,400,400);
        primaryStage.setTitle("arc pie chart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
