package com.cloneflix.service;

import java.util.List;
import java.util.Scanner;

import com.cloneflix.model.entities.Filme;
import com.cloneflix.repository.FilmeRepository;

public class FilmeService {

    private FilmeRepository filmeRepository;

    public FilmeService() {
        this.filmeRepository = new FilmeRepository();
    }

    public boolean cadastrarFilme() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao cadastro de filmes!");
        System.out.println("Insira as informações do filme:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Diretor: ");
        String diretor = scanner.nextLine();
        System.out.print("Duração (em minutos): ");
        int duracaoMinutos = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Ano de Lançamento: ");
        int anoLancamento = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Sinopse: ");
        String sinopse = scanner.nextLine();
        System.out.print("Disponível para Assistir (1 para Sim, 0 para Não): ");
        int disponivelParaAssistir = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Link do Filme: ");
        String link = scanner.nextLine();

        Filme novoFilme = new Filme(titulo, diretor, duracaoMinutos, anoLancamento, genero, sinopse,
                disponivelParaAssistir, link);

        boolean cadastrado = filmeRepository.cadastrarFilme(novoFilme);

        if (cadastrado) {
            System.out.println("Filme cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar o filme.");
        }
        return cadastrado;
    }

    public Filme consultarFilmePorTitulo(String tituloEscolhido) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();

        return filmeRepository.consultarFilmePorTitulo(titulo);
    }

    public boolean atualizarFilme() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();

        Filme filme = filmeRepository.consultarFilmePorTitulo(titulo);

        if (filme != null) {
            System.out.print("Novo título: ");
            String novoTitulo = scanner.nextLine();
            System.out.print("Novo diretor: ");
            String novoDiretor = scanner.nextLine();
            System.out.print("Nova duração (em minutos): ");
            int novaDuracao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            System.out.print("Novo ano de lançamento: ");
            int novoAno = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            System.out.print("Novo gênero: ");
            String novoGenero = scanner.nextLine();
            System.out.print("Nova sinopse: ");
            String novaSinopse = scanner.nextLine();
            System.out.print("Disponível para Assistir (1 para Sim, 0 para Não): ");
            int novoDisponivel = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            System.out.print("Novo link: ");
            String novoLink = scanner.nextLine();

            filme.setTitulo(novoTitulo);
            filme.setDiretor(novoDiretor);
            filme.setDuracaoMinutos(novaDuracao);
            filme.setAnoLancamento(novoAno);
            filme.setGenero(novoGenero);
            filme.setSinopse(novaSinopse);
            filme.setDisponivelParaAssistir(novoDisponivel);
            filme.setLink(novoLink);

            return filmeRepository.atualizarFilme(filme);
        } else {
            System.out.println("Filme não encontrado.");
            return false;
        }
    }

    public boolean deletarFilmePorTitulo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();

        return filmeRepository.deletarFilmePorTitulo(titulo);
    }

    public void exibirDadosFilme(Filme filme) {
        if (filme != null) {
            System.out.println("Dados do Filme:");
            System.out.println("Título: " + filme.getTitulo());
            System.out.println("Diretor: " + filme.getDiretor());
            System.out.println("Duração (minutos): " + filme.getDuracaoMinutos());
            System.out.println("Ano de Lançamento: " + filme.getAnoLancamento());
            System.out.println("Gênero: " + filme.getGenero());
            System.out.println("Sinopse: " + filme.getSinopse());
            System.out.println("Disponível para Assistir: " + (filme.getDisponivelParaAssistir() == 1 ? "Sim" : "Não"));
            System.out.println("Link: " + filme.getLink());
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

   // ...
// ...

public List<Filme> exibirFilmesDisponiveis() {
    List<Filme> filmesDisponiveis = filmeRepository.listarFilmesDisponiveis();

    if (!filmesDisponiveis.isEmpty()) {
        System.out.println("Filmes Disponíveis para Assistir:");
        for (Filme filme : filmesDisponiveis) {
            exibirDadosFilmeFormatado(filme);
            System.out.println("---------------");
        }
    } else {
        System.out.println("Nenhum filme disponível para assistir no momento.");
    }
    return filmesDisponiveis;
}

// ...

private void exibirDadosFilmeFormatado(Filme filme) {
    System.out.println("ID: " + filme.getIdFilme());
    System.out.println("Título: " + filme.getTitulo());
    System.out.println("Diretor: " + filme.getDiretor());
    System.out.println("Duração: " + filme.getDuracaoMinutos() + " minutos");
    System.out.println("Ano de Lançamento: " + filme.getAnoLancamento());
    System.out.println("Gênero: " + filme.getGenero());
    System.out.println("Sinopse: " + filme.getSinopse());
    System.out.println("Disponível para Assistir: " + (filme.getDisponivelParaAssistir() == 1 ? "Sim" : "Não"));
    System.out.println("---------------");
}


public void escolherFilmeParaAssistir() {
    Scanner scanner = new Scanner(System.in);

    exibirFilmesDisponiveis(); // Mostra os filmes disponíveis

    System.out.print("Digite o título do filme que você deseja assistir (ou 0 para voltar): ");
    String tituloEscolhido = scanner.nextLine();

    if (!tituloEscolhido.equals("0")) {
        Filme filmeEscolhido = filmeRepository.consultarFilmePorTitulo(tituloEscolhido);

        if (filmeEscolhido != null) {
            System.out.println("Você escolheu o filme para assistir:");
            exibirDadosFilme(filmeEscolhido);
        } else {
            System.out.println("Filme não encontrado.");
        }
    } else {
        System.out.println("Operação cancelada.");
    }
}

public List<Filme> listarTodosFilmes() {
    List<Filme> filmes = filmeRepository.listarTodosOsFilmes();

    if (filmes.isEmpty()) {
        System.out.println("Nenhum filme encontrado.");
    } else {
        System.out.println("Lista de Filmes:");
        for (Filme filme : filmes) {
            System.out.println("Título: " + filme.getTitulo() + ", Gênero: " + filme.getGenero() + ", Ano: " + filme.getAno());
        }
    }
    return filmes;
}

// ...


}