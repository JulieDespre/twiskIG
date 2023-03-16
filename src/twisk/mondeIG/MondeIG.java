package twisk.mondeIG;

import twisk.Vue.Observateur;
import twisk.outils.FabriqueIdentifiant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {
    private final HashMap <Integer, EtapeIG> etapes;
    private double pdcCentPosX;
    private double pdcCentPosY;
    private int cpt;
    private PointDeControleIG pdcClick=null;
    private final ArrayList<LigneDroiteIG> lignes =new ArrayList<LigneDroiteIG>();
    private final ArrayList<CourbeIG> courbes =new ArrayList<CourbeIG>();
    private Boolean creationLigne = false;
    private Boolean creationCour = false;


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
            lignes.clear();
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
    public PointDeControleIG getPdcClick(){
        return pdcClick;
    }

    public void setPdcClick(PointDeControleIG newPdcClick){
        pdcClick = newPdcClick;
    }

    public void ajouterArc(PointDeControleIG pdcStart,PointDeControleIG pdcEnd) {
        LigneDroiteIG newArc = new LigneDroiteIG(pdcStart,pdcEnd);
        lignes.add(newArc);
        this.notifierObservateurs();
    }

    public ArrayList<LigneDroiteIG> getLignes() {
        return lignes;
    }

    public boolean getcreationLigne(){
        return creationLigne;
    }
    public void setCreationLigne(boolean newcreaLig){
        this.creationLigne = newcreaLig;
    }

    public boolean getcreationCourbe(){
        return creationCour;
    }
    public void setCreationCourbe(boolean newcreaCour){
        this.creationCour = newcreaCour;
    }
}
