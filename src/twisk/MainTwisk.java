package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import twisk.Vue.VueMondeIG;
import twisk.Vue.VueOutils;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class MainTwisk extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Créateur de Mondes");
        primaryStage.setResizable(false);
        BorderPane root = new BorderPane();
        primaryStage.setScene(new Scene(root, 1000, 1000));
        MondeIG monMonde = new MondeIG();
        VueMondeIG vueMond =new VueMondeIG(monMonde);
        root.setCenter(vueMond);
        EtapeIG test1 = new ActiviteIG("test1",300, 150);

        VueOutils vueOut = new VueOutils(monMonde);
        root.setBottom(vueOut);

        //Rectangle rect = new Rectangle(300, 150);
        //rect.setLayoutX(350);
        //rect.setLayoutY(350);
        //rect.setStyle("-fx-fill: pink; ");
        //root.getChildren().add(rect);

        primaryStage.show();
    }
    public static void main(String[] args) {

        launch(args);
    }
}
