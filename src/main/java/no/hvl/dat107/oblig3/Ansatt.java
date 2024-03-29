package no.hvl.dat107.oblig3;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(schema = "firmadb", name = "ansatt")
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ansattid;

    @Column
    //Unqiue
    private String brukernavn;

    @Column
    private String fornavn;

    @Column
    private String etternavn;

    @Column
    private Date ansettelse;

    @Column
    private String stilling;

    @Column
    private Integer manedslonn;

    @Column
    private Integer avdeling;

    public Ansatt(String brukernavn, String fornavn, String etternavn,
                  Date ansettelse, String stilling, int manedslonn, int avdeling){

        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.ansettelse = ansettelse;
        this.stilling = stilling;
        this.manedslonn = manedslonn;
        this.avdeling = avdeling;
    }

    public Ansatt(){

    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public Date getAnsettelse() {
        return ansettelse;
    }

    public void setAnsettelse(Date ansettelse) {
        this.ansettelse = ansettelse;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public Integer getManedslonn() {
        return manedslonn;
    }

    public void setManedslonn(Integer manedslonn) {
        this.manedslonn = manedslonn;
    }

    public Integer getAvdeling() {
        return avdeling;
    }

    public void setAvdeling(Integer avdeling) {
        this.avdeling = avdeling;
    }

    @Override
    public String toString() {
        return "Ansatt{" +
                "id=" + ansattid +
                ", brukernavn='" + brukernavn + '\'' +
                ", fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", ansettelse=" + ansettelse +
                ", stilling='" + stilling + '\'' +
                ", manedslonn=" + manedslonn +
                ", avdeling=" + avdeling +
                '}';
    }
}
