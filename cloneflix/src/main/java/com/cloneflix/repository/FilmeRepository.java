package com.cloneflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cloneflix.model.entities.Filme;

public class FilmeRepository {

    private EntityManagerFactory emf;

    public FilmeRepository() {
        this.emf = Persistence.createEntityManagerFactory("cloneflix");
    }

    //metodo para  cadastrar filme !!!
    public boolean cadastrarFilme(Filme filme) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(filme);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o filme.");
            return false;
        }
    }

    public List<Filme> listarFilmesDisponiveis() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);
        Root<Filme> root = cq.from(Filme.class);
        cq.select(root).where(cb.equal(root.get("disponivelParaAssistir"), 1));
        return em.createQuery(cq).getResultList();
    }
}
