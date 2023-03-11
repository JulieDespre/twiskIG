package twisk.mondeIG;


import twisk.outils.FabriqueIdentifiant;

import java.awt.*;

public class PointDeControleIG {
    private double poseCentX;
    private double poseCentY;
    private int identifiant;
    private EtapeIG etape;

    public PointDeControleIG(Double posX, Double posY, EtapeIG etape){
        this.poseCentX = posX;
        this.poseCentY = posY;
        FabriqueIdentifiant maFabrique=FabriqueIdentifiant.getInstance();
        this.identifiant= maFabrique.getNumeroPDC();
        this.etape = etape;

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

}
