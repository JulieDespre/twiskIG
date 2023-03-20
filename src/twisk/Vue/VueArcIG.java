package twisk.Vue;

import javafx.scene.layout.Pane;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import twisk.mondeIG.LigneDroiteIG;
import twisk.mondeIG.MondeIG;

public class VueArcIG extends Pane {
    private final MondeIG monde;
    private final LigneDroiteIG ligneDroite;

    public VueArcIG(MondeIG monde, LigneDroiteIG ligneDroite) {
        this.monde = monde;
        this.ligneDroite = ligneDroite;

        this.creationArcLigne();
        if (monde.getcreationLigne() == true) {
           this.creationArcLigne();
        }
       /*if (monde.getcreationCourbe() == true) {
           this.creationArcCourbe();
        }*/
        }
        public void creationArcLigne(){
            Line l1 = new Line(ligneDroite.getStartX(), ligneDroite.getStartY(), ligneDroite.getEndX(), ligneDroite.getEndY());
            l1.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");
            double pente = (ligneDroite.getStartY() - ligneDroite.getEndY()) / (ligneDroite.getStartX() - ligneDroite.getEndX());
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

            this.getChildren().addAll(l1, fleche1, fleche2);
            System.out.println(monde.getcreationLigne());
        }

        public void creationArcCourbe(){
            /*CubicCurve l2 = new CubicCurve(arcIG.getStartX(), arcIG.getStartY(), arcIG.getEndX(), arcIG.getEndY());
            l2.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");
            double pente = (arcIG.getStartY() - arcIG.getEndY()) / (arcIG.getStartX() - arcIG.getEndX());
            double angle = Math.atan(pente);

            double angleFleche = arcIG.getStartX() > arcIG.getEndX() ? Math.toRadians(45) : -Math.toRadians(200);
            double tailleFleche = 15;

            //creation de la flèche
            System.out.println(monde.getcreationLigne());
            Line fleche1 = new Line();
            fleche1.setStartX(l2.getEndX());
            fleche1.setStartY(l2.getEndY());
            fleche1.setEndX(l2.getEndX() + tailleFleche * Math.cos(angle - angleFleche));
            fleche1.setEndY(l2.getEndY() + tailleFleche * Math.sin(angle - angleFleche));
            fleche1.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");

            Line fleche2 = new Line();
            fleche2.setStartX(l2.getEndX());
            fleche2.setStartY(l2.getEndY());
            fleche2.setEndX(l2.getEndX() + tailleFleche * Math.cos(angle + angleFleche));
            fleche2.setEndY(l2.getEndY() + tailleFleche * Math.sin(angle + angleFleche));
            fleche2.setStyle("-fx-stroke-width: 2px; -fx-stroke: slategrey");

            this.getChildren().addAll(l2, fleche1, fleche2);
            System.out.println(monde.getcreationLigne());*/
        }
    }

