package no.hvl.dat107.oblig3;

import java.util.List;

public interface AnsattRepo {

    Ansatt hentAnsattMedId(int id);

    List<Ansatt> hentAnsatte();
}
