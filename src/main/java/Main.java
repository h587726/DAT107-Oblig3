import no.hvl.dat107.oblig3.*;

import java.sql.Date;
import java.util.List;

public class Main {

    private static AnsattRepo ansattRepo = new AnsattDAO();
    private static AvdelingRepo avdelingRepo = new AvdelingDAO();
    public static void main(String[] args) {

        //ITERATIVE 2
        /*
        //Søk etter ansatt med Id
        System.out.println("Søk etter ansatt med Id:");
        System.out.println(ansattRepo.hentAnsattMedId(2));
        System.out.println("....");

        //Søke etter ansatt med brukernavn
        System.out.println("Søke etter ansatte med brukernavn (ReBe)");
        System.out.println(ansattRepo.hentAnsattMedBrukernavn("ReBe"));
        System.out.println("....");

        //Hente ut alle ansatte
        System.out.println("Henter ut alle ansatte");
        skrivUt();
        System.out.println("....");

        //Oppdater stilling
        System.out.println("Oppdatering av stilling eller lønn (id 1)");
        System.out.println("Stilling:");
        System.out.println("Før: " + ansattRepo.hentAnsattMedId(1));
        ansattRepo.oppdaterAnsattStilling(1, "Backend Developer");
        System.out.println("Etter: " + ansattRepo.hentAnsattMedId(1));
        System.out.println("Lønn:");
        System.out.println("Før: " + ansattRepo.hentAnsattMedId(1));
        ansattRepo.oppdaterAnsattLonn(1, 700000);
        System.out.println("Etter: " + ansattRepo.hentAnsattMedId(1));
        System.out.println("....");

        //Legge til ny ansatt
        System.out.println("Legge til ny ansatt");
        ansattRepo.leggTilAnsatt(new Ansatt("SeDa", "Sebastian", "Danielsen", Date.valueOf("2023-03-29"), "Customer Support Specialist", 450000, 3));
        System.out.println("Ny ansatt lagt til: " + ansattRepo.hentAnsattMedBrukernavn("SeDa"));
        System.out.println("....");
        */

        //ITERATIVE 3

        //Finn avdeling med Id
        System.out.println("Finn avdeling med id");
        System.out.println(avdelingRepo.finnAvdelingMedId(1));
        System.out.println("....");
    }
    private static void skrivUt() {

        List<Ansatt> ansatte = ansattRepo.hentAnsatte();

        ansatte.forEach(System.out::println);
    }
}