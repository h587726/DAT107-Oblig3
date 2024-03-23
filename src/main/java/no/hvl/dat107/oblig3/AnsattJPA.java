package no.hvl.dat107.oblig3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Map;

public class AnsattJPA {

    private EntityManagerFactory emf;

    public AnsattJPA(){

        emf = Persistence.createEntityManagerFactory("defualt");
    }

    @Override
    public List<Ansatt> hentAnsatte(){

        EntityManager em = emf.createEntityManager();

        String jpqlQuery = "select p from Ansatt p order by p.id";


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
}
