package br.com.unifacol.cloneflix.model.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.unifacol.cloneflix.model.Interface.IFilmeMSQL;
import br.com.unifacol.cloneflix.model.entities.Filme;
import br.com.unifacol.cloneflix.util.ConnectionSingleton;

public class FilmeRepositorio implements IFilmeMSQL {
  private Connection conn;

  public FilmeRepositorio() {
    try {
      this.conn = ConnectionSingleton.getInstance().conexao;
    } catch (Exception e) {
      System.out.println("erro: " + e);
    }
  
  }

  public boolean cadastrarFilme(Filme filme) {

    try {
      String sql = "INSERT INTO  filme"
          + "(`titulo`,`diretor`,`duracao`,`lancamento`,`genero`,`sinopse`,`disponivel`)"
          + "VALUES(?,?,?,?,?,?,?)";

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, filme.getTitulo());
      ps.setString(2, filme.getDiretor());
      ps.setInt(3, filme.getDuracaoMinutos());
      ps.setInt(4, filme.getAnoLancamento());
      ps.setString(5, filme.getGenero());
      ps.setString(6, filme.getSinopse());
      ps.setInt(7, filme.getDisponivelParaAssistir());
      ps.executeUpdate();
      System.out.println("Cliente Cadastrado com SUCESSO!");
      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

    public boolean atualizarFIlme(Filme filme) {
    try {
      String sql = "UPDATE filme " +
          "SET `titulo`= ?, `diretor` = ?, `duracaoMinutos` = ?, `anoLancamento` = ?, `genero` = ?, `sinopse` = ?, `disponivelParaAssistir` = ? " +
          "WHERE `titulo` = ?";

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, filme.getTitulo());
      ps.setString(2, filme.getDiretor());
      ps.setInt(3, filme.getDuracaoMinutos());
      ps.setInt(4, filme.getAnoLancamento());
      ps.setString(5,filme.getGenero());
      ps.setString(6,filme.getSinopse());
      ps.setInt(6, filme.getDisponivelParaAssistir() );
      

      int rowsUpdated = ps.executeUpdate();

      if (rowsUpdated > 0) {
        System.out.println("Cliente atualizado com sucesso!");
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

  public Filme obterFilme(String genero) {
    try {
      String sql = "SELECT * FROM filme WHERE `genero` = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, genero);

      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        Filme filme = new Filme(sql, sql, 0, 0, sql, sql, 0);
      ps.setString(1, filme.getTitulo());
      ps.setString(2, filme.getDiretor());
      ps.setInt(3, filme.getDuracaoMinutos());
      ps.setInt(4, filme.getAnoLancamento());
      ps.setString(5,filme.getGenero());
      ps.setString(6,filme.getSinopse());
      ps.setInt(6, filme.getDisponivelParaAssistir() );
        return filme;
      } else {
        System.out.println("Genero selecionado não existe: " + genero);
        return null;
      }
    } catch (Exception e) {
      System.out.println("Erro: " + e);
      return null;
    }
  }

}
