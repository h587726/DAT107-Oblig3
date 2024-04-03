import no.hvl.dat107.oblig3.dao.AnsattDAO;
import no.hvl.dat107.oblig3.dao.AvdelingDAO;
import no.hvl.dat107.oblig3.dao.ProsjektDAO;
import no.hvl.dat107.oblig3.dao.ProsjektdeltakelseDAO;
import no.hvl.dat107.oblig3.model.Prosjekt;
import no.hvl.dat107.oblig3.model.Prosjektdeltakelse;
import no.hvl.dat107.oblig3.service.AnsattRepo;
import no.hvl.dat107.oblig3.service.AvdelingRepo;
import no.hvl.dat107.oblig3.service.ProsjektRepo;
import no.hvl.dat107.oblig3.service.ProsjektdeltakelseRepo;

import java.util.List;

public class Main {

    private static AnsattRepo ansattRepo = new AnsattDAO();
    private static AvdelingRepo avdelingRepo = new AvdelingDAO();

    private static ProsjektRepo prosjektRepo = new ProsjektDAO();

    private static ProsjektdeltakelseRepo prosjektdeltakelseRepo = new ProsjektdeltakelseDAO();

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

        /*
        //ITERATIVE 3

        //Finn avdeling med Id
        System.out.println("Finn avdeling med id");
        System.out.println(avdelingRepo.finnAvdelingMedId(1));
        System.out.println("....");
         */

        //ITERATIVE 4
        /*
        //Finn avdeling med Id
        System.out.println("Finn avdeling med id");
        System.out.println(avdelingRepo.finnAvdelingMedId(1));
        System.out.println("....");

        //List ut ansatte på en avdeling, inkl. hvem som er sjef
        System.out.println("List ansatte på avdeling og sjefen");
        System.out.println(avdelingRepo.hentAnsattePaaAvdeling(1));
        System.out.println("....");

        //Oppdater ansatt sin avdeling
        System.out.println("Oppdatere ansatt sin avdeling");
        System.out.println(ansattRepo.hentAnsattMedId(1));
        System.out.println("Oppdaterer til Customer Support...");
        avdelingRepo.oppdaterAvdelingForAnsatt(1, 3);
        System.out.println(ansattRepo.hentAnsattMedId(1));
        System.out.println("....");

        //Legg til ny avdeling
        System.out.println("Legg til ny avdeling");
        skrivUt();
        avdelingRepo.leggTilAvdeling("Backoffice", 7);
        skrivUt();
        System.out.println("....");
         */

        //ITERATIVE 5

        //Legg til nytt prosjekt
        /*
        System.out.println("Legg til nytt prosjekt");
        skrivUt();
        prosjektRepo.leggTilProsjekt("Adding 2FA", "Adding 2FA to the website for security reasons");
        skrivUt();
        System.out.println("....");

        //Registrere prosjektdeltakelse (ansatt med rolle i prosjekt)
        System.out.println("Registrere prosjektdeltakelse");
        skrivUt();
        Prosjektdeltakelse prosjektdeltakelse = new Prosjektdeltakelse("User functionality", prosjektRepo.finnProsjektMedId(1), ansattRepo.hentAnsattMedId(7));
        prosjektdeltakelseRepo.registrerProsjektdeltakelse(prosjektdeltakelse);
        System.out.println("....");
        skrivUt();
        System.out.println("....");

        //Legg til timer for prosjektdeltakelse
        System.out.println("Legg til timer");
        prosjektdeltakelseRepo.leggTilTimer(11, 12);
        skrivUt();
        System.out.println("....");

        //Utskrift av info, om prosjekt, deltaker, og arbeidstimer totalt
        System.out.println("Utskrift av info om prosjekt");
        */
    }
    private static void skrivUt() {

        List<Prosjektdeltakelse> prosjekterdeltakelser = prosjektdeltakelseRepo.hentAlleProsjektdeltakelser();

        prosjekterdeltakelser.forEach(System.out::println);
    }
}