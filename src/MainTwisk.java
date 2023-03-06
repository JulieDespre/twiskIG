import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainTwisk extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Créateur de Monde");
        primaryStage.setResizable(false);
        BorderPane root = new BorderPane();
        primaryStage.setScene(new Scene(root, 1000, 1000));


        Rectangle rect = new Rectangle(300, 150);
        rect.setLayoutX(350);
        rect.setLayoutY(350);
        rect.setStyle("-fx-fill: pink; ");
        root.getChildren().add(rect);

        primaryStage.show();
    }
    public static void main(String[] args) {

        launch(args);
    }
}
