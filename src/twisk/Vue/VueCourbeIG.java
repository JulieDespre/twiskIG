package twisk.Vue;

import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.CourbeIG;
import twisk.mondeIG.LigneDroiteIG;
import twisk.mondeIG.MondeIG;

public class VueCourbeIG extends VueArcIG{

    public VueCourbeIG(MondeIG monde, CourbeIG courbe) {
        super(monde,courbe);
        this.creationCourbe();
      /*if (monde.getcreationCourbe() == true) {
           this.creationCourbe();
        }*/
    }
    public void creationCourbe(){
        CubicCurve c1= new CubicCurve(this.getArc().getStartX(), this.getArc().getStartY(), ((CourbeIG)(this.getArc())).getP1X(), ((CourbeIG)(this.getArc())).getP1Y(), ((CourbeIG)(this.getArc())).getP2X(), ((CourbeIG)(this.getArc())).getP2Y(), ((CourbeIG)(this.getArc())).getEndX(), ((CourbeIG)(this.getArc())).getEndY());
        c1.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");
        c1.setFill(Color.GHOSTWHITE);
        this.getChildren().addAll(c1);
        //c1.setFill(Color.TRANSPARENT);




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
        //System.out.println(monde.getcreationCourbe());
    }
}
