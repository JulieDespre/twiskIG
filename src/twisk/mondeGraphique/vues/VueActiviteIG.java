package twisk.mondeGraphique.vues;


import twisk.mondeGraphique.Observateur;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueActiviteIG extends VueEtapeIG implements Observateur {

    public VueActiviteIG(MondeIG monde, EtapeIG etapeIG) {
        super(monde, etapeIG);
    }

    @Override
    public void reagir() {
    }
}
