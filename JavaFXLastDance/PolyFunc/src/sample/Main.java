package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        pane.setRotate(180);
        pane.setPadding(new Insets(72,0,0,75));
        Pane pane1 = new Pane();

        Polyline polyline1 = new Polyline();
        pane.getChildren().add(polyline1);
        ObservableList<Double> list = polyline1.getPoints();
        double scaleFactor = 0.0125;
        for(int x = -100; x <=100; x++){
            list.add(x+200.0);
            list.add(scaleFactor*x*x);
        }

        Line lineX = new Line(10,200,350,200);
        Line lineY = new Line(lineX.getEndX()/2,250,lineX.getEndX()/2,30);
        pane1.getChildren().addAll(pane,lineX,lineY);

        // Create two polylines
        Polyline polyline2 = new Polyline();
        pane1.getChildren().add(polyline2);
        ObservableList<Double> list2 = polyline2.getPoints();
        list2.addAll(lineY.getEndX() - 10, lineY.getEndY() + 20,
                lineY.getEndX(), lineY.getEndY(), lineY.getEndX() + 10,
                lineY. getEndY() + 20);

        Polyline polyline3 = new Polyline();
        pane1.getChildren().add(polyline3);
        ObservableList<Double> list3 = polyline3.getPoints();
        list3.addAll(lineX.getEndX() - 20, lineX.getEndY() - 10,
                lineX.getEndX(), lineX.getEndY(), lineX.getEndX() - 20,
                lineX. getEndY() + 10);

        // Create two text objects
        Text textX = new Text(lineX.getEndX() - 10, lineX.getEndY() - 20, "X");
        Text textY = new Text(lineY.getEndX() + 20, lineY.getEndY() + 10, "Y");
        pane1.getChildren().addAll(textX, textY);

        /**
         * RECTANGLE OVERLAPS
         * */

        Scanner input = new Scanner(System.in);

        // Create a pane and a vbox
        Pane pane3 = new Pane();
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(10, 5, 5, 10));

        // Prompt the user to enter the parameters of two rectangles
        System.out.print("Enter the center coordinates, width " +
                "and height of rectangle 1: ");
        String[] str1 = (input.nextLine()).split("[ ]");
        Rectangle r1 = getRectangle(str1);

        System.out.print("Enter the center coordinates, width " +
                "and height of rectangle 2: ");
        String[] str2 = (input.nextLine()).split("[ ]");
        Rectangle r2 = getRectangle(str2);

        // Test if rectangles contain or overlap each other
        String output = "        ";
        if (contains(r1, r2) || contains(r2, r1))
            output += "One rectangle is contained in another ";
        else if (overlaps(r1, r2))
            output += "The rectangles overlap ";
        else
            output += "The rectangles do not overlap ";

        // Add rectangles to pane
        pane3.getChildren().addAll(r1, r2);

        // Place nodes in vbox
        vBox.getChildren().addAll(pane3, new Text(20, 0, output));


        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Exercise_14_18"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }


    public static void main(String[] args) {
        launch(args);
    }

    private Rectangle getRectangle(String[] s){
        Rectangle r = new Rectangle(Double.parseDouble(s[0]),
                Double.parseDouble(s[1]), Double.parseDouble(s[2]),
                Double.parseDouble(s[3]));
        r.setFill(Color.WHITE);
        r.setStroke(Color.BLACK);
        return r;
    }

    public boolean contains(Rectangle r1,Rectangle r2){
        return r2.getY()+r2.getHeight() <= r1.getY()+r1.getHeight()
                && r2.getX()+r2.getWidth() <= r1.getX()+r1.getWidth()
                && r2.getX() > r1.getX() && r2.getY() > r1.getY();
    }

    public boolean overlaps(Rectangle r1, Rectangle r2){
        return getDistance(r1.getX(), r2.getX() + r2.getWidth()) <
                r1.getWidth() + r2.getWidth() &&
                getDistance(r1.getY(), r2.getY() + r2.getHeight()) <
                        r1.getHeight() + r2.getHeight();
    }

    private double getDistance(double p1, double p2) {
        return Math.sqrt(Math.pow(p2 - p1, 2));
    }
}
