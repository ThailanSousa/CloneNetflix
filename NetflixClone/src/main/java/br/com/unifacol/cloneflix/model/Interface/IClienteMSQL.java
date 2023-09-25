package br.com.unifacol.cloneflix.model.Interface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.unifacol.cloneflix.model.entities.Cliente;

public interface IClienteMSQL {

  public boolean cadastrarCliente(Cliente Cliente);

  public void removerClienteForCpf(String cpf);

  public ArrayList<Cliente> listarTodos() throws SQLException;

  public List<Cliente> listarPorCpf(String cpf)  throws SQLException;

}