package no.hvl.dat107.oblig3.dao;

import jakarta.persistence.*;
import no.hvl.dat107.oblig3.service.AnsattRepo;
import no.hvl.dat107.oblig3.model.Ansatt;

import java.util.List;

public class AnsattDAO implements AnsattRepo {

    private EntityManagerFactory emf;

    public AnsattDAO(){

        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public List<Ansatt> hentAnsatte(){

        EntityManager em = emf.createEntityManager();

        String jpqlQuery = "select a from Ansatt a";

        try{

            TypedQuery<Ansatt> query = em.createQuery(jpqlQuery, Ansatt.class);
            return query.getResultList();
        }finally{

            em.close();
        }
    }

    @Override
    public Ansatt hentAnsattMedId(int id){

        EntityManager em = emf.createEntityManager();

        try{

            return em.find(Ansatt.class, id);
        }finally {

            em.close();
        }
    }

    @Override
    public Ansatt hentAnsattMedBrukernavn(String brukernavn){

        EntityManager em = emf.createEntityManager();

        String jpqlQuery = "select a from Ansatt a where a.brukernavn like :brukernavn";

        try{

            TypedQuery<Ansatt> query = em.createQuery(jpqlQuery, Ansatt.class);
            query.setParameter("brukernavn", brukernavn);
            return query.getSingleResult();
        }finally{

            em.close();
        }
    }

    @Override
    public void oppdaterAnsattStilling(int id, String stilling){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{

            tx.begin();
            Ansatt ansatt = em.find(Ansatt.class, id);
            ansatt.setStilling(stilling);
            tx.commit();
        }catch (Throwable e){

            e.printStackTrace();
            tx.rollback();
        }finally{

            em.close();
        }
    }

    @Override
    public void oppdaterAnsattLonn(int id, int lonn){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{

            tx.begin();
            Ansatt ansatt = em.find(Ansatt.class, id);
            ansatt.setManedslonn(lonn);
            tx.commit();
        }catch (Throwable e){

            e.printStackTrace();
            tx.rollback();
        }finally{

            em.close();
        }
    }

    @Override
    public void leggTilAnsatt(Ansatt ansatt){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{

            tx.begin();
            em.persist(ansatt);
            tx.commit();
        }catch (Throwable e){

            e.printStackTrace();
            tx.rollback();
        } finally {

            em.close();
        }
    }
}
