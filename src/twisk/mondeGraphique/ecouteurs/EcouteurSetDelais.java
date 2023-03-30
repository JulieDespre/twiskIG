package twisk.mondeGraphique.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.exceptions.ExceptionDelais;
import twisk.exceptions.ExceptionTemps;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurSetDelais implements EventHandler<ActionEvent> {
    private MondeIG monde;

    public EcouteurSetDelais(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (monde.getEtapesClicked().size() == 1) {
            for(int i=0;i<monde.getEtapesClicked().size();i++) {
                setDelDial(monde.getEtapesClicked(i));
                i--;
            }

        }

    }

    public void setDelDial(EtapeIG etape) {
        TextInputDialog setDelDial = new TextInputDialog("Nouveau Delais de l'activité");

        setDelDial.setTitle("Changer le Delais de l'activité");
        setDelDial.setHeaderText("Nouveau Delais de l'activité :");
        setDelDial.setContentText("Delais :");

        Optional<String> result = setDelDial.showAndWait();

        result.ifPresent(delais -> {
            try {
                monde.getEtapesClicked(0).setDelEtapeClicked(Integer.parseInt(delais));
            } catch (ExceptionDelais e) {
                e.getAlert();
            }
        });
        for (int i = 0; i < monde.getEtapesClicked().size(); i++) {
            monde.getEtapesClicked().remove(i);
        }
        monde.notifierObservateurs();
    }

}