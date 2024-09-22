import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorSelectorApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create Sliders for Red, Green, Blue, and Opacity
        Slider redSlider = createColorSlider();
        Slider greenSlider = createColorSlider();
        Slider blueSlider = createColorSlider();
        Slider opacitySlider = createOpacitySlider();

        // Text to display color
        Text coloredText = new Text("Colored Text");
        coloredText.setStyle("-fx-font-size: 24px;");

        // Set initial color
        coloredText.setFill(Color.color(0, 0, 0, 1));

        // Add event listeners to sliders to manually update the text color
        redSlider.valueProperty().addListener((obs, oldVal, newVal) -> updateTextColor(coloredText, redSlider, greenSlider, blueSlider, opacitySlider));
        greenSlider.valueProperty().addListener((obs, oldVal, newVal) -> updateTextColor(coloredText, redSlider, greenSlider, blueSlider, opacitySlider));
        blueSlider.valueProperty().addListener((obs, oldVal, newVal) -> updateTextColor(coloredText, redSlider, greenSlider, blueSlider, opacitySlider));
        opacitySlider.valueProperty().addListener((obs, oldVal, newVal) -> updateTextColor(coloredText, redSlider, greenSlider, blueSlider, opacitySlider));

        // Layout for sliders and labels
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Add sliders and labels to the grid
        gridPane.add(new Label("Red"), 0, 0);
        gridPane.add(redSlider, 1, 0);
        gridPane.add(new Label("Green"), 0, 1);
        gridPane.add(greenSlider, 1, 1);
        gridPane.add(new Label("Blue"), 0, 2);
        gridPane.add(blueSlider, 1, 2);
        gridPane.add(new Label("Opacity"), 0, 3);
        gridPane.add(opacitySlider, 1, 3);

        // Layout for the scene
        VBox vbox = new VBox(20, gridPane, coloredText);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20px;");

        // Scene and Stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Text Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to update the text color based on slider values
    private void updateTextColor(Text text, Slider redSlider, Slider greenSlider, Slider blueSlider, Slider opacitySlider) {
        double red = redSlider.getValue() / 255.0;
        double green = greenSlider.getValue() / 255.0;
        double blue = blueSlider.getValue() / 255.0;
        double opacity = opacitySlider.getValue() / 100.0;
        text.setFill(Color.color(red, green, blue, opacity));
    }

    // Create a color slider (for Red, Green, Blue)
    private Slider createColorSlider() {
        Slider slider = new Slider(0, 255, 0);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(50);
        slider.setBlockIncrement(10);
        return slider;
    }

    // Create an opacity slider (0% to 100%)
    private Slider createOpacitySlider() {
        Slider slider = new Slider(0, 100, 100);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(25);
        slider.setBlockIncrement(5);
        return slider;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
