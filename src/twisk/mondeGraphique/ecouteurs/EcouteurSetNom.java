package twisk.mondeGraphique.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurSetNom implements EventHandler<ActionEvent> {
        private MondeIG monde;

        public EcouteurSetNom(MondeIG monde) {
                this.monde = monde;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
                if (monde.getEtapesClicked().size() == 1) {
                        for(int i=0;i<monde.getEtapesClicked().size();i++) {
                                setNomDial(monde.getEtapesClicked(i));
                                i--;
                        }

                }

        }

        public void setNomDial(EtapeIG etape) {
                TextInputDialog setNomDial = new TextInputDialog("Nouveau nom de l'activité");

                setNomDial.setTitle("Renomer l'activité");
                setNomDial.setHeaderText("Nouveau nom de l'activité :");
                setNomDial.setContentText("Nom :");

                Optional<String> result = setNomDial.showAndWait();
                result.ifPresent(nom -> {
                        monde.getEtapesClicked(0).setNomEtapeClicked(nom);
                });
                for(int i=0;i<monde.getEtapesClicked().size();i++) {
                        monde.getEtapesClicked().remove(i);
                }
                monde.notifierObservateurs();
        }

}

