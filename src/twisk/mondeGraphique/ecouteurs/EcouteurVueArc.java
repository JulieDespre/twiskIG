package twisk.mondeGraphique.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeGraphique.vues.VueArcIG;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;

public class EcouteurVueArc implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private VueArcIG vueArc;
    private ArcIG arc;
    public EcouteurVueArc(MondeIG monde, VueArcIG vueArcIG,ArcIG arc) {
        this.monde=monde;
        this.vueArc=vueArcIG;
        this.arc=arc;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
            arc.setSelec();
        }
    }
}
