package twisk.mondeGraphique.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeGraphique.vues.VueEtapeIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurMouseRelease implements EventHandler<MouseEvent> {
    private final MondeIG monde;
    private final VueEtapeIG vueEtapeIG;
    private EtapeIG etape;

    public EcouteurMouseRelease (MondeIG monde, VueEtapeIG vueEtapeIG, EtapeIG etape) {
        this.etape = etape;
        this.monde = monde;
        this.vueEtapeIG = vueEtapeIG;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (vueEtapeIG.getWasDragged()){
        vueEtapeIG.retourCouleur();
            }
        else {
            if (!monde.hasBeenClicked(etape)) monde.ajouterEtapesClicked(etape);
            else monde.enleverEtapesClicked(etape);
            monde.increCptAct();
        }
        vueEtapeIG.setWasDragged(false);
        monde.notifierObservateurs();
        mouseEvent.consume();
    }
}


