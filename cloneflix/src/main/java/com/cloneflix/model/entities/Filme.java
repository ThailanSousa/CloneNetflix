package com.cloneflix.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFilme;

    private String titulo;
    private String diretor;
    private int duracaoMinutos;
    private int anoLancamento;
    private String genero;
    private String sinopse;
    private int disponivelParaAssistir;

    public Filme() {
    }

    public Filme(String titulo, String diretor, int duracaoMinutos, int anoLancamento, String genero, String sinopse, int disponivelParaAssistir) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.duracaoMinutos = duracaoMinutos;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.sinopse = sinopse;
        this.disponivelParaAssistir = disponivelParaAssistir;
    }

   

    public long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(long idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getDisponivelParaAssistir() {
        return disponivelParaAssistir;
    }

    public void setDisponivelParaAssistir(int disponivelParaAssistir) {
        this.disponivelParaAssistir = disponivelParaAssistir;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "idFilme=" + idFilme +
                ", titulo='" + titulo + '\'' +
                ", diretor='" + diretor + '\'' +
                ", duracaoMinutos=" + duracaoMinutos +
                ", anoLancamento=" + anoLancamento +
                ", genero='" + genero + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", disponivelParaAssistir=" + disponivelParaAssistir +
                '}';
    }
}
