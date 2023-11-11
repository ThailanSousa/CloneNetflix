package br.com.unifacol.cloneflix.model.repositorio;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.unifacol.cloneflix.model.enums.Message;
import br.com.unifacol.cloneflix.model.entities.Assinatura;


public class AssinaturaRepositorio  {

  private EntityManagerFactory emf;

  public AssinaturaRepositorio() {
    emf = Persistence.createEntityManagerFactory("cloneflix");
  }

  public List<Assinatura> listarAssinatura() {
    EntityManager em = emf.createEntityManager();
    List<Assinatura> assinatura = em.createQuery("SELECT e FROM assinatura e", Assinatura.class).getResultList();
    em.close();
    return assinatura;
  }

  public boolean cadastrarAssinatura(Assinatura assinatura) {
    try {
      EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(assinatura);
        em.getTransaction().commit();
        em.close();
      return true;
    } catch (Exception e) {
      System.out.println(e);
      System.out.println();
      return false;
    }
    
    }
  

  public boolean atualizarAssinatura(Assinatura assinatura) {
    try {
      EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(assinatura);
        em.getTransaction().commit();
        em.close();

      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  public Assinatura obterAssinaturaPorNomeAssinatura(String nomeAssinatura) {
    Assinatura assinatura;
    try {
      EntityManager em = emf.createEntityManager();
      assinatura = em.find(Assinatura.class, nomeAssinatura);
    } catch (Exception e) {
      
      System.out.println(Message.ERRO);
      return null;
    }
    return assinatura;
  }

  public void removerAssinatura(String nomeAssinatura) {
    try {
      EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Assinatura assinatura = em.find(Assinatura.class, nomeAssinatura);
        if (assinatura != null) {
            em.remove(assinatura);
        }
        em.getTransaction().commit();
        em.close();
    } catch (Exception e) {
      System.out.println("Erro: " + e);
    }
  }
}
