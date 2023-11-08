package br.com.unifacol.cloneflix.model.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.unifacol.cloneflix.model.Interface.IFuncionarioMSQL;
import br.com.unifacol.cloneflix.model.entities.Funcionario;


public class FuncionarioRepositorio implements IFuncionarioMSQL  {

  private EntityManagerFactory emf;

  public void funcionarioRepository() {
        emf = Persistence.createEntityManagerFactory("cloneflix");
    };


  public List<Funcionario> listarFuncionario() {
    EntityManager em = emf.createEntityManager();
    List<Funcionario> funcionario = em.createQuery("SELECT e FROM funcionario e", Funcionario.class).getResultList();
    em.close();
    return funcionario;
  }

  public boolean cadastrarFuncionario(Funcionario funcionario) {
    try {
      EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
      return true;
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("Erro ao Cadastrar o funcionario");
      return false;
    }

  }

  public boolean atualizarFuncionario(Funcionario funcionario) {
    try {
      EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
        em.close();

      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  public Funcionario obterFuncionarioCpf(String cpf) {
    Funcionario funcionario;
    try {
      EntityManager em = emf.createEntityManager();
      funcionario = em.find(Funcionario.class, cpf);
    } catch (Exception e) {
      
      System.out.println("Erro: " + e);
      return null;
    }
    return funcionario;
  }

  public void removerFuncionarioForCpf(String cpf) {
    try {
      EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Funcionario funcionario = em.find(Funcionario.class, cpf);
        if (funcionario != null) {
            em.remove(funcionario);
        }
        em.getTransaction().commit();
        em.close();
    } catch (Exception e) {
      System.out.println("Erro: " + e);
    }
  }

}
