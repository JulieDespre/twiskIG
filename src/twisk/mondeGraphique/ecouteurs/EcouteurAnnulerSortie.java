package twisk.mondeGraphique.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurAnnulerSortie implements EventHandler<ActionEvent> {
    private MondeIG monde;
    public EcouteurAnnulerSortie(MondeIG monde) {
        this.monde = monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (monde.getEtapesClicked().size() != 0) {
            for (EtapeIG etape : monde.getEtapesClicked()) {
                if(etape.estSortie()) {
                    monde.aCommeSortie().remove(etape);
                    etape.setEstSortie(false);
                    System.out.println(etape.estSortie());
                }
            }
        }
        monde.getEtapesClicked().remove(0);
        monde.notifierObservateurs();
    }
}