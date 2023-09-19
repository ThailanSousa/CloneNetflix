package br.com.unifacol.cloneflix.model.service;

import java.util.Scanner;

import br.com.unifacol.cloneflix.enums.Message;
import br.com.unifacol.cloneflix.model.entities.Cliente;
import br.com.unifacol.cloneflix.model.repositorio.ClienteRepositorio;

public class ClienteService {
  ClienteRepositorio clienteService = new ClienteRepositorio();
  ClienteRepositorio clienteRepo = new ClienteRepositorio();

  public boolean cadastarCliente() {

    Scanner inputCad = new Scanner(System.in);

    Cliente cliente = new Cliente(null, null);

    System.out.println("Sua data de cadastro é: " + cliente.getDataDeCadastro());
    System.out.print(Message.NAME.getDescricao());
    cliente.setName(inputCad.nextLine());
    System.out.print(Message.AGE.getDescricao());
    cliente.setAge(inputCad.nextInt());
    inputCad.nextLine(); // consumir quebra de linha
    System.out.print(Message.CPF.getDescricao());
    cliente.setCpf(inputCad.nextLine());
    System.out.print(Message.PHONE.getDescricao());
    cliente.setPhone(inputCad.nextLine());
    System.out.print(Message.EMAIL.getDescricao());
    cliente.setEmail(inputCad.nextLine());
    System.out.print(Message.PASSWORD.getDescricao());
    cliente.setPassword(inputCad.nextLine());

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
