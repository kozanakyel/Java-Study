package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    protected Text text = new Text(50,50,"kozan AKYEL");

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("<=");
        Button btRight = new Button("=>");
        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        HBox paneForRadioButtons = new HBox(20);
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");
        paneForRadioButtons.getChildren().addAll(rbBlack,rbGreen,rbOrange,rbRed,rbYellow);

        ToggleGroup group = new ToggleGroup();
        rbBlack.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbOrange.setToggleGroup(group);
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);

        Pane paneForText = new Pane();
        paneForText.setStyle("-fx-border-color: black");
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);
        pane.setTop(paneForRadioButtons);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        rbBlack.setOnAction(e -> {
            if(rbBlack.isSelected()){
                text.setFill(Color.BLACK);
            }
        });

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                text.setFill(Color.RED);
            }
        });

        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                text.setFill(Color.YELLOW);
            }
        });

        rbOrange.setOnAction(e -> {
            if (rbOrange.isSelected()) {
                text.setFill(Color.ORANGE);
            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });

        Scene scene = new Scene(pane,450,150);
        primaryStage.setTitle("Radio buttons ...");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
