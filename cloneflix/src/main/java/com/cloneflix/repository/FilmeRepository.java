package com.cloneflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.cloneflix.model.entities.Filme;

public class FilmeRepository {

    private EntityManagerFactory emf;

    public FilmeRepository() {
        this.emf = Persistence.createEntityManagerFactory("cloneflix");
    }

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


    public boolean atualizarFilme(Filme filme) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(filme);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o filme.");
            return false;
        }
    }

    public Filme consultarFilmePorGenero(String genero) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);
            Root<Filme> root = cq.from(Filme.class);
            cq.select(root).where(cb.equal(root.get("genero"), genero));
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            System.out.println("Filme não encontrado para o gênero fornecido.");
            return null;
        } finally {
            em.close();
        }
    }

    public boolean deletarFilmePorTitulo(String titulo) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);
            Root<Filme> root = cq.from(Filme.class);
            Predicate predicate = cb.equal(root.get("titulo"), titulo);
            cq.select(root).where(predicate);
            Filme filme = em.createQuery(cq).getSingleResult();
            em.remove(filme);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao deletar o filme por título.");
            return false;
        }
    }

    public List<Filme> listarTodosOsFilmes() {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);
            Root<Filme> root = cq.from(Filme.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Filme> listarFilmesDisponiveis() {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);
            Root<Filme> root = cq.from(Filme.class);
            cq.select(root).where(cb.equal(root.get("disponivelParaAssistir"), 1));
            return em.createQuery(cq).getResultList();
        } finally {
            em.close();
        }
    }

    public Filme consultarFilmePorTitulo(String tituloEscolhido) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);
            Root<Filme> root = cq.from(Filme.class);
            cq.select(root).where(cb.equal(root.get("titulo"), tituloEscolhido));
            List<Filme> resultados = em.createQuery(cq).getResultList();
            if (!resultados.isEmpty()) {
                return resultados.get(0); // Retorna o primeiro filme encontrado
            } else {
                System.out.println("Filme não encontrado para o título fornecido.");
                return null;
            }
        } finally {
            em.close();
        }
    }

    // Adicione outros métodos conforme necessário

}
