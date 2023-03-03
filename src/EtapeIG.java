public abstract class EtapeIG {
    private String nom;
    private String identifiant;
    private int posX;
    private int posY;
    private int largeur;
    private int hauteur;

    public EtapeIG(String nom, int largeur, int hauteur){
            this.nom= nom;
            this.largeur= largeur;
            this.hauteur= hauteur;
    }

    int getActivitesPosX(){
        return this.posX;
    }

    int getActivitesPosY(){
        return this.posY;
    }
}
