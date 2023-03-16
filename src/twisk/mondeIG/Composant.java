package twisk.mondeIG;

public enum Composant {
    ACTIVITE("activite"), GUICHET("guichet"), ACTIVITERESTREINTE("activiteRestreinte");
    private final String composant;
    Composant(String composant) {
        this.composant=composant;
    }
    public String getComposant(){
        return composant;
    }
    public String toString() {
        return composant;
    }

}