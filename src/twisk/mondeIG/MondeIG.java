package twisk.mondeIG;

import twisk.Vue.Observateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {
    private final HashMap <Integer, EtapeIG> etapes;
    private final ArrayList<Observateur> observateurs = new ArrayList<>(15);

    public MondeIG(){
        this.etapes = new HashMap<Integer, EtapeIG>();
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return etapes.values().iterator();
    }

    public void ajouterEtape(EtapeIG... NewEtapes){
        for (EtapeIG e: NewEtapes) {
            this.etapes.put(e.getIdentifiant(),e);
            this.notifierObservateurs();
        }
    }

    public HashMap<Integer, EtapeIG> getEtapes(){
        return etapes;
        }

    public EtapeIG getEtape(int identifiant){
        return etapes.get(identifiant);
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
