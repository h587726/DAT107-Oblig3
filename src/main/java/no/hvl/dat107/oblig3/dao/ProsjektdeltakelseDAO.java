package no.hvl.dat107.oblig3.dao;

import jakarta.persistence.*;
import no.hvl.dat107.oblig3.model.Ansatt;
import no.hvl.dat107.oblig3.model.Prosjekt;
import no.hvl.dat107.oblig3.model.Prosjektdeltakelse;
import no.hvl.dat107.oblig3.service.ProsjektdeltakelseRepo;

import java.util.List;

public class ProsjektdeltakelseDAO implements ProsjektdeltakelseRepo {

    private EntityManagerFactory emf;

    public ProsjektdeltakelseDAO(){

        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public void registrerProsjektdeltakelse(Prosjektdeltakelse prosjektdeltakelse){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{

            tx.begin();
            em.persist(prosjektdeltakelse);
            tx.commit();
        }catch(Throwable e){

            e.printStackTrace();
            if(tx.isActive()){
                tx.rollback();
            }
        }finally {

            em.close();
        }
    }

    @Override
    public void leggTilTimer(int id, int timer){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{

            tx.begin();
            Prosjektdeltakelse prosjektdeltakelse = em.find(Prosjektdeltakelse.class, id);
            prosjektdeltakelse.setArbeidstimer(prosjektdeltakelse.getArbeidstimer() + timer);
            em.merge(prosjektdeltakelse);
            tx.commit();
        }catch(Throwable e){

            e.printStackTrace();
            if(tx.isActive()) tx.rollback();
        }finally {

            em.close();
        }
    }

    @Override
    public List<Prosjektdeltakelse> hentAlleProsjektdeltakelser(){

        EntityManager em = emf.createEntityManager();

        String jpqlQuery = "select a from Prosjektdeltakelse a";

        try{

            TypedQuery<Prosjektdeltakelse> query = em.createQuery(jpqlQuery, Prosjektdeltakelse.class);
            return query.getResultList();
        }finally {

            em.close();
        }
    }
}
