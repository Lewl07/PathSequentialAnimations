package leo.pathsequentialanimations;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    // Rectangular path M N P Q
    private static final double MX = 80,  MY = 60;    // M (top-left)
    private static final double NX = 580, NY = 60;    // N (top-right)
    private static final double PX = 580, PY = 310;   // P (bottom-right)
    private static final double QX = 80,  QY = 310;   // Q (bottom-left)
    private static final Duration TOP_BOTTOM = Duration.seconds(8.0 / 3);
    private static final Duration SIDES = Duration.seconds(4.0 / 3);

    private Circle circle;
    private Polygon triangle;
    private ParallelTransition animation;
    private PauseTransition endDelay;
    private Button startButton;
    
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
        
        circle = new Circle(0, 0, 14, Color.CRIMSON);
        circle.setStroke(Color.BLACK);
        circle.setTranslateX(MX);
        circle.setTranslateY(MY);
        
        triangle = new Polygon(330, 150, 375, 220, 285, 220);
        triangle.setFill(Color.CORNFLOWERBLUE);
        triangle.setStroke(Color.BLACK);
 
        animationPane.getChildren().addAll(path, triangle, circle);
        
        PathTransition aroundPath = new PathTransition(Duration.seconds(8), path, circle);
        aroundPath.setInterpolator(Interpolator.LINEAR);
 
        FadeTransition fade = new FadeTransition(TOP_BOTTOM, triangle);
        fade.setFromValue(1);
        fade.setToValue(0.25);

        ScaleTransition scale = new ScaleTransition(SIDES, triangle);
        scale.setToX(1.6);
        scale.setToY(1.6);

        RotateTransition rotate = new RotateTransition(TOP_BOTTOM, triangle);
        rotate.setByAngle(360);

        TranslateTransition moveUp = new TranslateTransition(SIDES, triangle);
        moveUp.setByY(-70);
        
        SequentialTransition sequence = new SequentialTransition(fade, scale, rotate, moveUp);
        animation = new ParallelTransition(aroundPath, sequence);
        animation.setOnFinished(event -> {
            endDelay = new PauseTransition(Duration.seconds(2));
            endDelay.setOnFinished(done -> Platform.exit());
            endDelay.play();
        });
    }

    public static void main(String[] args) {
        launch();
    }

}