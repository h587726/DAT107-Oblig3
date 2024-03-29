package no.hvl.dat107.oblig3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AvdelingDAO implements AvdelingRepo{

    private EntityManagerFactory emf;

    public AvdelingDAO(){

        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Avdeling finnAvdelingMedId(int id){

        EntityManager em = emf.createEntityManager();

        try{

            return em.find(Avdeling.class, id);
        }finally {

            em.close();
        }
    }
}
