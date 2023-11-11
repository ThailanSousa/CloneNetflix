package br.com.unifacol.cloneflix.model.Interface;

import java.util.List;
import java.util.Stack;

import br.com.unifacol.cloneflix.model.entities.Cliente;

public interface IClienteMSQL {



  public boolean cadastrarCliente(Cliente Cliente);

  public void removerClienteForCpf(String cpf);

  public  Stack<Cliente> listarClientes();

  public List<Cliente> listarPorCpf(String cpf);
}