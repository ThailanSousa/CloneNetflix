package com.cloneflix;

import java.util.Scanner;

import com.cloneflix.model.entities.Cliente;
import com.cloneflix.service.ClienteService;
import com.cloneflix.service.FuncionarioService;

public class App {

    public static void main(String[] args) {
        String senhaAdm = "admin";
        Scanner scanner = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        FuncionarioService funcionarioService = new FuncionarioService();

        System.out.println("Bem-vindo ao sistema!");

        int escolha;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Fazer Login ");
            System.out.println("2. Criar Conta");
            System.out.println("3. Sair");

            escolha = obterEscolhaValida(scanner);

            switch (escolha) {
                case 1:
                    // Autenticação do Cliente
                    System.out.print("Digite o nome de usuário do cliente: ");
                    String clienteUsername = scanner.nextLine();
                    System.out.print("Digite a senha do cliente: ");
                    String clientePassword = scanner.nextLine();

                    Cliente clienteAutenticado = clienteService.autenticarCliente(clienteUsername, clientePassword);

                    if (clienteAutenticado != null) {
                        System.out.println("Cliente autenticado com sucesso: ");// + clienteAutenticado
                        exibirMenuCliente(scanner, clienteService, clienteAutenticado);
                    } else {
                        System.out.println("Falha na autenticação do cliente.");
                    }
                    break;

                case 2:
                    clienteService.cadastrarClienteComPacote();
                    break;

                case 3:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 3);

        scanner.close();
    }

    private static int obterEscolhaValida(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Insira um número válido:");
            }
        }
    }

    private static void exibirMenuCliente(Scanner scanner, ClienteService clienteService, Cliente clienteAutenticado) {
        int opcaoCliente;
    
        do {
            System.out.println("Menu do Cliente:");
            System.out.println("1. Exibir Dados");
            System.out.println("2. Alterar Dados");
            System.out.println("3. Ver Filmes");
            System.out.println("4. Sair");
    
            opcaoCliente = obterEscolhaValida(scanner);
    
            switch (opcaoCliente) {
                case 1:
                    // Exibir dados do cliente autenticado
                    exibirDadosCliente(clienteAutenticado);
                    break;
    
                case 2:
                clienteService.atualizarCliente();
                    break;
    
                case 3:
                    System.out.println("Executando a Opção 3 para o Cliente.");
                    break;
    
                case 4:
                    System.out.println("Saindo do menu do Cliente.");
                    break;
    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
    
        } while (opcaoCliente != 4);
    }
    
    private static void exibirDadosCliente(Cliente cliente) {
        System.out.println("Dados do Cliente:");
        System.out.println("Nome: " + cliente.getName());
        System.out.println("Idade: " + cliente.getAge());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Telefone: " + cliente.getPhone());
        System.out.println("Username: " + cliente.getUsername());
        System.out.println("Pacote: " + cliente.getPacote());
    }
}
