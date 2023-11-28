package com.cloneflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cloneflix.model.entities.Assinatura;

public class AssinaturaRepository {

    private EntityManagerFactory emf;

    public AssinaturaRepository() {
        this.emf = Persistence.createEntityManagerFactory("cloneflix");
    }

    // Método para criar uma nova assinatura no banco de dados
    public boolean cadastrarAssinatura(Assinatura assinatura) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            // Verificar se o cliente já possui alguma assinatura
            if (assinaturaJaExistente(em, assinatura)) {
                System.out.println("O cliente já possui uma assinatura.");
                em.getTransaction().rollback(); // Desfaz a transação
                em.close();
                return false;
            }

            em.persist(assinatura);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar a assinatura.");
            e.printStackTrace(); // Adicione esta linha para imprimir o stack trace completo para fins de depuração
            return false;
        }
    }

    // Método auxiliar para verificar se o cliente já possui alguma assinatura
    private boolean assinaturaJaExistente(EntityManager em, Assinatura assinatura) {
        Query query = em.createQuery("SELECT COUNT(a) FROM Assinatura a WHERE a.cliente = :cliente", Long.class);
        query.setParameter("cliente", assinatura.getCliente());

        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

    public boolean criarAssinatura(Assinatura novaAssinatura) {
        return false;
    }
}
