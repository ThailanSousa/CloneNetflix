package br.com.unifacol.cloneflix;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.unifacol.cloneflix.model.service.ClienteService;

public class app {

    public static void main(String[] args) throws SQLException {
        ClienteService clienteService = new ClienteService();

        Scanner scanner = new Scanner(System.in);

        int escolha = 0;

        do {
            System.out.println("Bem-vindo ao sistema de cadastro e alteração de clientes!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Alterar cliente");
            System.out.println("3 - Deletar cliente");
            System.out.println("4 - listar todos os clientes");
            System.out.println("5 - listar os clientes por cpf");
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

                    case 4:
                        System.out.println("Você escolheu listar todos os clientes.");
                        clienteService.listarTodos();
                        break;
                        case 5:
                        System.out.println("Você escolheu listar os clientes por cpf.");
                        Scanner cpfInput = new Scanner(System.in);
                        System.out.print("Digite o CPF: ");
                        String cpf = cpfInput.nextLine();
                        clienteService.listarPorCpf(cpf);
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
        } while (escolha == 0);
        {

            escolha = escolha - 1;

        }
        scanner.close();

    }
}
