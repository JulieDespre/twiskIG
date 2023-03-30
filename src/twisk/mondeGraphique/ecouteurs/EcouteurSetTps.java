package twisk.mondeGraphique.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.exceptions.ExceptionEtape;
import twisk.exceptions.ExceptionTemps;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurSetTps implements EventHandler<ActionEvent> {
    private MondeIG monde;

    public EcouteurSetTps(MondeIG monde) {
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
        TextInputDialog setTpsDial = new TextInputDialog("Nouveau temps de l'activité");

        setTpsDial.setTitle("Changer le temps de l'activité");
        setTpsDial.setHeaderText("Nouveau temps de l'activité :");
        setTpsDial.setContentText("Temps :");

        Optional<String> result = setTpsDial.showAndWait();

        result.ifPresent(temps -> {
            try {
                monde.getEtapesClicked(0).setTpsEtapeClicked(Integer.parseInt(temps));
            } catch (ExceptionTemps e) {
                e.getAlert();
            }
        });
        for (int i = 0; i < monde.getEtapesClicked().size(); i++) {
            monde.getEtapesClicked().remove(i);
        }
        monde.notifierObservateurs();
    }

}

