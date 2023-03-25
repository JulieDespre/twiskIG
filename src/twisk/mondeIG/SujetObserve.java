package twisk.mondeIG;

import twisk.mondeGraphique.Observateur;
import java.util.ArrayList;
import java.util.Collection;

public class SujetObserve {
        private final Collection<Observateur> observateurs;

        public SujetObserve() {
            observateurs = new ArrayList<>(15);
        }

        /**
         * Abonnement d'un observateur aux évènements générés par cette classe.
         *
         * @param observateur L'observateur qui s'abonne.
         */
        public void ajouterObservateur(Observateur observateur) {
            observateurs.add(observateur);
        }

        /**
         *notifie tous les observateurs qu'un évènement vient de se produire.
         */
        public void notifierObservateurs() {
        for (Observateur observateur : observateurs) {
            observateur.reagir();
            }
        }
}


