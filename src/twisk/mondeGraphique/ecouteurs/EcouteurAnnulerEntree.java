package twisk.mondeGraphique.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurAnnulerEntree  implements EventHandler<ActionEvent> {
    private MondeIG monde;
    public EcouteurAnnulerEntree(MondeIG monde) {
        this.monde = monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (monde.getEtapesClicked().size() != 0) {
            for (EtapeIG etape : monde.getEtapesClicked()) {
                if(etape.estEntree()) {
                    monde.aCommeEntree().remove(etape);
                    etape.setEstEntree(false);
                }
            }
        }
        monde.notifierObservateurs();
    }
}
