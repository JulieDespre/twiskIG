package twisk.mondeIG;

import twisk.Vue.Observateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {
    private HashMap <Integer, EtapeIG> etapes;
    private ArrayList<Observateur> observateurs;

    public MondeIG(){
        this.etapes = new HashMap<Integer, EtapeIG>();
        EtapeIG test1 = new ActiviteIG("test1",300, 150);
        this.ajouterEtape(test1);
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return etapes.values().iterator();
    }

    public void ajouterEtape(EtapeIG... NewEtapes){
        for (EtapeIG e: NewEtapes) {
            this.etapes.put(e.getIdentifiant(),e);
    }
    }

    public void Action(ActiviteIG actIG){
        //deplacer l'activité au clic drag and drop



        this.notifierObservateurs() ;
    }
    public void nouveau() {
    // Réinitialiser le monde
        for (EtapeIG e: etapes.values()) {
            etapes.remove(e.getIdentifiant());
        }
        this.notifierObservateurs() ;
    }


}
