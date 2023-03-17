package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.TailleComposants;

import java.sql.SQLOutput;

public class EcouteurEtapeIGClick implements EventHandler<MouseEvent> {
    private VueEtapeIG vueEtapeIG;
    private EtapeIG etapeIG;
    private MondeIG monde;

    public EcouteurEtapeIGClick(MondeIG monde, VueEtapeIG vueEtapeIG, EtapeIG etapeIG) {
        this.monde = monde;
        this.vueEtapeIG = vueEtapeIG;
        this.etapeIG = etapeIG;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        monde.ajouterEtapesClicked(etapeIG);
        vueEtapeIG.setStyle("-fx-border-color: darkgrey; -fx-border-width: 10px;");
        System.out.println(mouseEvent.getEventType());
        System.out.println(monde.getEtapesClicked().size());
        System.out.println("pikachu");
        vueEtapeIG.retourCouleur();
        monde.notifierObservateurs();
        mouseEvent.consume();
        }
}

