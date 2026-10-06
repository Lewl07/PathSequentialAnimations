package leo.pathsequentialanimations;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;


/**
 * JavaFX App
 */
public class App extends Application {

    // Rectangular path M N P Q
    private static final double MX = 80,  MY = 60;    // M (top-left)
    private static final double NX = 580, NY = 60;    // N (top-right)
    private static final double PX = 580, PY = 310;   // P (bottom-right)
    private static final double QX = 80,  QY = 310;   // Q (bottom-left)
    
    @Override
    public void start(Stage stage) {
        Pane animationPane = new Pane();
        animationPane.setPrefSize(660, 380);
        animationPane.setStyle("-fx-background-color: white;");
        
                // Rectangular path
        Path path = new Path(
                new MoveTo(MX, MY),
                new LineTo(NX, NY),
                new LineTo(PX, PY),
                new LineTo(QX, QY),
                new ClosePath());
    }

    public static void main(String[] args) {
        launch();
    }

}