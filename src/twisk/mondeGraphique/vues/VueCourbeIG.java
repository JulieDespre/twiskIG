package twisk.mondeGraphique.vues;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import twisk.mondeGraphique.ecouteurs.EcouteurVueArc;
import twisk.mondeIG.CourbeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

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
        c1.setOnMouseClicked(new EcouteurVueArc(getMonde(), this,getArc()));
        double taille=80;

        Point2D tan = getPtTan(c1,1).normalize().multiply(taille);

        double angle = Math.atan(tan.getY()/tan.getX());
        double angleFleche =this.getArc().getStartX() > this.getArc().getEndX() ? Math.toRadians(20) : -Math.toRadians(200);
        double tailleFleche = 40;

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

        //modification des courbes
        //ligneModif(c1, 100);

        this.getChildren().addAll(c1, fleche1, fleche2);
    }

    public Point2D getPtTan(CubicCurve c, double t){
        Point2D ptTan=new Point2D(-3*Math.pow(1-t,2)*c.getStartX()+ 3*(Math.pow(1-t, 2)-2*t*(1-t))*c.getControlX1()+3*((1-t)*2*t-t*t)*c.getControlX2()+3*Math.pow(t, 2)*c.getEndX(),-3*Math.pow(1-t,2)*c.getStartY()+3*(Math.pow(1-t, 2)-2*t*(1-t))*c.getControlY1()+3*((1-t)*2*t-t*t)*c.getControlY2()+3*Math.pow(t, 2)*c.getEndY());
        return ptTan;
    }

    public void ligneModif(CubicCurve courbe, int tailleLine){
        Line lineRegPdcStart = new Line();
        lineRegPdcStart.setStartX(courbe.getStartX());
        lineRegPdcStart.setStartY(courbe.getStartY());
        lineRegPdcStart.setEndX(courbe.getStartX()-tailleLine);
        lineRegPdcStart.setEndY(courbe.getStartY()+100);
        lineRegPdcStart.setStrokeWidth(2);
        lineRegPdcStart.setStroke(Color.GRAY.deriveColor(0, 1, 1, 0.5));
        lineRegPdcStart.setStrokeLineCap(StrokeLineCap.BUTT);
        lineRegPdcStart.getStrokeDashArray().setAll(10.0, 5.0);

        Line lineRegPdcEnd = new Line();
        lineRegPdcEnd.setStartX(courbe.getEndX());
        lineRegPdcEnd.setStartY(courbe.getEndY());
        lineRegPdcEnd.setEndX(courbe.getEndX()-tailleLine);
        lineRegPdcEnd.setEndY(courbe.getEndY()-100);
        lineRegPdcEnd.setStrokeWidth(2);
        lineRegPdcEnd.setStroke(Color.GRAY.deriveColor(0, 1, 1, 0.5));
        lineRegPdcEnd.setStrokeLineCap(StrokeLineCap.BUTT);
        lineRegPdcEnd.getStrokeDashArray().setAll(10.0, 5.0);

        cercleModif(lineRegPdcStart);
        cercleModif(lineRegPdcEnd);

        this.getChildren().addAll(lineRegPdcStart, lineRegPdcEnd);
    }
    public void cercleModif(Line ligne){
        Circle cercleEnd1 = new Circle(ligne.getEndX(), ligne.getEndY(), 6);
        cercleEnd1.setFill(Color.SLATEGRAY.deriveColor(1, 1, 1, 0.5));
        cercleEnd1.setStroke(Color.SLATEGRAY);
        cercleEnd1.setStrokeWidth(2);
        cercleEnd1.setStrokeType(StrokeType.OUTSIDE);

        this.getChildren().add(cercleEnd1);

    }

}
