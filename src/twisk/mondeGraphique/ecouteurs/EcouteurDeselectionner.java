package twisk.mondeGraphique.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurDeselectionner  implements EventHandler<ActionEvent> {
    private MondeIG monde;

    public EcouteurDeselectionner(MondeIG monde){
        this.monde=monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (monde.getEtapesClicked() != null){
            monde.getEtapesClicked().clear();
        }
        for (int i=0;i<monde.getLignes().size();i++) {
            if (monde.getLignes().get(i).getSelect()) {
                monde.getLignes().get(i).setSelect(false);
            }
        }
            for (int i=0;i<monde.getCourbes().size();i++) {
                if (monde.getCourbes().get(i).getSelect()) {
                    monde.getCourbes().get(i).setSelect(false);
                }
            }
        monde.notifierObservateurs();
    }
}
