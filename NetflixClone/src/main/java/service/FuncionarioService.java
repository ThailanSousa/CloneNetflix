package main.java.service;

import java.util.Scanner;

import main.java.model.entities.Cliente;
import main.java.repositorio.ClienteRepositorio;

public class FuncionarioService {
  
  ClienteRepositorio clienteService = new ClienteRepositorio();

  public boolean cadastarCliente() {

    Scanner inputCad = new Scanner(System.in);

    Cliente cliente = new Cliente(null, null);

    System.out.println("Digite seu nome:");
    cliente.setName(inputCad.nextLine());
    System.out.println("digite sua idade: ");
    cliente.setAge(inputCad.nextInt());
    inputCad.nextLine(); // consume quebra de linha
    System.out.println("Digite seu CPF:");
    cliente.setCpf(inputCad.nextLine());
    System.out.println("Digite seu telefone: ");
    cliente.setPhone(inputCad.nextLine());
    System.out.println("Digite seu E-mail: ");
    cliente.setEmail(inputCad.nextLine());
    System.out.println("Digite sua senha: ");
    cliente.setPassword(inputCad.nextLine());
    System.out.println("Data de cadastro (no formato AAAA-MM-DD):");
    cliente.setDataDeCadastro(inputCad.nextLine());

    ClienteRepositorio clienteRepo = new ClienteRepositorio();

    inputCad.close();
    System.out.println(cliente);

    if (cliente.getName().isEmpty() && cliente.getCpf().isEmpty() && cliente.getCpf().length() == 11 &&
        cliente.getEmail().contentEquals("@")) {
      System.out.println(cliente);
      throw new IllegalArgumentException("Verifique os dados inseridos");
    } else {
      System.out.println("Cliente Cadastrado Service");
      clienteRepo.cadastrarCliente(cliente);
      return true;
    }
  }

}
