package br.com.unifacol.cloneflix.model.service;

import java.util.Scanner;

import br.com.unifacol.cloneflix.model.Interface.IFuncionarioMSQL;
import br.com.unifacol.cloneflix.model.entities.Funcionario;
import br.com.unifacol.cloneflix.model.repositorio.FuncionarioRepositorio;

public class FuncionarioService implements IFuncionarioMSQL {
  
  FuncionarioRepositorio funcionarioService = new FuncionarioRepositorio();

  public boolean cadastrarFuncionario() {

    Scanner inputCad = new Scanner(System.in);

    Funcionario funcionario = new Funcionario(null, 0, null, null, null, 0, 0);

    System.out.println("Digite seu nome:");
    funcionario.setName(inputCad.nextLine());
    System.out.println("digite sua idade: ");
    funcionario.setAge(inputCad.nextInt());
    inputCad.nextLine(); // consume quebra de linha
    System.out.println("Digite seu CPF:");
    funcionario.setCpf(inputCad.nextLine());
    System.out.println("Digite seu E-mail: ");
    funcionario.setEmail(inputCad.nextLine());
    System.out.println("Digite seu telefone: ");
    funcionario.setPhone(inputCad.nextLine());
    
    FuncionarioRepositorio funcionarioRepo = new FuncionarioRepositorio();

    inputCad.close();
    System.out.println(funcionario);

    if (funcionario.getName().isEmpty() && funcionario.getCpf().isEmpty() && funcionario.getCpf().length() == 11 &&
        funcionario.getEmail().contentEquals("@")) {
      System.out.println(funcionario);
      throw new IllegalArgumentException("Verifique os dados inseridos");
    } else {
      System.out.println("Cliente Cadastrado Service");
      funcionarioRepo.cadastrarFuncionario(funcionario);
      return true;
    }
  }

  public boolean atualizarFuncionario(Funcionario funcionario){
    
    try {
      
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
