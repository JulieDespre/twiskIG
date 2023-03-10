package twisk.mondeIG;

public enum Composant {
    ACTIVITE("activite"), GUICHET("guichet"), ACTIVITERESTREINTE("activiteRestreinte");
    private String composant;
    private Composant(String composant) {
        this.composant=composant;
    }
    public String getComposant(){
        return composant;
    }
    public String toString() {
        return composant;
    }

}