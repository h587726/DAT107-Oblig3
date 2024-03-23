DROP SCHEMA IF EXISTS firmaDB CASCADE;
CREATE SCHEMA firmaDB;
SET
search_path TO firmaDB;

CREATE TABLE ansatt(

    ansattId SERIAL PRIMARY KEY,
    brukernavn VARCHAR(4) UNIQUE,
    fornavn VARCHAR(32),
    etternavn VARCHAR(32),
    ansettelse DATE,
    stilling VARCHAR(32),
    manedslonn INTEGER,
    avdeling INTEGER
);

CREATE TABLE avdeling(

    avdelingId SERIAL PRIMARY KEY,
    avdelingsNavn VARCHAR(32),
    avdelingsSjef INTEGER,

    CONSTRAINT avdelingsSjef_FK FOREIGN KEY (avdelingsSjef) REFERENCES ansatt(ansattId)
);

CREATE TABLE prosjekt(

    prosjektId SERIAL PRIMARY KEY,
    prosjektNavn VARCHAR(32),
    beskrivelse VARCHAR(300)
);

CREATE TABLE prosjektDeltakelse(

    prosjektDeltakelseId SERIAL PRIMARY KEY,
    rolle VARCHAR(32),
    arbeidsTimer INTEGER,
    prosjektId INTEGER,
    ansattId INTEGER,

    CONSTRAINT prosjektId_FK FOREIGN KEY (prosjektId) REFERENCES prosjekt(prosjektId),
    CONSTRAINT ansattId_FK FOREIGN KEY (ansattId) REFERENCES ansatt(ansattId)
);