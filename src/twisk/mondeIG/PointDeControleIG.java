package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;

public class PointDeControleIG {
    private double poseCentX;
    private double poseCentY;
    private final int identifiant;
    private final EtapeIG etape;

    private Boolean hasArc = false;
    private int cpt;

    public PointDeControleIG(Double posX, Double posY, EtapeIG etape){
        this.poseCentX = posX;
        this.poseCentY = posY;
        FabriqueIdentifiant maFabrique=FabriqueIdentifiant.getInstance();
        this.identifiant= maFabrique.getNumeroPDC();
        this.etape = etape;
        cpt=0;

    }
    public double getPosX(){
        return poseCentX;
    }
    public double getPosY(){
        return poseCentY;
    }
    public EtapeIG getEtapePDC(){
        return etape;
    }

    public int getIdentifiant(){
        return identifiant;
    }

    public void setPdc(double newPosX, double newPosY){
        this.poseCentX = newPosX;
        this.poseCentY = newPosY;
    }

    public int getCpt(){
        return cpt;
    }

    public void setCpt(int i){
        cpt = i;
    }

    public void increCpt(){
        cpt = cpt + 1;
    }

    public boolean getHasArc(){
        return hasArc;
    }

    public void setHasArc(){
        hasArc = true;
    }

}
