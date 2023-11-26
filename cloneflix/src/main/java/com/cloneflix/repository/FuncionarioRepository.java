package com.cloneflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cloneflix.model.entities.Funcionario;

public class FuncionarioRepository {

    private EntityManagerFactory emf;

    public FuncionarioRepository() {
        this.emf = Persistence.createEntityManagerFactory("cloneflix");
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
            System.out.println("Erro ao cadastrar o funcionário.");
            return false;
        }
    }

    public Funcionario consultarFuncionario(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Funcionario.class, id);
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
            System.out.println("Erro ao atualizar o funcionário.");
            return false;
        }
    }

    public boolean deletarFuncionario(Long id) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Funcionario funcionario = em.find(Funcionario.class, id);
            em.remove(funcionario);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao deletar o funcionário.");
            return false;
        }
    }
    public Funcionario autenticarFuncionario(String username, String password) {
        try {
            EntityManager em = emf.createEntityManager();
            return em.createQuery("SELECT f FROM Funcionario f WHERE f.username = :username AND f.password = :password", Funcionario.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Falha na autenticação do funcionário");
            return null;
        }
    }
}
