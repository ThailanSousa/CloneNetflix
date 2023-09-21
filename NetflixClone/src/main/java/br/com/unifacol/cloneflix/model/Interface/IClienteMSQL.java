package br.com.unifacol.cloneflix.model.Interface;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unifacol.cloneflix.model.entities.Cliente;

public interface IClienteMSQL {

  public boolean cadastrarCliente(Cliente Cliente);

  public void removerClienteForCpf(String cpf);

  public ArrayList<Cliente> listarTodos() throws SQLException;

  public Cliente listarPorCpf(String cpf);

}