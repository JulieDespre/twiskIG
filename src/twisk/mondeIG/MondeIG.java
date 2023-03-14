package twisk.mondeIG;

import twisk.Vue.Observateur;
import twisk.outils.FabriqueIdentifiant;

import java.util.HashMap;
import java.util.Iterator;


public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {
    private final HashMap <Integer, EtapeIG> etapes;
    private double pdcCentPosX;
    private double pdcCentPosY;
    private int cpt;


    public MondeIG(){
        this.etapes = new HashMap<Integer, EtapeIG>();
    }


    @Override
    public Iterator<EtapeIG> iterator() {
        return etapes.values().iterator();
    }

    public void ajouterEtape(EtapeIG... NewEtapes){
        for (EtapeIG e: NewEtapes) {
            e.ajouterPDC();
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


    public void destructeurDeMonde() {
    // Réinitialiser le monde
            etapes.clear();
            FabriqueIdentifiant identifiant = FabriqueIdentifiant.getInstance();
            identifiant.reset();
            this.notifierObservateurs();
    }

    public double getCpt(){
        return cpt;
    }

    public void setCpt(int newCpt){
       cpt = newCpt;
    }
    public double getPdcCentPosX(){
        return pdcCentPosX;
    }
    public void setPdcCentPosX(double newPosX){
        pdcCentPosX = newPosX;
    }

    public double getPdcCentPosY(){
        return pdcCentPosY;
    }

    public void setPdcCentPosY(double newPosY){
        pdcCentPosY = newPosY;
    }
}
