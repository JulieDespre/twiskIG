package twisk.mondeGraphique.vues;

import javafx.scene.shape.Line;
import twisk.mondeIG.LigneDroiteIG;
import twisk.mondeIG.MondeIG;

public class VueLigneDroite extends VueArcIG {
    public VueLigneDroite(MondeIG monde, LigneDroiteIG ligneDroite) {
        super(monde, ligneDroite);
        creationArcLigne();
    }

    public void creationArcLigne(){
        Line l1 = new Line(this.getArc().getStartX(), this.getArc().getStartY(),this.getArc().getEndX(), this.getArc().getEndY());
        l1.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");
        double pente = (this.getArc().getStartY() - this.getArc().getEndY()) / (this.getArc().getStartX() - this.getArc().getEndX());
        double angle = Math.atan(pente);

        double angleFleche =this.getArc().getStartX() > this.getArc().getEndX() ? Math.toRadians(20) : -Math.toRadians(200);
        double tailleFleche = 40;

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
