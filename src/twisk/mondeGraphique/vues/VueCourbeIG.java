package twisk.mondeGraphique.vues;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import twisk.mondeIG.CourbeIG;
import twisk.mondeIG.MondeIG;

public class VueCourbeIG extends VueArcIG {

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
        c1.setFill(Color.TRANSPARENT);

        double taille=80;

        Point2D tan = getPtTan(c1,1).normalize().multiply(taille);

        double angle = Math.atan(tan.getY()/tan.getX());
        double angleFleche =this.getArc().getStartX() > this.getArc().getEndX() ? Math.toRadians(20) : -Math.toRadians(200);
        double tailleFleche = 20;

        //creation de la flèche
        Line fleche1 = new Line();
        fleche1.setStartX(c1.getEndX());
        fleche1.setStartY(c1.getEndY());
        fleche1.setEndX(c1.getEndX() + tailleFleche * Math.cos(angle - angleFleche));
        fleche1.setEndY(c1.getEndY() + tailleFleche * Math.sin(angle - angleFleche));
        fleche1.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");

        Line fleche2 = new Line();
        fleche2.setStartX(c1.getEndX());
        fleche2.setStartY(c1.getEndY());
        fleche2.setEndX(c1.getEndX() + tailleFleche * Math.cos(angle + angleFleche));
        fleche2.setEndY(c1.getEndY() + tailleFleche * Math.sin(angle + angleFleche));
        fleche2.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");

        this.getChildren().addAll(c1, fleche1, fleche2);
    }

    /**
     * Evaluate the tangent of the cubic curve at a parameter 0<=t<=1, returns a Point2D
     * @param c the CubicCurve
     * @param t param between 0 and 1
     * @return a Point2D
     */
    private Point2D getPtTan(CubicCurve c, double t){
        Point2D ptTan=new Point2D(-3*Math.pow(1-t,2)*c.getStartX()+ 3*(Math.pow(1-t, 2)-2*t*(1-t))*c.getControlX1()+3*((1-t)*2*t-t*t)*c.getControlX2()+3*Math.pow(t, 2)*c.getEndX(),-3*Math.pow(1-t,2)*c.getStartY()+3*(Math.pow(1-t, 2)-2*t*(1-t))*c.getControlY1()+3*((1-t)*2*t-t*t)*c.getControlY2()+3*Math.pow(t, 2)*c.getEndY());
        return ptTan;
    }
}
