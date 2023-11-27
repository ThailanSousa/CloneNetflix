package com.cloneflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cloneflix.model.entities.Funcionario;

public class FuncionarioRepository {

    private EntityManagerFactory emf;

    public FuncionarioRepository() {
        this.emf = Persistence.createEntityManagerFactory("cloneflix");
    }
    //metodo de cadastro funcionario baseado no cliente !!!
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
    
    
    //metodo de consutar funcionario baseado no cliente !!!
    public Funcionario consultarFuncioanrioPorCpf(String cpf) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Funcionario> cq = cb.createQuery(Funcionario.class);
            Root<Funcionario> root = cq.from(Funcionario.class);
            cq.select(root).where(cb.equal(root.get("cpf"), cpf));
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            System.out.println("Funcionario não encontrado.");
            return null;
        } finally {
            em.close();
        }
    }
    
    //metodo de atualizar funcionario baseado no cliente !!!
    public boolean atualizarFuncioanrio(Funcionario funcionario) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o funcionario.");
            return false;
        }
    }

    //metodo de deletar funcionario baseado no cliente !!!
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

    //metodo de autenticar funcionario cod by ChatGPT (ass.Thailan)
    public Funcionario autenticarFuncionario(String username, String password) {
        try {
            EntityManager em = emf.createEntityManager();
            return em
                    .createQuery("SELECT f FROM Funcionario f WHERE f.username = :username AND f.password = :password",
                            Funcionario.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Falha na autenticação do funcionário");
            return null;
        }
    }
}
