package twisk.mondeGraphique.vues;


import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import twisk.mondeGraphique.Observateur;
import twisk.mondeGraphique.ecouteurs.EcouteurMonde;
import twisk.mondeIG.*;


public class VueMondeIG extends Pane implements Observateur {
    private final MondeIG monde;

    public VueMondeIG(MondeIG monMonde) {
        this.monde = monMonde;
        this.monde.ajouterObservateur(this);
        Background bg = new Background(new BackgroundFill(Color.web("F8F8FF"), null, null));
        this.setBackground(bg);
    }

    @Override
    public void reagir(){
        this.getChildren().clear();

        //boucle de mise à jour des données
        for (EtapeIG e : monde.getEtapes().values()) {
            e.refreshPdc();
        }

        //creation des vues graphiques
            for (CourbeIG curve : monde.getCourbes()) {
                curve.getPdcStart().setHasArc();
                curve.getPdcEnd().setHasArc();
                VueCourbeIG vCourbe = new VueCourbeIG(monde, curve);
                this.getChildren().add(vCourbe);
                if (!curve.getSelect()){
                    vCourbe.setStyle("-fx-stroke: slategrey; -fx-opacity: 1");
                }else{
                    vCourbe.setStyle("-fx-stroke: slategrey; -fx-opacity: 0.25");
                }
            }

            for (LigneDroiteIG ligne : monde.getLignes()) {
                ligne.getPdcStart().setHasArc();
                ligne.getPdcEnd().setHasArc();
                VueArcIG vArc = new VueLigneDroite(monde, ligne);
                this.getChildren().add(vArc);
                if (!ligne.getSelect()){
                    vArc.setStyle("-fx-stroke: slategrey; -fx-opacity: 1");
                }else{
                    vArc.setStyle("-fx-stroke: slategrey; -fx-opacity: 0.25");
                }
        }

        for (EtapeIG e : monde.getEtapes().values()) {
            VueEtapeIG vueActivite = new VueActiviteIG(monde, e);
            if (monde.hasBeenClicked(e)) vueActivite.clicCouleur();
            this.getChildren().add(vueActivite);
            for (PointDeControleIG pdc : e.getPdc()) {
                VuePointDeControleIG vuePointDeControleIG = new VuePointDeControleIG(pdc.getPosX(), pdc.getPosY(), 9, e, monde, pdc);
                if (pdc.getHasArc()){
                    vuePointDeControleIG.setFill(Color.SLATEGRAY);
                } else if (pdc.getCpt() % 2 == 0) {
                    vuePointDeControleIG.setFill(Color.web("C0C0C0"));
                } else {
                    vuePointDeControleIG.setFill(Color.SLATEGRAY);
                }
                vueActivite.getVuePdc().add(vuePointDeControleIG);
                this.getChildren().add(vuePointDeControleIG);
            }
        }
        this.setOnMouseClicked(new EcouteurMonde(monde));
    }
}