package br.com.unifacol.cloneflix;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


import br.com.unifacol.cloneflix.model.service.ClienteService;
import br.com.unifacol.cloneflix.model.service.FuncionarioService;

public class app {

    public static void main(String[] args) throws SQLException {
        ClienteService clienteService = new ClienteService();

        Scanner scanner = new Scanner(System.in);

        int escolha = 0;

        do {
            System.out.println("Bem-vindo ao sistema de cadastro e alteração de clientes!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar Filme");
            System.out.println("3 - Cadastrar Assinatura");
            System.out.println("4 - Cadastrar Funcionario");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");

            try {
                escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                    int choice = 0;
                    System.out.println("Bem-vindo ao sistema de cadastro e alteração de clientes!");
                    System.out.println("Escolha uma opção:");
                    System.out.println("1 - Cadastrar cliente");
                    System.out.println("2 - Alterar cliente");
                    System.out.println("3 - Deletar cliente");
                    System.out.println("4 - listar os clientes por CPF");
                    System.out.println("5 - listar todos os Clientes");
                    System.out.println("0 - Sair");

                    System.out.print("Opção: ");
                    choice =scanner.nextInt();
                    do {
                        switch (choice) {
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
                            System.out.println("Você escolheu listar os clientes por cpf.");
                            Scanner cpfInput = new Scanner(System.in);
                            System.out.print("Digite o CPF: ");
                            String cpf = cpfInput.nextLine();
                            clienteService.listarPorCpf(cpf);
                            break;
                        case 5:
                            System.out.println("Você escolheu listar todos os clientes.");
                            clienteService.listarTodos();
                            break;
                        default:
                            System.out.println("Opção Invalida");
                            break;
                    }
                    } while (choice !=0);
                        break;
                    case 2:
                    int choice2 = 0;
                    System.out.println("Bem-vindo ao sistema de cadastro e alteração de Filmes!");
                    System.out.println("Escolha uma opção:");
                    System.out.println("1 - Cadastrar Filme");
                    System.out.println("2 - Alterar Filme");
                    System.out.println("3 - Deletar Filme");
                    System.out.println("4 - listar os Filmes por CPF");
                    System.out.println("5 - listar todos os Filmes");
                    System.out.println("0 - Sair");

                    System.out.print("Opção: ");
                    choice =scanner.nextInt();
                    
                    do {
                        switch (choice2) {
                        case 1:
                            System.out.println("Você escolheu cadastrar Filme.");
                            clienteService.cadastarCliente();
                            break;
                        case 2:
                            System.out.println("Você escolheu alterar Filme.");
                            clienteService.atualizarCliente();
                            break;
                        case 3:
                            System.out.println("Você escolheu deletar Filme.");
                            clienteService.removerCliente();
                            break;
                        case 4:
                            System.out.println("Você escolheu listar os Filmes por cpf.");
                            Scanner cpfInput = new Scanner(System.in);
                            System.out.print("Digite o CPF: ");
                            String cpf = cpfInput.nextLine();
                            clienteService.listarPorCpf(cpf);
                            break;
                        case 5:
                            System.out.println("Você escolheu listar todos os Filmes.");
                            clienteService.listarTodos();
                            break;
                        default:
                            System.out.println("Opção Invalida");
                            break;
                    }
                    } while (choice2 !=0);
                        break;
                    case 3:
                        

                    case 4:


                    case 5:

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
