import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ImageGridPaneApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane layout
        GridPane gridPane = new GridPane();

        // Load the images
        Image image1 = new Image("file:Images/brotherhoodofsteel.png");
        Image image2 = new Image("file:Images/enclave.png");
        Image image3 = new Image("file:Images/institute.jpg");
        Image image4 = new Image("file:Images/minutemen.png");

        // Create ImageViews for each image
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        // Set Sizes
        imageView1.setFitWidth(200);
        imageView1.setFitHeight(200);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(200);
        imageView3.setFitWidth(200);
        imageView3.setFitHeight(200);
        imageView4.setFitWidth(200);
        imageView4.setFitHeight(200);

        // Add ImageViews to the grid (row, column)
        gridPane.add(imageView1, 0, 0); // First row, first column
        gridPane.add(imageView2, 1, 0); // First row, second column
        gridPane.add(imageView3, 0, 1); // Second row, first column
        gridPane.add(imageView4, 1, 1); // Second row, second column

        // Create a scene and add the gridPane
        Scene scene = new Scene(gridPane, 450, 450);

        // Set up the stage
        primaryStage.setTitle("Image GridPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
