package main.java.service;

import main.java.model.entities.Cliente;
import main.java.repositorio.ClienteRepositorio;

public class ClienteService {
  ClienteRepositorio clienteService = new ClienteRepositorio();
  

  public boolean cadastarCliente(Cliente cliente){
    if(cliente.getName().isEmpty()){
      throw new IllegalArgumentException("Nome do cliente não pode ser vazio");
    }else{
      clienteService.cadastrarCliente(cliente);
      System.out.println("Cliente Cadastrado com Sucesso!");
      return true;
        }
  }

}
