package twisk.mondeIG;

public class ActiviteIG extends EtapeIG {
    public ActiviteIG(String nom, int temps, int delais) {
        super(nom, temps, delais);
        this.setComposant(Composant.ACTIVITE);
        this.setTailles();
    }

    public ActiviteIG(int temps, int delais) {
        super(temps, delais);
        this.setComposant(Composant.ACTIVITE);
        this.setTailles();
    }

}
