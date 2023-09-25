package br.com.unifacol.cloneflix.model.service;

import java.util.Scanner;

import br.com.unifacol.cloneflix.enums.Message;
import br.com.unifacol.cloneflix.model.entities.Cliente;
import br.com.unifacol.cloneflix.model.entities.Filme;
import br.com.unifacol.cloneflix.model.repositorio.FilmeRepositorio;
import br.com.unifacol.cloneflix.model.repositorio.FuncionarioRepositorio;

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


    
 }
