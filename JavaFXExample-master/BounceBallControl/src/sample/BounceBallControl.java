package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BounceBallControl extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BallPane ballPane = new BallPane();

        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        ballPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.BACK_SPACE){
                    ballPane.increaseSpeed();
                }
                else if (event.getCode() == KeyCode.NUMPAD2){
                    ballPane.decreaseSpeed();
                }
            }
        });
        Stage stage = new Stage();
        BorderPane pn = new BorderPane();
        Scene sc1 = new Scene(pn,200,150);
        stage.setScene(sc1);
        stage.setTitle("bala");
        stage.opacityProperty();
        stage.show();

        Scene scene = new Scene(ballPane, 250, 150);
        primaryStage.setTitle("BounceBallControl");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
