package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twisk.Vue.VueMenu;
import twisk.Vue.VueMondeIG;
import twisk.Vue.VueOutils;
import twisk.mondeIG.MondeIG;

public class MainTwisk extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("CREATEUR DE MONDES");
        primaryStage.setResizable(false);
        BorderPane root = new BorderPane();
        root.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        MondeIG monMonde = new MondeIG();
        VueMondeIG vueMond =new VueMondeIG(monMonde);
        root.setCenter(vueMond);

        VueOutils vueOut = new VueOutils(monMonde);
        root.setBottom(vueOut);

        VueMenu vueMen = new VueMenu(monMonde);
        root.setTop(vueMen);

        primaryStage.show();
    }
    public static void main(String[] args) {

        launch(args);
    }
}
