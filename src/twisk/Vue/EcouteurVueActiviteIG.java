package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.TailleComposants;

public class EcouteurVueActiviteIG implements  EventHandler<MouseEvent> {
    private final VueEtapeIG vueEtapeIG;
    private final EtapeIG etapeIG;

    private final MondeIG monde;

    public EcouteurVueActiviteIG(MondeIG monde, VueEtapeIG vueEtapeIG, EtapeIG etapeIG) {
       this.monde = monde;
        this.vueEtapeIG = vueEtapeIG;
        this.etapeIG = etapeIG;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            this.vueEtapeIG.moveCouleur();
            for (VuePointDeControleIG vPdc : vueEtapeIG) {
                vPdc.setOpacity(0);
            }
            //for (ArcIG) {
                //vArc.setOpacity(0);
            double dragX = mouseEvent.getSceneX() - etapeIG.getPosX();
            double dragY = mouseEvent.getSceneY() - etapeIG.getPosY();

            //nouvelle position du point
            double newXPos = etapeIG.getPosX() + dragX;
            double newYPos = etapeIG.getPosY() + dragY;
            TailleComposants taille = TailleComposants.getInstance();
            if ((newXPos >= 0) && (newXPos <= 1000 - taille.getLargeur(etapeIG))) {
                this.vueEtapeIG.setPosX(newXPos);
                this.etapeIG.setPosX(newXPos);
            }
            if ((newYPos >= 0) && (newYPos <= 900 - taille.getHauteur(etapeIG))) {
                this.vueEtapeIG.setPosY(newYPos);
                this.etapeIG.setPosY(newYPos);
            }

            //essaie de set couleur lors du dragged and drop des pdc
           /* if (monde.getCpt() % 2 == 0) {
                vPdc.setFill(Color.web("C0C0C0"));
            } else {
                vPdc.setFill(Color.gray(0.25));
            }*/
            //try to choose between 2 mouse event -> failed
        }
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
            this.vueEtapeIG.clicCouleur();
            System.out.println(mouseEvent.getEventType());
        }


    }
}




