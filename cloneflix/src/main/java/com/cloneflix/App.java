package com.cloneflix;

import java.util.Scanner;

import com.cloneflix.model.entities.Cliente;
import com.cloneflix.model.entities.Funcionario;
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
            System.out.println("2.  Criar conta");
            // System.out.println("9. Autenticar Funcionário");
            System.out.println("0. Sair");

            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

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

                        // Menu do Cliente após a autenticação
                        int opcaoCliente;

                        do {
                            System.out.println("Menu do Cliente:");
                            System.out.println("1. Opção 1");
                            System.out.println("2. Opção 2");
                            System.out.println("3. Opção 3");
                            System.out.println("4. Sair");

                            opcaoCliente = scanner.nextInt();
                            scanner.nextLine(); // Consumir a quebra de linha

                            switch (opcaoCliente) {
                                case 1:
                                    System.out.println("Executando a Opção 1 para o Cliente.");
                                    break;

                                case 2:
                                    System.out.println("Executando a Opção 2 para o Cliente.");
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

                    } else {
                        System.out.println("Falha na autenticação do cliente.");
                    }
                    break;

                    case 2:
                    clienteService.cadastrarCliente();
                    break;
                case 9:

                    // Autenticação do funcionario
                    System.out.print("Digite a senha do administrador: ");
                    String senhaDigitada = scanner.nextLine();

                    if (senhaAdm.equals(senhaDigitada)) {
                        System.out.println("Administrador reconhecido. Faça seu login como funcionário.");

                        System.out.print("Digite o nome de usuário do funcionário: ");
                        String funcionarioUsername = scanner.nextLine();
                        System.out.print("Digite a senha do funcionário: ");
                        String funcionarioPassword = scanner.nextLine();

                        Funcionario funcionarioAutenticado = funcionarioService
                                .autenticarFuncionario(funcionarioUsername, funcionarioPassword);

                        if (funcionarioAutenticado != null) {
                            System.out.println("Funcionario autenticado com sucesso: ");// + funcionarioAutenticado

                            // Menu do Funcionario após a autenticação
                            int opcaoFuncionario;

                            do {
                                System.out.println("Menu do Funcionario:");
                                System.out.println("1. Opção 1");
                                System.out.println("2. Opção 2");
                                System.out.println("3. Opção 3");
                                System.out.println("4. Sair");

                                opcaoFuncionario = scanner.nextInt();
                                scanner.nextLine(); // Consumir a quebra de linha

                                switch (opcaoFuncionario) {
                                    case 1:
                                        System.out.println("Executando a Opção 1 para o Funcionario.");
                                        break;

                                    case 2:
                                        System.out.println("Executando a Opção 2 para o Funcionario.");
                                        break;

                                    case 3:
                                        System.out.println("Executando a Opção 3 para o Funcionario.");
                                        break;

                                    case 4:
                                        System.out.println("Saindo do menu do Funcionario.");
                                        break;

                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                }

                            } while (opcaoFuncionario != 4);
                        }
                    } else {
                        System.out.println("Falha na autenticação do Funcionario.");
                    }
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
}
