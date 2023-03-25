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
        //pb pas d'affichage des lignes et prend en compte trop de clic

            for (CourbeIG curve : monde.getCourbes()) {
                VueCourbeIG vCourbe = new VueCourbeIG(monde, curve);
                this.getChildren().add(vCourbe);
                System.out.println("hello" + monde.getPointCliked().size());
            }

            for (LigneDroiteIG ligne : monde.getLignes()) {
                VueArcIG vArc = new VueLigneDroite(monde, ligne);
                this.getChildren().add(vArc);
                System.out.println("bonjour" + monde.getPointCliked().size());

        }

        for (EtapeIG e : monde.getEtapes().values()) {
            VueEtapeIG vueActivite = new VueActiviteIG(monde, e);
            if (monde.hasBeenClicked(e)) vueActivite.clicCouleur();
            this.getChildren().add(vueActivite);
            for (PointDeControleIG pdc : e.getPdc()) {
                VuePointDeControleIG vuePointDeControleIG = new VuePointDeControleIG(pdc.getPosX(), pdc.getPosY(), 9, e, monde, pdc);
                if (pdc.getCpt() % 2 == 0) {
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