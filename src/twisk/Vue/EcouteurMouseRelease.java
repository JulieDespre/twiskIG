package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.MondeIG;

public class EcouteurMouseRelease implements EventHandler<MouseEvent> {
        private MondeIG monde;
        private VueEtapeIG vueEtapeIG;

        public EcouteurMouseRelease (MondeIG monde, VueEtapeIG vueEtapeIG) {

            this.monde = monde;
            this.vueEtapeIG = vueEtapeIG;
        }

    @Override
    public void handle(MouseEvent mouseEvent) {
            vueEtapeIG.retourCouleur();
            mouseEvent.consume();
            monde.notifierObservateurs();
    }
}
