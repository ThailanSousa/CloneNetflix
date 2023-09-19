package br.com.unifacol.cloneflix.model.entities;

public class Filme {

    private String titulo;
    private String diretor;
    private int duracaoMinutos;
    private int anoLancamento;
    private String genero;
    private String sinopse;
    private boolean disponivelParaAssistir;

    // Construtor
    public Filme(String titulo, String diretor, int duracaoMinutos, int anoLancamento, String genero, String sinopse, boolean disponivelParaAssistir) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.duracaoMinutos = duracaoMinutos;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.sinopse = sinopse;
        this.disponivelParaAssistir = disponivelParaAssistir; 
    }

    // Getters e setters
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

    public boolean isDisponivelParaAssistir() {
        return disponivelParaAssistir;
    }

    public void setDisponivelParaAssistir(boolean disponivelParaAssistir) {
        this.disponivelParaAssistir = disponivelParaAssistir;
    }

    // toString()

    public String toString() {
        return "Título: " + titulo + "\n" +
                "Diretor: " + diretor + "\n" +
                "Duração: " + duracaoMinutos + " minutos\n" +
                "Ano de Lançamento: " + anoLancamento + "\n" +
                "Gênero: " + genero + "\n" +
                "Sinopse: " + sinopse + "\n" +
                "Disponível para Assistir: " + (disponivelParaAssistir ? "Sim" : "Não");
    }
    // public static void main(String[] args) {
    //     // Crie uma instância de Filme
    //     Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 175, 1972, "Drama", "A história da família Corleone",true);

    //     // Use os métodos getters para acessar os atributos e imprima-os
    //     System.out.println("Título: " + filme.getTitulo());
    //     System.out.println("Diretor: " + filme.getDiretor());
    //     System.out.println("Duração: " + filme.getDuracaoMinutos() + " minutos");
    //     System.out.println("Ano de Lançamento: " + filme.getAnoLancamento());
    //     System.out.println("Gênero: " + filme.getGenero());
    //     System.out.println("Sinopse: " + filme.getSinopse());
    //     System.out.println("Disponível para Assistir: " + (filme.isDisponivelParaAssistir() ? "Sim" : "Não"));

    // }
}


