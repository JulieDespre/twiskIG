package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
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
        //if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
            vueEtapeIG.retourCouleur();
            System.out.println("hello");
            mouseEvent.consume();
        //}

    }
}
