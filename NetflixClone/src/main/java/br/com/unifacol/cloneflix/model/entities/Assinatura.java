package br.com.unifacol.cloneflix.model.entities;

public class Assinatura {
    private String nomeAssinatura;
    private double precoMensal;
    private int duracaoMeses;
    private boolean ativa;

    public Assinatura(){}

    public Assinatura(String nomeAssinatura, double precoMensal, int duracaoMeses) {
        this.nomeAssinatura = nomeAssinatura;
        this.precoMensal = precoMensal;
        this.duracaoMeses = duracaoMeses;
        this.ativa = true;
    }

    public String getNomeAssinatura() {
        return nomeAssinatura;
    }

    public void setNomeAssinatura(String nomeAssinatura) {
        this.nomeAssinatura = nomeAssinatura;
    }

    public double getPrecoMensal() {
        return precoMensal;
    }

    public void setPrecoMensal(double precoMensal) {
        this.precoMensal = precoMensal;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(int duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public String toString() {
        return "Nome do Assinante: " + nomeAssinatura + "\n" +
                "Preço Mensal: $" + precoMensal + "\n" +
                "Duração da Assinatura: " + duracaoMeses + " meses\n" +
                "Status: " + (ativa ? "Ativa" : "Inativa");
    }
        /*public static void main(String[] args) {
            // Crie algumas instâncias de Assinatura
            Assinatura assinatura1 = new Assinatura("João", 9.99, 12);
            Assinatura assinatura2 = new Assinatura("Maria", 14.99, 6);
    
            // Exiba as informações das assinaturas
            System.out.println("Assinatura 1:");
            System.out.println(assinatura1.toString());
    
            System.out.println("\nAssinatura 2:");
            System.out.println(assinatura2.toString());
        }*/
    }
    

