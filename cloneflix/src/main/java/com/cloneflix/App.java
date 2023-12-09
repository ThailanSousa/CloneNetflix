package com.cloneflix;

import java.awt.Desktop;
import java.net.URI;
import java.util.List;
import java.util.Scanner;

import com.cloneflix.model.entities.Cliente;
import com.cloneflix.model.entities.Filme;
import com.cloneflix.model.entities.Funcionario;
import com.cloneflix.service.ClienteService;
import com.cloneflix.service.FilmeService;
import com.cloneflix.service.FuncionarioService;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        FuncionarioService funcionarioService = new FuncionarioService();
        FilmeService filmeService = new FilmeService();

        System.out.println("Bem-vindo ao sistema!");

        int escolha;

        do {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║          Escolha uma opção           ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║         1. Login                     ║");
            // System.out.println("║ 3. Fazer Login como Funcionário ║");
            System.out.println("║         2. Criar Conta de Cliente    ║");
            // System.out.println("║ 4. Criar Conta de Funcionário ║");
            System.out.println("║         5. Sair                      ║");
            System.out.println("╚══════════════════════════════════════╝");

            escolha = obterEscolhaValida(scanner);

            switch (escolha) {
                case 1:
                    Cliente clienteAutenticado = fazerLogin(scanner, clienteService);
                    if (clienteAutenticado != null) {
                        System.out.println("\nCliente autenticado com sucesso:");
                        exibirMenuCliente(scanner, clienteService, clienteAutenticado, filmeService);
                    } else {
                        System.out.println("\nFalha na autenticação do cliente.");
                    }
                    break;

                case 3:
                    Funcionario funcionarioAutenticado = fazerLogin(scanner, funcionarioService);
                    if (funcionarioAutenticado != null) {
                        System.out.println("\nFuncionário autenticado com sucesso:");
                        exibirMenuFuncionario(scanner, funcionarioService, funcionarioAutenticado, clienteService,
                                filmeService);
                    } else {
                        System.out.println("\nFalha na autenticação do funcionário.");
                    }
                    break;

                case 2:
                    clienteService.cadastrarCliente();
                    break;

                case 4:
                    funcionarioService.cadastrarFuncionario();
                    break;

                case 5:
                    System.out.println("\nSaindo do sistema. Até logo!");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }

        } while (escolha != 5);

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

    private static Cliente fazerLogin(Scanner scanner, ClienteService clienteService) {
        System.out.print("Digite o nome de usuário ou CPF do cliente: ");
        String clienteUsernameOuCpf = scanner.nextLine();
        System.out.print("Digite a senha do cliente: ");
        String clientePassword = scanner.nextLine();

        return clienteService.autenticarCliente(clienteUsernameOuCpf, clientePassword);
    }

    private static Funcionario fazerLogin(Scanner scanner, FuncionarioService funcionarioService) {
        System.out.print("Digite o nome de usuário ou CPF do funcionário: ");
        String funcionarioUsernameOuCpf = scanner.nextLine();
        System.out.print("Digite a senha do funcionário: ");
        String funcionarioPassword = scanner.nextLine();

        return funcionarioService.autenticarFuncionario(funcionarioUsernameOuCpf, funcionarioPassword);
    }

    private static void exibirMenuCliente(Scanner scanner, ClienteService clienteService, Cliente clienteAutenticado,
            FilmeService filmeService) {
        int opcaoCliente;

        do {
            System.out.println("╔═══════════════════════════════════╗");
            System.out.println("║           Menu do Cliente         ║");
            System.out.println("╠═══════════════════════════════════╣");
            // System.out.println("║       1. Exibir Dados             ║");
            // System.out.println("║       2. Alterar Dados            ║");
            System.out.println("║ 1. Ver Filmes Disponíveis         ║");
            System.out.println("║ 2. Assistir                       ║");
            System.out.println("║ 0. Sair                           ║");
            System.out.println("╚═══════════════════════════════════╝");

            opcaoCliente = obterEscolhaValida(scanner);

            switch (opcaoCliente) {
                case 3:
                    exibirDadosCliente(clienteAutenticado);
                    break;
                case 4:
                    clienteService.atualizarCliente();
                    break;
                case 1:
                    List<Filme> filmesDisponiveis = filmeService.exibirFilmesDisponiveis();
                    exibirListaDeFilmes(filmesDisponiveis);
                    break;
                case 2:
                    escolherFilmeParaAssistir(scanner, clienteAutenticado, filmeService);
                    break;
                case 0:
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║            Saindo do menu do Cliente.    ║");
                    System.out.println("╚══════════════════════════════════════════╝");
                    break;
                default:
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║       Opção inválida. Tente novamente    ║");
                    System.out.println("╚══════════════════════════════════════════╝");
            }

        } while (opcaoCliente != 0);
    }

    private static void escolherFilmeParaAssistir(Scanner scanner, Cliente cliente, FilmeService filmeService) {
        System.out.println("\nEscolha um filme para assistir:");
        List<Filme> filmesDisponiveis = filmeService.exibirFilmesDisponiveis();
        exibirListaDeFilmes(filmesDisponiveis);

        System.out.print("Digite o título do filme escolhido: ");
        String tituloEscolhido = scanner.nextLine();

        Filme filmeEscolhido = filmeService.consultarFilmePorTitulo(tituloEscolhido);

        if (filmeEscolhido != null) {
            exibirInformacoesDoFilme(filmeEscolhido);
            abrirNavegadorComLink(filmeEscolhido.getLink());
        } else {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║         Filme não encontrado.    ║");
            System.out.println("╚══════════════════════════════════╝");
        }
    }

    private static void abrirNavegadorComLink(String link) {
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (Exception e) {
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║ Erro ao abrir o navegador com o link.    ║");
            System.out.println("╚══════════════════════════════════════════╝");
            e.printStackTrace();
        }
    }

    private static void exibirInformacoesDoFilme(Filme filme) {
        System.out.println("\nInformações do Filme:");
        System.out.println("Título: " + filme.getTitulo());
        System.out.println("Duração: " + filme.getDuracaoMinutos() + " minutos");
        System.out.println("Ano de Lançamento: " + filme.getAnoLancamento());
        System.out.println("Gênero: " + filme.getGenero());
        System.out.println("Sinopse: " + filme.getSinopse());
        System.out.println("Disponível para Assistir: " + (filme.getDisponivelParaAssistir() == 1 ? "Sim" : "Não"));
    }

    private static void exibirDadosCliente(Cliente cliente) {
        System.out.println("\nDados do Cliente:");
        System.out.println("Nome: " + cliente.getName());
        System.out.println("Idade: " + cliente.getAge());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Telefone: " + cliente.getPhone());
        System.out.println("Username: " + cliente.getUsername());
    }

    private static void exibirMenuFuncionario(Scanner scanner, FuncionarioService funcionarioService,
            Funcionario funcionarioAutenticado, ClienteService clienteService, FilmeService filmeService) {

        int opcaoFuncionario;

        do {
            System.out.println("╔════════════════════════════════════╗");
            System.out.println("║       Menu do Funcionário          ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1. Exibir Dados                    ║");
            System.out.println("║ 2. Alterar Dados                   ║");
            System.out.println("║ 3. Ver Todos os Filmes             ║");
            System.out.println("║ 4. Manipular Dados do Cliente      ║");
            System.out.println("║ 5. Cadastrar Filme                 ║");
            System.out.println("║ 6. Ver Filmes Disponíveis          ║");
            System.out.println("║ 7. Sair                            ║");
            System.out.println("╚════════════════════════════════════╝");

            opcaoFuncionario = obterEscolhaValida(scanner);

            switch (opcaoFuncionario) {
                case 1:
                    exibirDadosFuncionario(funcionarioAutenticado);
                    break;
                case 2:
                    funcionarioService.atualizarFuncionario();
                    break;
                case 3:
                    List<Filme> todosOsFilmes = (List<Filme>) filmeService.listarTodosFilmes();
                    exibirListaDeFilmes(todosOsFilmes);
                    break;
                case 4:
                    manipularDadosCliente(scanner, clienteService);
                    break;
                case 5:
                    cadastrarFilme(scanner, funcionarioAutenticado.getCargo(), filmeService);
                    break;
                case 6:
                    List<Filme> filmesDisponiveis = filmeService.exibirFilmesDisponiveis();
                    exibirListaDeFilmes(filmesDisponiveis);
                    break;
                case 7:
                    System.out.println("╔══════════════════════════════════╗");
                    System.out.println("║ Saindo do menu do Funcionário    ║");
                    System.out.println("╚══════════════════════════════════╝");

                    break;
                default:
                    System.out.println("╔══════════════════════════════════╗");
                    System.out.println("║ Opção inválida. Tente novamente. ║");
                    System.out.println("╚══════════════════════════════════╝");

            }

        } while (opcaoFuncionario != 7);
    }

    private static void cadastrarFilme(Scanner scanner, Funcionario.Cargo cargo, FilmeService filmeService) {
        if (cargo == Funcionario.Cargo.AUX_PRODUCAO || cargo == Funcionario.Cargo.ADM) {
            filmeService.cadastrarFilme();
        } else {
            System.out.println(
                    "╔═════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║ Acesso negado. Apenas funcionários de Aux. Produção e Adm podem cadastrar filmes..      ║");
            System.out.println(
                    "╚═════════════════════════════════════════════════════════════════════════════════════════╝");

        }

    }

    private static void exibirListaDeFilmes(List<Filme> filmes) {
        System.out.println("\nLista de Filmes:");
        for (Filme filme : filmes) {
            System.out.println("Título: " + filme.getTitulo());
            System.out.println("Diretor: " + filme.getDiretor());
            System.out.println("Duração: " + filme.getDuracaoMinutos() + " minutos");
            System.out.println("Ano de Lançamento: " + filme.getAnoLancamento());
            System.out.println("Gênero: " + filme.getGenero());
            System.out.println("Sinopse: " + filme.getSinopse());
            System.out.println("Disponível para Assistir: " + (filme.getDisponivelParaAssistir() == 1 ? "Sim" : "Não"));
            System.out.println("--------------");
        }
    }

    private static void manipularDadosCliente(Scanner scanner, ClienteService clienteService) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║           Menu do Cliente           ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ 1. Atualizar Dados do Cliente       ║");
        System.out.println("║ 2. Deletar Cliente                  ║");
        System.out.println("║ 3. Visualizar Dados do Cliente      ║");
        System.out.println("║ 4. Voltar ao Menu Principal         ║");
        System.out.println("╚═════════════════════════════════════╝");

        int opcaoCliente = obterEscolhaValida(scanner);

        switch (opcaoCliente) {
            case 1:
                clienteService.atualizarCliente();
                break;
            case 2:
                clienteService.deletarCliente();
                break;
            case 3:
                clienteService.visualizarDadosCliente();
                break;
            case 4:
                System.out.println("╔══════════════════════════════════╗");
                System.out.println("║ Voltando ao Menu Principal.      ║");
                System.out.println("╚══════════════════════════════════╝");
                break;
            default:
                System.out.println("╔══════════════════════════════════╗");
                System.out.println("║ Opção inválida. Tente novamente  ║");
                System.out.println("╚══════════════════════════════════╝");
        }
    }

    private static void exibirDadosFuncionario(Funcionario funcionario) {
        System.out.println("\nDados do Funcionário:");
        System.out.println("Nome: " + funcionario.getName());
        System.out.println("Idade: " + funcionario.getAge());
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println("Email: " + funcionario.getEmail());
        System.out.println("Telefone: " + funcionario.getPhone());
        System.out.println("Username: " + funcionario.getUsername());
        System.out.println("Cargo: " + funcionario.getCargo());
    }
}
