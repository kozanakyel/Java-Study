package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    protected TextField tfDecimal = new TextField();
    protected TextField tfHex = new TextField();
    protected TextField tfBinary = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception{
        tfDecimal.setAlignment(Pos.BASELINE_RIGHT);
        tfHex.setAlignment(Pos.BOTTOM_RIGHT);
        tfBinary.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(2);
        pane.add(new Label("Decimal"),0,0);
        pane.add(tfDecimal,1,0);
        pane.add(new Label("Hex"), 0, 1);
        pane.add(tfHex, 1, 1);
        pane.add(new Label("Binary"), 0, 2);
        pane.add(tfBinary, 1, 2);

        tfDecimal.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                tfHex.setText(Integer.toHexString(
                        Integer.parseInt(tfDecimal.getText())));

                tfBinary.setText(Integer.toBinaryString(
                        Integer.parseInt(tfDecimal.getText())
                ));
            }
        });

        tfHex.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                tfDecimal.setText(String.valueOf(
                        Integer.parseInt(tfHex.getText(), 16)));

                tfBinary.setText(Integer.toBinaryString(
                        Integer.parseInt(tfHex.getText(), 16)));
            }
        });

        tfBinary.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                tfDecimal.setText(String.valueOf(
                        Integer.parseInt(tfBinary.getText(), 2)));

                tfHex.setText(Integer.toHexString(
                        Integer.parseInt(tfBinary.getText(), 2)));
            }
        });

        Scene scene = new Scene(pane,250,300);
        primaryStage.setTitle("Convert numbers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
