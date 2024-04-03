package no.hvl.dat107.oblig3;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProsjektDAO {

    private EntityManagerFactory emf;

    public ProsjektDAO(){

        emf = Persistence.createEntityManagerFactory("default");
    }


}
