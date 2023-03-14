package twisk.Vue;


import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class VueMondeIG extends Pane implements Observateur {
    private final MondeIG monde;

    public VueMondeIG(MondeIG monMonde) {
        this.monde = monMonde;
        this.monde.ajouterObservateur(this);
        Background bg = new Background(new BackgroundFill(Color.web("F8F8FF"), null, null));
        this.setBackground(bg);
    }

    @Override
    public void reagir() {
        this.getChildren().clear();
        for (EtapeIG e : monde.getEtapes().values()) {
            VueEtapeIG vueActivite = new VueActiviteIG(monde, e);
            this.getChildren().add(vueActivite);
            e.refreshPdc();
           for (PointDeControleIG pdc : e.getPdc()) {
               VuePointDeControleIG vuePointDeControleIG = new VuePointDeControleIG(pdc.getPosX(), pdc.getPosY(), 7, e, monde);
               if (monde.getCpt() % 2 == 0) {
                   vuePointDeControleIG.setFill(Color.web("C0C0C0"));
               } else {
                   vuePointDeControleIG.setFill(Color.gray(0.25));
               }
               vueActivite.getVuePdc().add(vuePointDeControleIG);
               this.getChildren().add(vuePointDeControleIG);
               System.out.println(pdc.getPosX());
           }
        }
    }
}