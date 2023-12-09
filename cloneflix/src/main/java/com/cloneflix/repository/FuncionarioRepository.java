package com.cloneflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cloneflix.model.entities.Filme;
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

    public Funcionario consultarFuncionarioPorCpf(String cpf) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Funcionario> cq = cb.createQuery(Funcionario.class);
            Root<Funcionario> root = cq.from(Funcionario.class);
            cq.select(root).where(cb.equal(root.get("cpf"), cpf));
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            System.out.println("Funcionário não encontrado.");
            return null;
        } finally {
            em.close();
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
            System.out.println("Erro ao atualizar o funcionário.");
            return false;
        }
    }

    public boolean deletarFuncionario(String cpf) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Funcionario funcionario = em.find(Funcionario.class, cpf);
            em.remove(funcionario);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao deletar o funcionário.");
            return false;
        }
    }

    public Funcionario autenticarFuncionario(String cpf, String password) {
        try {
            EntityManager em = emf.createEntityManager();
            return em
                    .createQuery("SELECT f FROM Funcionario f WHERE f.cpf = :cpf AND f.password = :password", Funcionario.class)
                    .setParameter("cpf", cpf)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("|----------------------------------------------------------|");
            System.out.println("|   CPF ou senha incorretos, por favor, tente novamente    |");
            System.out.println("|----------------------------------------------------------|");
            return null;
        }
    }
    public List<Filme> listarTodosFilmes() {
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
}
