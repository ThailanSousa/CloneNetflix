package com.cloneflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cloneflix.model.entities.Cliente;

public class ClienteRepository {

    private EntityManagerFactory emf;

    public ClienteRepository() {
        this.emf = Persistence.createEntityManagerFactory("cloneflix");
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
            System.out.println("Erro ao cadastrar o cliente.");
            return false;
        }
    }

    public Cliente consultarClientePorCpf(String cpf) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
            Root<Cliente> root = cq.from(Cliente.class);
            cq.select(root).where(cb.equal(root.get("cpf"), cpf));
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            System.out.println("Cliente não encontrado.");
            return null;
        } finally {
            em.close();
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
            System.out.println("Erro ao atualizar o cliente.");
            return false;
        }
    }

    public boolean deletarCliente(String cpf) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            
            Cliente cliente = em.find(Cliente.class, cpf);
            
            if (cliente != null) {
                em.remove(cliente);
                em.getTransaction().commit();
                em.close();
                return true;
            } else {
                System.out.println("Cliente não encontrado.");
                em.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar o cliente: " + e.getMessage());
            return false;
        }
    }
    

    public Cliente autenticarCliente(String cpf, String password) {
        try {
            EntityManager em = emf.createEntityManager();
            return em
                    .createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf AND c.password = :password", Cliente.class)
                    .setParameter("cpf", cpf)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("|----------------------------------------------------------|");
            System.out.println("|   CPF ou senha incorretos, por favor, tente novamente    |");
            System.out.println("|----------------------------------------------------------|");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            return null;
        }
    }

}
