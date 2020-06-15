package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FlowPane pane1 = new FlowPane();
        pane1.setPadding(new Insets(11,12,13,14));
        pane1.setHgap(5);
        pane1.setVgap(5);

        pane1.getChildren().addAll(new Label("first number:"), new TextField(),new Label("MI:"));
        TextField tfMi = new TextField();
        tfMi.setPrefColumnCount(1);
        pane1.getChildren().addAll(tfMi,new Label("Last name:"),new TextField());

        Scene scene1 = new Scene(pane1,200,250);
        primaryStage.setTitle("showpane");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
