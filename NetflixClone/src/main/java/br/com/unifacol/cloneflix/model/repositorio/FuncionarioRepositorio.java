package br.com.unifacol.cloneflix.model.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.unifacol.cloneflix.model.entities.Funcionario;
import br.com.unifacol.cloneflix.util.ConnectionSingleton;

public class FuncionarioRepositorio  {

  private Connection conn = null;

  public FuncionarioRepositorio() {
    try {
      this.conn = ConnectionSingleton.getInstance().conexao;
    } catch (Exception e) {
      // Trate a exceção de alguma forma apropriada, como registrar ou lançar
      // novamente.
      e.printStackTrace();
    }
  }

  public boolean cadastrarFuncionario(Funcionario funcionario) {
    try {
      String sql = "INSERT INTO funcionario " +
          "('name','agedata','cpf','email','password','phone','profile','maticula')" +
          "VALUES(?,?,?,?,?,?,?,?)";

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, funcionario.getName());
      ps.setInt(2, funcionario.getAge());
      ps.setString(3, funcionario.getCpf());
      ps.setString(4, funcionario.getEmail());
      ps.setString(5, funcionario.getPassword());// senha
      ps.setString(6, funcionario.getPhone());
      ps.setInt(7, funcionario.getTipoDeFuncionario());
      ps.setInt(8, funcionario.getMatricula());

      ps.executeUpdate();
      System.out.println("Funcionario Cadastrado no Repositorio");
      ;

      return true;
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("Erro ao Cadastrar o funcionario");
      return false;
    }

  }

  public boolean atualizarFuncionario(Funcionario funcionario) {
    try {

      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  public Funcionario obterFuncionarioCpf(String cpf) {
    try {
      String sql = "SELECT * FROM funcionario WHERE `cpf` = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, cpf);

      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        Funcionario funcionario = new Funcionario(sql, cpf, 0, 0, sql);
        funcionario.setName(rs.getString("name"));
        funcionario.setAge(rs.getInt("agedate"));
        funcionario.setCpf(rs.getString("cpf"));
        funcionario.setEmail(rs.getString("email"));
        funcionario.setPhone(rs.getString("phone"));
        return funcionario;
      } else {
        System.out.println("Cliente não encontrado para o CPF: " + cpf);
        return null;
      }
    } catch (Exception e) {
      System.out.println("Erro: " + e);
      return null;
    }
  }

  public void removerFuncionarioForCpf(String cpf) {
    try {
      String sql = "DELETE FROM funcionario WHERE `cpf` = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, cpf);

      int rowsDeleted = ps.executeUpdate();

      if (rowsDeleted > 0) {
        System.out.println("Funcionario com CPF " + cpf + " removido com sucesso!");
      } else {
        System.out.println("Nenhum funcionario foi removido. Verifique o CPF.");
      }
    } catch (SQLException e) {
      System.out.println("Erro: " + e);
    }
  }

}
