package br.com.unifacol.cloneflix.model.service;

import java.util.Scanner;

import br.com.unifacol.cloneflix.model.entities.Cliente;
import br.com.unifacol.cloneflix.model.repositorio.ClienteRepositorio;

public class ClienteService {
  ClienteRepositorio clienteService = new ClienteRepositorio();
  ClienteRepositorio clienteRepo = new ClienteRepositorio();

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

    

    inputCad.close();
    System.out.println(cliente);

    if (!cliente.getName().isEmpty() &&
      !cliente.getCpf().isEmpty() &&
      cliente.getCpf().length() == 11 &&
      cliente.getEmail().contains("@")) {
      System.out.println(cliente);
      System.out.println("Cliente Cadastrado Service");
      clienteRepo.cadastrarCliente(cliente);
      return true;
    } else {
      System.out.println("Verifique os dados inseridos");
      return false;
    }
  }

}
