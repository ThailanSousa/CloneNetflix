package com.cloneflix.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.cloneflix.model.entities.Assinatura;
import com.cloneflix.model.entities.Cliente;
import com.cloneflix.repository.AssinaturaRepository;

public class AssinaturaService {

    private AssinaturaRepository assinaturaRepository;

    public AssinaturaService() {
        this.assinaturaRepository = new AssinaturaRepository();
    }

    public void cadastrarAssinatura(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o pacote de assinatura:");
        System.out.println("1. Básico");
        System.out.println("2. Normal");
        System.out.println("3. Família");
        System.out.println("4. Premium");

        int tipoPacote;
        while (true) {
            try {
                tipoPacote = Integer.parseInt(scanner.nextLine());
                if (tipoPacote >= 1 && tipoPacote <= 4) {
                    break;
                } else {
                    System.out.println("Pacote inválido. Escolha entre 1 e 4:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Insira um número válido para o pacote:");
            }
        }

        System.out.print("Número do cartão: ");
        String numeroCartao = scanner.nextLine();

        System.out.print("Data de expiração do cartão (MM/AA): ");
        String dataExpiracaoCartao = scanner.nextLine();

        System.out.print("CVC do cartão: ");
        String cvcCartao = scanner.nextLine();

        // Lógica para criar a assinatura
        boolean assinaturaCriada = criarAssinatura(cliente, tipoPacote, numeroCartao, dataExpiracaoCartao, cvcCartao);

        if (assinaturaCriada) {
            System.out.println("Assinatura criada com sucesso!");
        } else {
            System.out.println("Falha ao criar a assinatura. Tente novamente.");
        }
    }

    public boolean criarAssinatura(Cliente cliente, int tipoPacote, String numeroCartao, String dataExpiracaoCartao,
            String cvcCartao) {
        if (validarCartao(numeroCartao, dataExpiracaoCartao, cvcCartao)) {
            // Vamos supor que o pagamento foi bem-sucedido para simplificar o exemplo.
            Date dataInicio = new Date();
            Date dataFim = calcularDataFim(dataInicio, tipoPacote);

            Assinatura novaAssinatura = new Assinatura(cliente, tipoPacote, numeroCartao, dataExpiracaoCartao,
                    cvcCartao);
            cliente.adicionarAssinatura(novaAssinatura);

            return assinaturaRepository.criarAssinatura(novaAssinatura);
        } else {
            System.out.println("Falha na validação do cartão.");
            return false;
        }
    }

    private boolean validarCartao(String numeroCartao, String dataExpiracaoCartao, String cvcCartao) {
        // Simulação básica de validação do cartão
        // Você deve implementar uma lógica mais robusta ou utilizar um serviço de
        // pagamento real.
        return numeroCartao.length() == 16 && dataExpiracaoCartao.length() == 5 && cvcCartao.length() == 3;
    }

    private Date calcularDataFim(Date dataInicio, int tipoPacote) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInicio);

        // Lógica para calcular a data de término da assinatura
        // Você pode implementar a lógica específica do seu modelo de negócios, por
        // exemplo, adicionando um período de 30 dias.

        switch (tipoPacote) {
            case 1: // Básica
                calendar.add(Calendar.DAY_OF_MONTH, 30);
                break;
            case 2: // Normal
                calendar.add(Calendar.DAY_OF_MONTH, 60);
                break;
            case 3: // Família
                calendar.add(Calendar.DAY_OF_MONTH, 90);
                break;
            case 4: // Premium
                calendar.add(Calendar.DAY_OF_MONTH, 120);
                break;
        }

        return calendar.getTime();
    }

}
