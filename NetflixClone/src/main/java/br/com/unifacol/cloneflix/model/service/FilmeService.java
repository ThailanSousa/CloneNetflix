package br.com.unifacol.cloneflix.model.service;

import java.sql.SQLException;
import java.util.Scanner;


import br.com.unifacol.cloneflix.model.entities.Filme;
import br.com.unifacol.cloneflix.model.repositorio.FilmeRepositorio;

public class FilmeService {
  FilmeRepositorio filmeRepo = new FilmeRepositorio();


  public boolean cadastarFilme() {

    Scanner inputCad = new Scanner(System.in);

    Filme filme = new Filme(null, null, 0, 0, null, null, 0);

    System.out.print("Titulo");
    filme.setTitulo(inputCad.nextLine());
    System.out.print("Nome do Diretor");
    filme.setDiretor(inputCad.nextLine());
    System.out.println("DUração do FIlme em Minutos");
    filme.setDuracaoMinutos(inputCad.nextInt());
    System.out.println("Ano de Lançamento");
    filme.setAnoLancamento(inputCad.nextInt());
    System.out.println("Gênero do Filme");
    filme.setGenero(inputCad.nextLine());
    System.out.println("Sinopse");
    filme.setSinopse(inputCad.nextLine());
    System.out.println("Esta disponivel para assistir? \n 1 - Sim \n 2 -  Não");
    filme.setDisponivelParaAssistir(inputCad.nextInt());
    inputCad.close();
    System.out.println(filme);

    if(filme.getTitulo() != null && filme.getDiretor() != null){
      filmeRepo.cadastrarFilme(filme);
      return true;
    }else{
      System.out.println("Informações incompletas");
      return false;
    }
    }

  public boolean atualizarFilme() {
    try {
      Scanner inputUpdate = new Scanner(System.in);
      System.out.println("Digite o nome do Filme que deseja atualizar");
      String nomeToUpdate = inputUpdate.nextLine();

      Filme filmeToUpdate = filmeRepo.obterFilme(nomeToUpdate);

      if (filmeToUpdate != null) {
        System.out.println("Digite os novos dados do cliente:");

        System.out.println("Digite o novo titulo:");
        filmeToUpdate.setTitulo(inputUpdate.nextLine());

        System.out.println("Digite o nome do Diretor:");
        filmeToUpdate.setDiretor(inputUpdate.nextLine());

        System.out.println("O filme esta disponivel para assistir? \n 1- Sim \n2- Não");
        filmeToUpdate.setDisponivelParaAssistir(inputUpdate.nextInt());
        inputUpdate.nextLine(); // Consume quebra de linha

        System.out.println("Digite o novo Genero:");
        filmeToUpdate.setGenero(inputUpdate.nextLine());

        System.out.println("Digite a nova duração do filme em minutos:");
        filmeToUpdate.setDuracaoMinutos(inputUpdate.nextInt());
        inputUpdate.nextLine(); // Consume quebra de linha

        System.out.println("Informe o no ano de lançamento");
        filmeToUpdate.setAnoLancamento(inputUpdate.nextInt());
          inputUpdate.nextLine();

          System.out.println("Informe a Sinopse do Filme");
          filmeToUpdate.setSinopse(inputUpdate.nextLine());

        if (filmeToUpdate != null) {
          filmeRepo.atualizarFilme(filmeToUpdate);
        }
      } else {

      }

      inputUpdate.close();

      return true;

    } catch (Exception e) {
      return false;
    }

  }

  public boolean removerFilme() {
    try {
      Scanner ScDelete = new Scanner(System.in);
      System.out.println("Digite o nom do Filme que irá remover");
      String titleToRemove = ScDelete.nextLine();

      Filme filmeToRemove = filmeRepo.obterFilme(titleToRemove);

      if (filmeToRemove != null) {
        filmeRepo.removerFilmeNome(titleToRemove);
      } else {

      }

      ScDelete.close();
      return true;

    } catch (Exception e) {
      System.out.println("Erro ao remover cliente: " + e.getMessage());
      return false;
    }
  }

  public boolean listarPorGenero() throws SQLException {
    for (Filme filme : this.filmeRepo.listarFilmesPorGenero()) {
      System.out.println(filme);
    }
    return false;
  }

}
