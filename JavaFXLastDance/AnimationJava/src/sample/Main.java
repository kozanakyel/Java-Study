package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Pane pane = new Pane();

        pane.setOnMouseClicked(e -> {
            Circle c = new Circle(e.getX(),e.getY(),Math.random()*100);
            c.setFill(new Color(Math.random(),Math.random(),
                    Math.random(),Math.random()));
            c.setStroke(new Color(Math.random(),Math.random(),
                    Math.random(),Math.random()));
            if(e.getButton()== MouseButton.PRIMARY){
                pane.getChildren().add(c);
            }
            else if(e.getButton()==MouseButton.SECONDARY){
                ObservableList<Node> list = pane.getChildren();
                for(int i = 0; i < list.size();i++){
                    Circle c1 = (Circle)list.get(i);
                    if(c.contains(c1.getCenterX(),c1.getCenterY())){
                        list.remove(i);
                    }
                }
            }
        });

        /**
         * eye contact with circle
         * */

        Pane apple = new Pane();
        double width = 200;
        double height = 200;

        Circle cem = new Circle(10);
        setRandomProperties(cem,width,height);
        apple.getChildren().add(cem);

        cem.setOnMouseClicked(e -> {
            apple.getChildren().remove(cem);
            setRandomProperties(cem,width,height);
            apple.getChildren().add(cem);
        });

        Scene scene = new Scene(apple);
        primaryStage.setTitle("circle pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setRandomProperties(Circle c, double width,double height){
        c.setFill(Color.color(Math.random(),Math.random(),Math.random()));
        c.setCenterX(c.getRadius() + Math.random() *
                (width-c.getRadius()*2));
        c.setCenterY(c.getRadius() + Math.random() *
                (height - c.getRadius() * 2));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
