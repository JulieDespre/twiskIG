package twisk.Vue;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import twisk.mondeIG.CourbeIG;
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

        double taille=40;

        Point2D pdcEnd = eval(c1,1);
        Point2D tan =evalDt(c1,1).normalize().multiply(taille);
        Path flèche=new Path();
        flèche.getElements().add(new MoveTo(pdcEnd.getX()-0.2*tan.getX()-0.2*tan.getY(), pdcEnd.getY()-0.2*tan.getY()+0.2*tan.getX()));
        flèche.getElements().add(new LineTo(pdcEnd.getX(), pdcEnd.getY()));
        flèche.getElements().add(new LineTo(pdcEnd.getX()-0.2*tan.getX()+0.2*tan.getY(),
                pdcEnd.getY()-0.2*tan.getY()-0.2*tan.getX()));

        this.getChildren().addAll(c1, flèche);
    }

    /**
     * Evaluate the cubic curve at a parameter 0<=t<=1, returns a Point2D
     * @param c1 the CubicCurve
     * @param i param between 0 and 1
     * @return a Point2D
     */
    private Point2D eval(CubicCurve c1, float i){
        Point2D p1=new Point2D(Math.pow(1-i,3)*c1.getStartX()+ 3*i*Math.pow(1-i,2)*c1.getControlX1()+ 3*(1-i)*i*i*c1.getControlX2()+ Math.pow(i, 3)*c1.getEndX(), Math.pow(1-i,3)*c1.getStartY()+ 3*i*Math.pow(1-i, 2)*c1.getControlY1()+ 3*(1-i)*i*i*c1.getControlY2()+ Math.pow(i, 3)*c1.getEndY());
        return p1;
    }

    /**
     * Evaluate the tangent of the cubic curve at a parameter 0<=t<=1, returns a Point2D
     * @param c the CubicCurve
     * @param t param between 0 and 1
     * @return a Point2D
     */
    private Point2D evalDt(CubicCurve c, float t){
        Point2D p=new Point2D(-3*Math.pow(1-t,2)*c.getStartX()+
                3*(Math.pow(1-t, 2)-2*t*(1-t))*c.getControlX1()+
                3*((1-t)*2*t-t*t)*c.getControlX2()+
                3*Math.pow(t, 2)*c.getEndX(),
                -3*Math.pow(1-t,2)*c.getStartY()+
                        3*(Math.pow(1-t, 2)-2*t*(1-t))*c.getControlY1()+
                        3*((1-t)*2*t-t*t)*c.getControlY2()+
                        3*Math.pow(t, 2)*c.getEndY());
        return p;
    }
}
