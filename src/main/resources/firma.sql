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

ALTER TABLE ansatt add FOREIGN KEY (avdeling) references avdeling(avdelingid);

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

INSERT INTO avdeling(avdelingId , avdelingsNavn)
VALUES(DEFAULT, 'IT'),
      (DEFAULT, 'Legal'),
      (DEFAULT, 'Customer Support');

INSERT INTO ansatt(ansattId, brukernavn, fornavn, etternavn, ansettelse, stilling, manedslonn, avdeling)
VALUES(DEFAULT, 'OlNo', 'Ola', 'Nordmann', '2022-05-01', 'Software Developer', 650000, 1),
      (DEFAULT, 'ArPe', 'Arne', 'Persen', '2015-01-01', 'Lead Developer', 1000000, 1),
      (DEFAULT, 'AnKa', 'Anne', 'Karlsen', '2015-01-01', 'Lawyer', 850000, 2),
      (DEFAULT, 'JuFa', 'Juni', 'Falken', '2017-03-10', 'Software Developer', 750000, 1),
      (DEFAULT, 'RoLa', 'Roger', 'Larsen', '2018-03-05', 'Lead Lawyer', 1000000 , 2),
      (DEFAULT, 'ReBe', 'Reidun', 'Berntsen', '2015-01-01', 'Team Lead', 520000, 3),
      (DEFAULT, 'HeDa', 'Henrik', 'Dale', '2022-05-01', 'Customer Support Specialist', 450000, 3);

INSERT INTO prosjekt(prosjektId ,prosjektNavn , beskrivelse)
VALUES(DEFAULT, 'Mobile Application', 'Making a mobile application for our firm'),
      (DEFAULT, 'Company Regulation', 'Adjusting company regulations'),
      (DEFAULT, 'Making articles', 'Making articles for customer to read to'),
      (DEFAULT, 'Website extension', 'Extending functionality on the website');

INSERT INTO prosjektdeltakelse(prosjektDeltakelseId ,rolle, arbeidsTimer, prosjektId, ansattId)
VALUES(DEFAULT, 'Lead Developer', 250, 1, 2),
      (DEFAULT, 'Developer', 300, 1, 4),
      (DEFAULT, 'Legal', 120, 1, 3),
      (DEFAULT, 'Lead Legal', 250, 2, 5),
      (DEFAULT, 'Legal', 230, 2, 3),
      (DEFAULT, 'Writer', 75, 3, 7),
      (DEFAULT, 'Legal', 50,3, 3),
      (DEFAULT, 'Developer', 350 ,4, 1),
      (DEFAULT, 'Developer', 300 ,4, 4),
      (DEFAULT, 'Lead Developer', 100, 4, 2);

UPDATE avdeling
set avdelingssjef = 2
where avdelingid = 1;

UPDATE avdeling
set avdelingssjef = 5
where avdelingid = 2;

UPDATE avdeling
set avdelingssjef = 7
where avdelingid = 3;