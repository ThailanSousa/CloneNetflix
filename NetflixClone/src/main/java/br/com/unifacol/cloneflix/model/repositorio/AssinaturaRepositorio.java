package br.com.unifacol.cloneflix.model.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.unifacol.cloneflix.model.Interface.IAssinaturaMSQL;
import br.com.unifacol.cloneflix.model.entities.Assinatura;
import br.com.unifacol.cloneflix.model.enums.Message;
import br.com.unifacol.cloneflix.util.ConnectionSingleton;

public class AssinaturaRepositorio  {

  private Connection conn = null;

  public AssinaturaRepositorio() {
    try {
      this.conn = ConnectionSingleton.getInstance().conexao;
    } catch (Exception e) {
      // Lidar com exceção, se necessário
    }
  }

  public boolean cadastrarAssinatura(Assinatura assinatura) {
    try {
      String sql = "INSERT INTO assinatura" +
          "(`nomeAssinatura`, `precoMensal`, `duracaoMeses`, `ativa`)" +
          "VALUES (?, ?, ?, ?)";

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, assinatura.getNomeAssinatura());
      ps.setDouble(2, assinatura.getPrecoMensal());
      ps.setInt(3, assinatura.getDuracaoMeses());
      ps.setBoolean(4, assinatura.isAtiva());

      ps.executeUpdate();

      System.out.println(Message.SUCESSO);
      return true;
    } catch (Exception e) {
      System.out.println("Erro: " + e);
      return false;
    }
  }

  public boolean atualizarAssinatura(Assinatura assinatura) {
    try {
      String sql = "UPDATE assinatura " +
          "SET `nomeAssinatura` = ?, `precoMensal` = ?, `duracaoMeses` = ?, `ativa` = ? " +
          "WHERE `cpf` = ?";

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, assinatura.getNomeAssinatura());
      ps.setDouble(2, assinatura.getPrecoMensal());
      ps.setInt(3, assinatura.getDuracaoMeses());
      ps.setBoolean(4, assinatura.isAtiva());

      int rowsUpdated = ps.executeUpdate();

      if (rowsUpdated > 0) {
        System.out.println(Message.SUCESSO);
        return true;
      } else {
        System.out.println("Nenhuma Assinatura foi atualizado. Verifique o nome da assinatura.");
        return false;
      }
    } catch (Exception e) {
      System.out.println("Erro: " + e);
      return false;
    }
  }

  public Assinatura obterAssinaturaPorNomeAssinatura(String nomeAssinatura) {
    try {
      String sql = "SELECT * FROM assinatura WHERE `nomeAssinatura` = ? ";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, nomeAssinatura);

      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        Assinatura assinatura = new Assinatura();
        assinatura.setNomeAssinatura(rs.getString("nomeAssinatura"));
        assinatura.setPrecoMensal(rs.getDouble("precoMensal"));
        assinatura.setDuracaoMeses(rs.getInt("duracaoMeses"));
        assinatura.setAtiva(rs.getBoolean("ativa"));
        return assinatura;
      } else {
        System.out.println("Assinatura não encontrado para o nome: " + nomeAssinatura);
        return null;
      }
    } catch (Exception e) {
      System.out.println("Erro: " + e);
      return null;
    }
  }

  public void removerAssinatura(String nome) {
    try {
      String sql = "DELETE FROM assinatura WHERE `nomeAssinatura` = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, nome);

      int rowsDeleted = ps.executeUpdate();

      if (rowsDeleted > 0) {
        System.out.println("Assinatura" + nome + "Foi removido com Sucesso");
      } else {
        System.out.println("Nenhuma Assinatura foi encontrado");
      }
    } catch (SQLException e) {
      System.out.println("Erro: " + e);
    }
  }
}
