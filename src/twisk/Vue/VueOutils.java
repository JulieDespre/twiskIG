package twisk.Vue;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import twisk.mondeIG.MondeIG;

public class VueOutils extends TilePane implements Observateur {
    private MondeIG monde;

    public VueOutils(MondeIG monde) {
        this.monde = monde;

        Background bg = new Background(new BackgroundFill(Color.web("#F0F0F2"), null, null));
        this.setBackground(bg);
        Button addAct = new Button();
        addAct.setBackground(bg);
        Image image = new Image(getClass().getResourceAsStream("/addAct.png"), 55, 60, true, true);
        ImageView icon = new ImageView(image);
        addAct.setGraphic(icon) ;
        this.getChildren().add(addAct);
        addAct.setOnAction(new EcouteurBouton());

    }

    @Override
    public void reagir() {

    }
}
