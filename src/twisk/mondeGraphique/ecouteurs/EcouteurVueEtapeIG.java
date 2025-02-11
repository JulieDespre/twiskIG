package twisk.mondeGraphique.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeGraphique.vues.VueEtapeIG;
import twisk.mondeGraphique.vues.VuePointDeControleIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

public class EcouteurVueEtapeIG implements  EventHandler<MouseEvent> {
    private final VueEtapeIG vueEtapeIG;
    private final EtapeIG etapeIG;
    private final MondeIG monde;

    public EcouteurVueEtapeIG(MondeIG monde, VueEtapeIG vueEtapeIG, EtapeIG etapeIG) {
        this.monde = monde;
        this.vueEtapeIG = vueEtapeIG;
        this.etapeIG = etapeIG;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                vueEtapeIG.setWasDragged(true);
                this.vueEtapeIG.moveCouleur();
                for (VuePointDeControleIG vPdc : vueEtapeIG) {
                    vPdc.setOpacity(0);
                }

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
        }
        mouseEvent.consume();
    }
}





