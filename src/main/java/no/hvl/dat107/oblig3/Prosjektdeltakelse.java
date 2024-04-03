package no.hvl.dat107.oblig3;

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
    private String arbeidstimer;

    @ManyToOne
    @JoinColumn(name = "prosjektid", referencedColumnName = "prosjektid")
    private Prosjekt prosjektid;

    @ManyToOne
    @JoinColumn(name = "ansattid", referencedColumnName = "ansattid")
    private Ansatt ansattid;

    public int getProsjektdeltakelseid(){

        return prosjektdeltakelseid;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public String getArbeidstimer() {
        return arbeidstimer;
    }

    public void setArbeidstimer(String arbeidstimer) {
        this.arbeidstimer = arbeidstimer;
    }
}
