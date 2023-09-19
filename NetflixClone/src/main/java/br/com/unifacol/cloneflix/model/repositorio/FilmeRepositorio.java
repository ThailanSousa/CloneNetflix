package br.com.unifacol.cloneflix.model.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.unifacol.cloneflix.model.Interface.IFilmeRepositorio;
import br.com.unifacol.cloneflix.model.entities.Filme;
import br.com.unifacol.cloneflix.util.ConnectionSingleton;

public class FilmeRepositorio implements IFilmeRepositorio {
  private Connection conect = null;

  public FilmeRepositorio() {
    try {
      this.conect = ConnectionSingleton.getInstance().conexao;
    } catch (Exception e) {
    }
    // TODO: handle exception
  }

  public boolean cadastrarFilme(Filme filme) {

    try {
      String sql = "INSERT INTO  filme"
          + "(`titulo`,`diretor`,`duracao`,`lancamento`,`genero`,`sinopse`,`disponivel`)"
          + "VALUES(?,?,?,?,?,?,?)";

      PreparedStatement ps = conect.prepareStatement(sql);
      ps.setString(1, filme.getTitulo());
      ps.setString(2, filme.getDiretor());
      ps.setInt(3, filme.getDuracaoMinutos());
      ps.setInt(4, filme.getAnoLancamento());
      ps.setString(5, filme.getGenero());
      ps.setString(6, filme.getSinopse());
      ps.setBoolean(7, filme.isDisponivelParaAssistir());
      ps.executeUpdate();
      System.out.println("Cliente Cadastrado com SUCESSO!");
      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

}
