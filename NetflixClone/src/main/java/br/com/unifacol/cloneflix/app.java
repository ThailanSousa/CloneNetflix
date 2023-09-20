package br.com.unifacol.cloneflix;

import java.util.InputMismatchException;
import java.util.Scanner;
import br.com.unifacol.cloneflix.model.service.ClienteService;

public class app {

    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();

        Scanner scanner = new Scanner(System.in);

        int escolha = 0; 

        do {
            System.out.println("Bem-vindo ao sistema de cadastro e alteração de clientes!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Alterar cliente");
            System.out.println("3 - Deletar cliente");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");

            try {
                escolha = scanner.nextInt();

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
                        System.out.println("Você escolheu deletar cliente.");
                        clienteService.removerCliente();
                        break;
                    case 0:
                        System.out.println("Saindo do programa. Obrigado!");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); 
            }
        } while (escolha == 0);{

            escolha = escolha - 1;

        }
        scanner.close();
        
    }
}
