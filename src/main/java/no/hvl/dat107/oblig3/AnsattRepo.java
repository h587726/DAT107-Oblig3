package no.hvl.dat107.oblig3;

import java.util.List;

public interface AnsattRepo {

    Ansatt hentAnsattMedId(int id);

    List<Ansatt> hentAnsatte();

    Ansatt hentAnsattMedBrukernavn(String brukernavn);

    void oppdaterAnsattStilling(int id, String stilling);

    void oppdaterAnsattLonn(int id, int lonn);

    void leggTilAnsatt(Ansatt ansatt);
}
