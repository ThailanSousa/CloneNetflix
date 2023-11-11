package br.com.unifacol.cloneflix.model.repositorio;

import java.util.List;
import java.util.Stack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.unifacol.cloneflix.model.Interface.IClienteMSQL;
import br.com.unifacol.cloneflix.model.entities.Cliente;


public class ClienteRepositorio implements IClienteMSQL {

  private EntityManagerFactory emf;

  public ClienteRepositorio() {
    emf = Persistence.createEntityManagerFactory("cloneflix");
  }

  public Stack<Cliente> listarClientes() {
    EntityManager em = emf.createEntityManager();
    List<Cliente> cliente = em.createQuery("SELECT e FROM cliente e", Cliente.class).getResultList();
    em.close();
    return (Stack<Cliente>) cliente;
  }
  


  public boolean cadastrarCliente(Cliente cliente) {
    try {
      EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
      return true;
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("Erro ao Cadastrar o cliente");
      return false;
    }
  }

  public boolean atualizarCliente(Cliente cliente) {
    try {
      EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();

      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
    
  }

  public Cliente obterClientePorCPF(String cpf) {
    Cliente cliente;
    try {
      EntityManager em = emf.createEntityManager();
      cliente = em.find(Cliente.class, cpf);
    } catch (Exception e) {
      
      System.out.println("Erro: " + e);
      return null;
    }
    return cliente;
  }

  public void removerClienteForCpf(String cpf) {
    try {
      EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, cpf);
        if (cliente != null) {
            em.remove(cliente);
        }
        em.getTransaction().commit();
        em.close();
    } catch (Exception e) {
      System.out.println("Erro: " + e);
    }
  }

  public List<Cliente> listarPorCpf(String cpf) {
    EntityManager em = emf.createEntityManager();
    List<Cliente> cliente = em.createQuery("SELECT * FROM cliente WHERE cpf = "+cpf, Cliente.class).getResultList();
    em.close();
    return cliente;
  }



}



