package com.cloneflix.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assinatura")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    
    private int tipoPacote; // 1 = Básica, 2 = Normal, 3 = Família, 4 = Premium

    
    private String numeroCartao;

    
    private String dataExpiracaoCartao;

    
    private String cvcCartao;



    public Assinatura() {
    }

    public Assinatura(Cliente cliente, int tipoPacote, String numeroCartao, String dataExpiracaoCartao, String cvcCartao) {
        this.cliente = cliente;
        this.tipoPacote = tipoPacote;
        this.numeroCartao = numeroCartao;
        this.dataExpiracaoCartao = dataExpiracaoCartao;
        this.cvcCartao = cvcCartao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTipoPacote() {
        return tipoPacote;
    }

    public void setTipoPacote(int tipoPacote) {
        this.tipoPacote = tipoPacote;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getDataExpiracaoCartao() {
        return dataExpiracaoCartao;
    }

    public void setDataExpiracaoCartao(String dataExpiracaoCartao) {
        this.dataExpiracaoCartao = dataExpiracaoCartao;
    }

    public String getCvcCartao() {
        return cvcCartao;
    }

    public void setCvcCartao(String cvcCartao) {
        this.cvcCartao = cvcCartao;
    }

    
}
