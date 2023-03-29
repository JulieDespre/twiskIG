package twisk.mondeGraphique.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurEntree implements EventHandler<ActionEvent> {
        private MondeIG monde;

    public EcouteurEntree(MondeIG monde) {
            this.monde = monde;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if (monde.getEtapesClicked().size() == 1) {
            for (EtapeIG etape : monde.getEtapesClicked()) {
                monde.ajouterEntree(etape);
            }
            System.out.println("entrée du mon " +monde.aCommeEntree());
        }
        for(int i=0;i<monde.getEtapesClicked().size();i++) {
            monde.getEtapesClicked().remove(i);
        }
        monde.notifierObservateurs();
    }
}
