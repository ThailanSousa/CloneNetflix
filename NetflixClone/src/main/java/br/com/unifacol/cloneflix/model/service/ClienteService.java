package br.com.unifacol.cloneflix.model.service;

import java.util.Scanner;

import br.com.unifacol.cloneflix.enums.Message;
import br.com.unifacol.cloneflix.model.entities.Cliente;
import br.com.unifacol.cloneflix.model.repositorio.ClienteRepositorio;

public class ClienteService {
  ClienteRepositorio clienteRepo = new ClienteRepositorio();

  public boolean cadastarCliente() {

    Scanner inputCad = new Scanner(System.in);

    Cliente cliente = new Cliente(null, null);

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

      clienteRepo.cadastrarCliente(cliente);
      return true;
    } else {
      System.out.println("Verifique os dados inseridos");
      return false;
    }
  }

  public boolean atualizarCliente() {
    try {
      Scanner inputUpdate = new Scanner(System.in);
      System.out.println("Digite o CPF do cliente que deseja atualizar:");
      String cpfToUpdate = inputUpdate.nextLine();

      Cliente clienteToUpdate = clienteRepo.obterClientePorCPF(cpfToUpdate);

      if (clienteToUpdate != null) {
        System.out.println("Digite os novos dados do cliente:");

        System.out.println("Digite o novo nome:");
        clienteToUpdate.setName(inputUpdate.nextLine());

        System.out.println("Digite a nova idade:");
        clienteToUpdate.setAge(inputUpdate.nextInt());
        inputUpdate.nextLine(); // Consume quebra de linha

        System.out.println("Digite o novo telefone:");
        clienteToUpdate.setPhone(inputUpdate.nextLine());

        System.out.println("Digite o novo E-mail:");
        clienteToUpdate.setEmail(inputUpdate.nextLine());

     
    

        if (clienteToUpdate != null) {
          clienteRepo.atualizarCliente(clienteToUpdate);
        }
      } else {
        System.out.println("Cliente com CPF " + cpfToUpdate + " não encontrado.");
      }

      inputUpdate.close();

      return true;

    } catch (Exception e) {
      return false;
    }

  }

}
