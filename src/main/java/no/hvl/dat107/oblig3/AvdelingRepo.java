package no.hvl.dat107.oblig3;

import java.util.List;

public interface AvdelingRepo {

    Avdeling finnAvdelingMedId(int id);

    List<String> hentAnsattePaaAvdeling(int avdelingsid);

    void oppdaterAvdelingForAnsatt(int id, int avdelingid);

    void leggTilAvdeling(String avdelingsnavn, int sjef);

    List<Avdeling> hentAlleAvdelinger();
}
