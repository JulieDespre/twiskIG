package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.TailleComposants;

public class EcouteurVueActiviteIG implements  EventHandler<MouseEvent> {
    private MondeIG monde;
    private VueEtapeIG vueEtapeIG;
    private EtapeIG etapeIG;

    public EcouteurVueActiviteIG(MondeIG monde, VueEtapeIG vueEtapeIG, EtapeIG etapeIG) {
        this.monde = monde;
        this.vueEtapeIG = vueEtapeIG;
        this.etapeIG = etapeIG;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

            if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                this.vueEtapeIG.moveCouleur();
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
                if ((newYPos >= 0) && (newYPos <= 920 - taille.getHauteur(etapeIG))) {
                    this.vueEtapeIG.setPosY(newYPos);
                    this.etapeIG.setPosY(newYPos);
                }
            }

        }

    }

