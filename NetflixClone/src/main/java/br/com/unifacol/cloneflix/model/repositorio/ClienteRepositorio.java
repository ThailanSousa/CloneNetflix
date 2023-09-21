package br.com.unifacol.cloneflix.model.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unifacol.cloneflix.model.Interface.IClienteMSQL;
import br.com.unifacol.cloneflix.model.entities.Cliente;
import br.com.unifacol.cloneflix.util.ConnectionSingleton;
import br.com.unifacol.cloneflix.enums.Message;

public class ClienteRepositorio implements IClienteMSQL {

  private Connection conn;

  public ClienteRepositorio() {
    try {
      this.conn = ConnectionSingleton.getInstance().conexao;
    } catch (Exception e) {
      System.out.println("cliente repoitorio" + e);
      e.printStackTrace();
    }
  }

  public boolean cadastrarCliente(Cliente cliente) {
    try {
      String sql = "INSERT INTO cliente " +
          "(`name`,`agedate`,`cpf`,`email`,`password`,`phone`,`dataDeCadatros`)" +
          "VALUES(?,?,?,?,?,?,NOW())";

<<<<<<< HEAD
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, cliente.getName());
      ps.setInt(2, cliente.getAge());
      ps.setString(3, cliente.getCpf());
      ps.setString(4, cliente.getEmail());
      ps.setString(5, cliente.getPassword());
      ps.setString(6, cliente.getPhone());

      ps.executeUpdate();
      System.out.println("Cliente Cadastrado Repositorio");
=======
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getName());
        ps.setInt(2, cliente.getAge());
        ps.setString(3, cliente.getCpf());
        ps.setString(4, cliente.getEmail());
        ps.setString(5, cliente.getPassword());
        ps.setString(6, cliente.getPhone()); 

        ps.executeUpdate();
        System.out.println(Message.SUCESSO);
>>>>>>> 90819d950cc95ab337049802da4076fa13fe3d28

      return true;
    } catch (SQLException e) {
      System.out.println("Erro: " + e);
      return false;
    }
<<<<<<< HEAD
  }
=======
}
>>>>>>> 90819d950cc95ab337049802da4076fa13fe3d28

  public boolean atualizarCliente(Cliente cliente) {
    try {
      String sql = "UPDATE cliente " +
          "SET `name`= ?, `agedate` = ?, `email` = ?, `phone` = ? " +
          "WHERE `cpf` = ?";

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, cliente.getName());
      ps.setInt(2, cliente.getAge());
      ps.setString(3, cliente.getEmail());
      ps.setString(4, cliente.getPhone());
      ps.setString(5, cliente.getCpf());

      int rowsUpdated = ps.executeUpdate();

      if (rowsUpdated > 0) {
        System.out.println(Message.ALTERACAO);
        return true;
      } else {
        System.out.println("Nenhum cliente foi atualizado. Verifique o CPF.");
        return false;
      }
    } catch (Exception e) {
      System.out.println("Erro: " + e);
      return false;
    }
  }

  public Cliente obterClientePorCPF(String cpf) {

    try {
      String sql = "SELECT * FROM cliente WHERE `cpf` = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, cpf);

      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        Cliente cliente = new Cliente(null, null);
        cliente.setName(rs.getString("name"));
        cliente.setAge(rs.getInt("agedate"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setEmail(rs.getString("email"));
        cliente.setPhone(rs.getString("phone"));
        return cliente;
      } else {
        System.out.println(Message.INVALIDO + cpf);
        return null;
      }
    } catch (Exception e) {
      System.out.println("Erro: " + e);
      return null;
    }
  }

<<<<<<< HEAD
  public void removerClienteForCpf(String cpf) {
    try {
      String sql = "DELETE FROM cliente WHERE `cpf` = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, cpf);

      int rowsDeleted = ps.executeUpdate();

      if (rowsDeleted > 0) {
        System.out.println("Cliente com CPF " + cpf + " removido com sucesso!");
      } else {
        System.out.println("Nenhum cliente foi removido. Verifique o CPF.");
      }
    } catch (SQLException e) {
      System.out.println("Erro: " + e);
    }
  }

  @Override
  public ArrayList<Cliente> listarTodos() throws SQLException {

    String sql = "SELECT * FROM cliente;";
    PreparedStatement ps = conn.prepareStatement(sql);

    ResultSet rs = ps.executeQuery();

    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    while (rs.next()) {

     Cliente cliente = new Cliente(null, null);
        cliente.setName(rs.getString("name"));
        cliente.setAge(rs.getInt("agedate"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setEmail(rs.getString("email"));
        cliente.setPhone(rs.getString("phone"));
        
        
      
      // e.setTitular(rs.getBoolean("isTitular"));

      clientes.add(cliente);

    }
    return clientes;

    
  }

  @Override
  public Cliente listarPorCpf(String cpf) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listarPorCpf'");
  }

 

=======
>>>>>>> 90819d950cc95ab337049802da4076fa13fe3d28
}
