package twisk.mondeGraphique.ecouteurs;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import twisk.exceptions.TwiskException;
import twisk.mondeGraphique.vues.VuePointDeControleIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurVuePdc implements EventHandler<MouseEvent> {
    private final MondeIG monde;
    private final VuePointDeControleIG vPdc;
    private final PointDeControleIG pdc;


    public EcouteurVuePdc(MondeIG monde, VuePointDeControleIG vPdc, PointDeControleIG pdc) {

        this.monde = monde;
        this.vPdc = vPdc;
        this.pdc = pdc;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
       if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
            vPdc.setFill(Color.gray(0.25));
            monde.setPdcCentPosX(vPdc.getCenterX());
            monde.setPdcCentPosY(vPdc.getCenterY());
            pdc.increCpt();
            if (pdc.getCpt() % 2 == 0) {
                vPdc.setFill(Color.web("C0C0C0"));
            } else {
                vPdc.setFill(Color.SLATEGRAY);
            }
            if (monde.getPdcClick() == null){
                monde.setPdcClick(this.pdc);
                //stocker pdc dans arraylist pour utiliser aprés
                monde.ajouterPdcClicked(this.pdc);
            } else if (monde.getPdcClick() != this.pdc){

                if (monde.getTaillePointCliked()>1){
                    try {
                        monde.ajouterCourbe(monde.getPdcClick(),monde.getPointCliked(0),monde.getPointCliked(1), this.pdc);
                    } catch (TwiskException e) {
                        e.getAlert();
                        vPdc.setFill(Color.web("C0C0C0"));
                    }
                    monde.clearPointClicked();
                }
                else {
                    try {
                        monde.ajouterLigne(monde.getPdcClick(), this.pdc);
                    } catch (TwiskException e) {
                        e.getAlert();
                        vPdc.setFill(Color.web("C0C0C0"));
                    }
                }
                monde.setPdcClick(null);
            }
        }
        mouseEvent.consume();
       monde.notifierObservateurs();
    }

}


