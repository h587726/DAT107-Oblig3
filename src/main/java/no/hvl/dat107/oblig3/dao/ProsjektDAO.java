package no.hvl.dat107.oblig3.dao;

import jakarta.persistence.*;
import no.hvl.dat107.oblig3.model.Avdeling;
import no.hvl.dat107.oblig3.service.ProsjektRepo;
import no.hvl.dat107.oblig3.model.Prosjekt;

import java.util.List;

public class ProsjektDAO implements ProsjektRepo {

    private EntityManagerFactory emf;

    public ProsjektDAO(){

        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public void leggTilProsjekt(String navn, String beskrivelse){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Prosjekt prosjekt = new Prosjekt();
        try{

            tx.begin();
            prosjekt.setProsjektnavn(navn);
            prosjekt.setBeskrivelse(beskrivelse);
            em.persist(prosjekt);
            tx.commit();
        }catch (Throwable e){

            e.printStackTrace();
            tx.rollback();
        }finally {

            em.close();
        }
    }

    @Override
    public Prosjekt finnProsjektMedId(int id){

        EntityManager em = emf.createEntityManager();

        try{

            return em.find(Prosjekt.class, id);
        }finally {

            em.close();
        }
    }

    @Override
    public List<Prosjekt> hentAlleProsjekter(){

        EntityManager em = emf.createEntityManager();

        String jpqlQuery = "select a from Prosjekt a";

        try{

            TypedQuery<Prosjekt> query = em.createQuery(jpqlQuery, Prosjekt.class);
            return query.getResultList();
        }finally{

            em.close();
        }
    }
}