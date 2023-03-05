package twisk.mondeIG;

import java.util.HashMap;
import java.util.Iterator;


public class MondeIG implements Iterable<EtapeIG> {
    private HashMap <Integer, EtapeIG> etapes;

    public MondeIG(){
        HashMap <Integer, EtapeIG> etapes = new HashMap<Integer, EtapeIG>();
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

}
