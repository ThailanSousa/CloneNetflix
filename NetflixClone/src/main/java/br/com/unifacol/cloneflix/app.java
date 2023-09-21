package br.com.unifacol.cloneflix;

import java.util.Scanner;

import br.com.unifacol.cloneflix.model.service.AssinaturaService;
import br.com.unifacol.cloneflix.model.service.ClienteService;
import br.com.unifacol.cloneflix.model.service.FuncionarioService;
import br.com.unifacol.cloneflix.model.service.FilmeService;

public class app {

    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de cadastro e alteração de clientes!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Alterar cliente");
        System.out.print("Opção: ");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Você escolheu cadastrar cliente.");
                clienteService.cadastarCliente();
                break;
            case 2:
                System.out.println("Você escolheu alterar cliente.");
                clienteService.atualizarCliente();
                break;
            case 3:
                System.out.println("Você escolheu cadastrar Assinatura.");
                AssinaturaService.cadastrarAssinatura();
                break;

            default:
                System.out.println("Opção inválida. Por favor, escolha 1 para cadastrar ou 2 para alterar.");
                break;
        }

        scanner.close();
    }
}
