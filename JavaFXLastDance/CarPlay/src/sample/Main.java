package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.css.Rect;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        CarPane pane = new CarPane();
        pane.setOnMousePressed(e -> pane.pause());
        pane.setOnMouseReleased(e -> pane.play());
        pane.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.UP){
                pane.increaseSpeed();
            }
            else if(e.getCode()== KeyCode.DOWN){
                pane.decreaseSpeed();
            }
        });

        Scene scene = new Scene(pane,1400,100);
        primaryStage.setTitle("Car Play");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

class CarPane extends Pane {
    private double x = 0;
    private double y = 100;
    private double radius = 5;
    private Rectangle rectangle;
    private Polygon polygon;
    private Circle circle1;
    private Circle circle2;
    public Timeline animation;
    private Text txt;


    CarPane(){
        drawCar();
        animation = new Timeline(
                new KeyFrame(Duration.millis(50), e -> moveCar())
        );
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

    }

    private void drawCar(){
        getChildren().clear();
        rectangle = new Rectangle(x,y-20,50,10);
        polygon = new Polygon(x+10,y-20,x+20,y-30,x+30,y-30,x+40,y-20);
        circle1 = new Circle(x + 15, y - 5, radius);
        circle2 = new Circle(x + 35, y - 5, radius);
//        txt = new Text(50,50,"Speed; " + animation.getRate());
//        getChildren().add(txt);
        getChildren().addAll(rectangle, circle1, circle2, polygon);
    }

    public void pause(){
        animation.pause();
    }

    public void play() {
        animation.play();
    }

    public void increaseSpeed(){
        animation.setRate(animation.getRate()+1);

    }

    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 1 : 0);
    }

    /** Redraw car with new x value */
    protected void moveCar() {
        if (x <= getWidth()) {
            x += 1;
        }
        else
            x = 0;

        drawCar();

    }
}
