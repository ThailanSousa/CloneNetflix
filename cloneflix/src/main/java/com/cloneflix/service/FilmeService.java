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
        Scanner scannerFilme =new Scanner(System.in);
        System.out.println("Bem-vindo ao cadastro de filmes!");
        
        System.out.print("Título do Filme: ");
        String titulo = scannerFilme.nextLine();

        System.out.print("Diretor: ");
        String diretor = scannerFilme.nextLine();

        System.out.print("Duração (em minutos): ");
        int duracaoMinutos = scannerFilme.nextInt();
        scannerFilme.nextLine(); // Consumir a quebra de linha

        System.out.print("Ano de Lançamento: ");
        int anoLancamento = scannerFilme.nextInt();
        scannerFilme.nextLine(); // Consumir a quebra de linha

        System.out.print("Gênero: ");
        String genero = scannerFilme.nextLine();

        System.out.print("Sinopse: ");
        String sinopse = scannerFilme.nextLine();

        System.out.print("Disponível para assistir (1 - Sim / 0 - Não): ");
        int disponivelParaAssistir = scannerFilme.nextInt();
        scannerFilme.nextLine(); // Consumir a quebra de linha

        if (titulo.isEmpty() || diretor.isEmpty() || genero.isEmpty() || sinopse.isEmpty()) {
            System.out.println("Campos obrigatórios não preenchidos. Filme não cadastrado.");
            return false;
        }

        Filme novoFilme = new Filme(titulo, diretor, duracaoMinutos, anoLancamento, genero, sinopse, disponivelParaAssistir);
        return filmeRepository.cadastrarFilme(novoFilme);
    }


    public void exibirFilmesDisponiveis() {
        List<Filme> filmesDisponiveis = filmeRepository.listarFilmesDisponiveis();
        System.out.println("Filmes Disponíveis para Assistir:");
        for (Filme filme : filmesDisponiveis) {
            System.out.println(filme);
        }
    }

    // ... outros métodos existentes
}
