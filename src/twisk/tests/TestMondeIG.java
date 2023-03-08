package twisk.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class TestMondeIG {
    @Test
    public void TestConstructeurMonde() {
        MondeIG m1 = new MondeIG();
        EtapeIG e1 =  new ActiviteIG("test1", 10, 10, 6, 2);
        m1.ajouterEtape(e1);
        int cpt = 0;
        for (EtapeIG e : m1) {
            cpt++;
        }
        Assertions.assertEquals(1, cpt);
    }


}
