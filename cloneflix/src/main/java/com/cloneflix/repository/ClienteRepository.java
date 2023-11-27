package com.cloneflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
            em.remove(cliente);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao deletar o cliente.");
            return false;
        }
    }

    public Cliente autenticarCliente(String username, String password) {
        try {
            EntityManager em = emf.createEntityManager();
            return em
                    .createQuery("SELECT c FROM Cliente c WHERE c.username = :username AND c.password = :password",
                            Cliente.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Falha na autenticação do cliente");
            return null;
        }
    }
}
