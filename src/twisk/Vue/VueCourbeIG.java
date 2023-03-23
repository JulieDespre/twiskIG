package twisk.Vue;

import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import twisk.mondeIG.CourbeIG;
import twisk.mondeIG.LigneDroiteIG;
import twisk.mondeIG.MondeIG;

public class VueCourbeIG {
    private MondeIG monde;
    private CourbeIG courbe;

    public VueCourbeIG(MondeIG monde, CourbeIG courbe) {
        this.monde = monde;
        this.courbe = courbe;

       if (monde.getcreationCourbe() == true) {
           this.creationCourbe();
        }
    }
    public void creationCourbe(){
        CubicCurve c1= new CubicCurve(courbe.getStartX(), courbe.getStartY(), courbe.getP1X(), courbe.getP1Y(), courbe.getP2X(), courbe.getP2X(), courbe.getEndX(), courbe.getEndY());
        c1.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");

        /*double pente = (ligneDroite.getStartY() - ligneDroite.getEndY()) / (ligneDroite.getStartX() - ligneDroite.getEndX());
        double angle = Math.atan(pente);

        double angleFleche = ligneDroite.getStartX() > ligneDroite.getEndX() ? Math.toRadians(20) : -Math.toRadians(200);
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

        this.getChildren().addAll(l1, fleche1, fleche2);*/
        System.out.println(monde.getcreationCourbe());
    }
}
