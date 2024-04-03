package no.hvl.dat107.oblig3.service;

import no.hvl.dat107.oblig3.model.Prosjekt;

import java.util.List;

public interface ProsjektRepo {

    void leggTilProsjekt(String navn, String beskrivelse);

    Prosjekt finnProsjektMedId(int id);

    List<Prosjekt> hentAlleProsjekter();
}
