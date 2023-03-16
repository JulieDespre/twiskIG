package twisk.Vue;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;

public class VueArcIG extends Pane {
    private final MondeIG monde;
    private final ArcIG arcIG;

    public VueArcIG(MondeIG monde, ArcIG arcIG) {
        this.monde = monde;
        this.arcIG = arcIG;

        Line l1 = new Line(arcIG.getStartX(),arcIG.getStartY(), arcIG.getEndX(), arcIG.getEndY());
        l1.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");
        double pente = (arcIG.getStartY()-arcIG.getEndY())/(arcIG.getStartX()-arcIG.getEndX());
        double angle = Math.atan(pente);

        double angleFleche= arcIG.getStartX() > arcIG.getEndX() ? Math.toRadians(45) : -Math.toRadians(200);
        double tailleFleche = 15;

        //creation de la flèche
        Line fleche1 = new Line();
        fleche1.setStartX(l1.getEndX());
        fleche1.setStartY(l1.getEndY());
        fleche1.setEndX(l1.getEndX() + tailleFleche * Math.cos(angle - angleFleche));
        fleche1.setEndY(l1.getEndY() + tailleFleche * Math.sin(angle - angleFleche));
        fleche1.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");

        Line fleche2 = new Line();
        fleche2.setStartX(l1.getEndX());
        fleche2.setStartY(l1.getEndY());
        fleche2.setEndX(l1.getEndX() + tailleFleche * Math.cos(angle + angleFleche));
        fleche2.setEndY(l1.getEndY() + tailleFleche * Math.sin(angle + angleFleche));
        fleche2.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");

        this.getChildren().addAll(l1, fleche1, fleche2);
    }
}

