package br.com.unifacol.cloneflix.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.unifacol.cloneflix.model.entities.Cliente;
import br.com.unifacol.cloneflix.model.enums.Message;
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

      }

      inputUpdate.close();

      return true;

    } catch (Exception e) {
      return false;
    }

  }

  public boolean removerCliente() {
    try {
      Scanner ScDelete = new Scanner(System.in);
      System.out.println("Digite o CPF do cliente que deseja remover:");
      String cpfToRemove = ScDelete.nextLine();

      Cliente clienteToRemove = clienteRepo.obterClientePorCPF(cpfToRemove);

      if (clienteToRemove != null) {
        clienteRepo.removerClienteForCpf(cpfToRemove);
      } else {

      }

      ScDelete.close();
      return true;

    } catch (Exception e) {
      System.out.println("Erro ao remover cliente: " + e.getMessage());
      return false;
    }
  }

  public boolean listarTodos() throws SQLException {
    for (Cliente cliente : this.clienteRepo.listarTodos()) {
      System.out.println(cliente);
    }
    return false;
  }

  public boolean listarPorCpf(String cpf) throws SQLException {
    if (cpf == null) {
        System.out.println("CPF não pode ser nulo.");
        return false;
    }

    List<Cliente> clientes = this.clienteRepo.listarPorCpf(cpf);
    if (clientes.isEmpty()) {
        System.out.println("Nenhum cliente encontrado com o CPF: " + cpf);
        return false;
    }

    for (Cliente cliente : clientes) {
        System.out.println(cliente);
    }
    
    return true;
}

  
}
