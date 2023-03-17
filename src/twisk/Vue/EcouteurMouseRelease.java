package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurMouseRelease implements EventHandler<MouseEvent> {
    private final MondeIG monde;
    private final VueEtapeIG vueEtapeIG;
    private EtapeIG etape;

    public EcouteurMouseRelease (MondeIG monde, VueEtapeIG vueEtapeIG, EtapeIG etape) {

        this.monde = monde;
        this.vueEtapeIG = vueEtapeIG;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (vueEtapeIG.getWasDragged()){
        vueEtapeIG.retourCouleur();
        monde.notifierObservateurs();}
        else {
            System.out.println("Ulysse");
            //monde.ajouterEtapesClicked(etape);
            vueEtapeIG.setStyle("-fx-border-color: darkgrey; -fx-border-width: 10px; -fx-opacity: 0.2");
            vueEtapeIG.clicCouleur();
            //monde.notifierObservateurs();
        }
        vueEtapeIG.setWasDragged(false);
        mouseEvent.consume();
    }
}


