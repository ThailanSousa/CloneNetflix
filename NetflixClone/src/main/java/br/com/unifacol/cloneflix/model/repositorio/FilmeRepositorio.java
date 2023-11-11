package br.com.unifacol.cloneflix.model.repositorio;

import java.util.List;
import java.util.Stack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.unifacol.cloneflix.model.Interface.IFilmeMSQL;

import br.com.unifacol.cloneflix.model.entities.Filme;



public class FilmeRepositorio implements IFilmeMSQL {
  private EntityManagerFactory emf;


  public FilmeRepositorio() {
    emf = Persistence.createEntityManagerFactory("cloneflix");
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
      System.out.println(e);
      System.out.println("Erro ao Cadastrar o filme");
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
      System.out.println(e);
      return false;
    }
  }

  public Filme obterFilme(String genero) {
    Filme filme;
    try {
      EntityManager em = emf.createEntityManager();
      filme = em.find(Filme.class, genero);
    } catch (Exception e) {
      
      System.out.println("Erro: " + e);
      return null;
    }
    return filme;
  }


  public Stack<Filme> listarFilmesPorGenero()  {
    
    EntityManager em = emf.createEntityManager();
    List<Filme> filme = em.createQuery("SELECT e FROM filme e", Filme.class).getResultList();
    em.close();
    return (Stack<Filme>) filme;
  
};

  public void removerFilmeNome(String titulo) {
    try {
      EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Filme filme = em.find(Filme.class, titulo);
        if (filme != null) {
            em.remove(filme);
        }
        em.getTransaction().commit();
        em.close();
    } catch (Exception e) {
      System.out.println("Erro: " + e);
    }
  }
    
}


