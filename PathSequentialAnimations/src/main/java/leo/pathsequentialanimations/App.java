package leo.pathsequentialanimations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pane animationPane = new Pane();
        animationPane.setPrefSize(660, 380);
        animationPane.setStyle("-fx-background-color: white;");
        
    }

    public static void main(String[] args) {
        launch();
    }

}