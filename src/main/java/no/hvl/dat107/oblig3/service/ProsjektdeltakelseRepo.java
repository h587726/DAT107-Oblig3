package no.hvl.dat107.oblig3.service;

import no.hvl.dat107.oblig3.model.Prosjektdeltakelse;

import java.util.List;

public interface ProsjektdeltakelseRepo {

    void registrerProsjektdeltakelse(Prosjektdeltakelse prosjektdeltakelse);

    void leggTilTimer(int id, int timer);

    List<Prosjektdeltakelse> hentAlleProsjektdeltakelser();
}
