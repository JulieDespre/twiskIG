package twisk.Vue;

import twisk.mondeIG.MondeIG;

public class VueActiviteIG implements Observateur{
    private MondeIG monde;

    public VueActiviteIG(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void reagir() {

    }
}
