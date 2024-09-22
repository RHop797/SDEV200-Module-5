import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleColorChangeApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a circle
        Circle circle = new Circle(100); // Circle with a radius of 100
        circle.setFill(Color.WHITE); // Initial color is white

        // Add event handler for mouse press (change to black)
        circle.setOnMousePressed((MouseEvent event) -> {
            circle.setFill(Color.BLACK);
        });

        // Add event handler for mouse release (change to white)
        circle.setOnMouseReleased((MouseEvent event) -> {
            circle.setFill(Color.WHITE);
        });

        // Set up the scene graph
        StackPane root = new StackPane();
        root.getChildren().add(circle);

        // Create a scene and set the background color to gray
        Scene scene = new Scene(root, 300, 300);
        scene.setFill(Color.GRAY); // Change background color to gray so circle is visible

        primaryStage.setTitle("Circle Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
