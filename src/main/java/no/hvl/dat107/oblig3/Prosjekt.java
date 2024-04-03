package no.hvl.dat107.oblig3;

import jakarta.persistence.*;

@Entity
@Table(schema = "firmadb", name = "prosjekt")
public class Prosjekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektid;

    @Column
    private String prosjektnavn;

    @Column
    private String beskrivelse;

    public int getProsjektid(){

        return prosjektid;
    }

    public String getProsjektnavn() {
        return prosjektnavn;
    }

    public void setProsjektnavn(String prosjektnavn) {
        this.prosjektnavn = prosjektnavn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    @Override
    public String toString() {
        return "Prosjekt{" +
                "prosjektid=" + prosjektid +
                ", prosjektnavn='" + prosjektnavn + '\'' +
                ", beskrivelse='" + beskrivelse + '\'' +
                '}';
    }
}
