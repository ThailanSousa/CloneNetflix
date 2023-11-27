package com.cloneflix.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Date dataInicio;
    private Date dataFim;

    private int tipoPacote; // 1 = Básica, 2 = Normal, 3 = Família, 4 = Premium

    private String numeroCartao;
    private String dataExpiracaoCartao;
    private String cvcCartao;

    public Assinatura() {
        // Construtor padrão
    }

    public Assinatura(Cliente cliente, Date dataInicio, Date dataFim, int tipoPacote, String numeroCartao, String dataExpiracaoCartao, String cvcCartao) {
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tipoPacote = tipoPacote;
        this.numeroCartao = numeroCartao;
        this.dataExpiracaoCartao = dataExpiracaoCartao;
        this.cvcCartao = cvcCartao;
    }

    // Métodos getters e setters

    @Override
    public String toString() {
        return "Assinatura [id=" + id + ", cliente=" + cliente + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", tipoPacote=" + tipoPacote + "]";
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
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
