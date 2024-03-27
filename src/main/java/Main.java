import no.hvl.dat107.oblig3.Ansatt;
import no.hvl.dat107.oblig3.AnsattJPA;
import no.hvl.dat107.oblig3.AnsattRepo;

import java.util.List;

public class Main {

    private static AnsattRepo ansattRepo = new AnsattJPA();
    public static void main(String[] args) {

        skrivUt();
    }
    private static void skrivUt() {

        List<Ansatt> ansatte = ansattRepo.hentAnsatte();

        ansatte.forEach(System.out::println);
    }
}