package no.hvl.dat107.oblig3.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "firmadb", name = "prosjektdeltakelse")
public class Prosjektdeltakelse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektdeltakelseid;

    @Column
    private String rolle;

    @Column
    private int arbeidstimer;

    @ManyToOne
    @JoinColumn(name = "prosjektid", referencedColumnName = "prosjektid")
    private Prosjekt prosjekt;

    @ManyToOne
    @JoinColumn(name = "ansattid", referencedColumnName = "ansattid")
    private Ansatt ansatt;

    public Prosjektdeltakelse(String rolle, Prosjekt prosjekt, Ansatt ansatt){

        this.rolle = rolle;
        //this.arbeidstimer = 0;
        this.prosjekt = prosjekt;
        this.ansatt = ansatt;
    }

    public Prosjektdeltakelse(){}

    public int getProsjektdeltakelseid(){

        return prosjektdeltakelseid;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public int getArbeidstimer() {
        return arbeidstimer;
    }

    public void setArbeidstimer(int arbeidstimer) {
        this.arbeidstimer = arbeidstimer;
    }

    public Prosjekt getProsjekt() {
        return prosjekt;
    }

    public Ansatt getAnsatt() {
        return ansatt;
    }

    @Override
    public String toString() {
        return "Prosjektdeltakelse{" +
                "prosjektdeltakelseid=" + prosjektdeltakelseid +
                ", rolle='" + rolle + '\'' +
                ", arbeidstimer='" + arbeidstimer + '\'' +
                ", prosjekt=" + prosjekt +
                ", ansatt=" + ansatt +
                '}';
    }
}
