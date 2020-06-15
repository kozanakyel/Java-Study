package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        double width = 1000;
        double height = 600;

        Circle circle = new Circle(10);
        setRandomProperties(circle, width, height);
        pane.getChildren().add(circle);

        circle.setOnMouseClicked(e -> {
            pane.getChildren().clear();
            setRandomProperties(circle, width, height);
            pane.getChildren().add(circle);
        });

        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle("EYEHAND");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void setRandomProperties(Circle c, double width, double height){
        c.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        c.setCenterX(c.getRadius() + Math.random() *
                (width - c.getRadius() * 2));
        c.setCenterY(c.getRadius() + Math.random() *
                (height - c.getRadius() * 2));
    }

    public static void main(String[] args) {
        launch(args);
    }
}


