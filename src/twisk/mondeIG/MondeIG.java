package twisk.mondeIG;

import twisk.Vue.Observateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {
    private HashMap <Integer, EtapeIG> etapes;
    private ArrayList<Observateur> observateurs = new ArrayList<>(15);

    public MondeIG(){
        this.etapes = new HashMap<Integer, EtapeIG>();
        EtapeIG test1 = new ActiviteIG("test1",300, 150);
        test1.setNom("Activité "+test1.getIdentifiant());
        System.out.println(test1.getNom());
        this.ajouterEtape(test1);
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return etapes.values().iterator();
    }

    public void ajouterEtape(EtapeIG... NewEtapes){
        for (EtapeIG e: NewEtapes) {
            this.etapes.put(e.getIdentifiant(),e);
            System.out.println(e.toString());
            this.notifierObservateurs();
        }
    }

    public HashMap<Integer, EtapeIG> getEtapes(){
        return etapes;
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
