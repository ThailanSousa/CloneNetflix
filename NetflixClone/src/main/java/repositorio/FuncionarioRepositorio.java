package main.java.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;

import main.java.model.entities.Funcionario;
import util.ConnectionSingleton;

public class FuncionarioRepositorio {
  

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

  public boolean cadastrarFuncionario(Funcionario funcionario){
    try {
      String sql = "INSERT INTO funcionario "+
      "('name','agedata','cpf','email','password','phone','profile','maticula')"+
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
      System.out.println("Funcionario Cadastrado no Repositorio");;

      return true;
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("Erro ao Cadastrar o funcionario");
      return false;
    }
    
  }

  public boolean atualizarFuncionario(Funcionario funcionario){
    try {
      

      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

}
