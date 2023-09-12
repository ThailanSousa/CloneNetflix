package main.java.repositorio;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import util.ConnectionFactory;
import util.ConnectionSingleton;

import main.java.model.Interface.IClienteMSQL;
import main.java.model.entities.Cliente;

public class ClienteRepositorio implements IClienteMSQL {
  private Connection conn;
  public boolean cadastrarCliente(Cliente cliente){
    try{
        String sql ="INSERT INTO  cliente"
        +"(`name`,`agedate`,`cpf`,`email`,`password`,`phone`,`dataDeCadatros`,`tipoDeCliente`)"
        +"VALUES(?,?,?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,cliente.getName());
        ps.setInt(2, cliente.getAge());
        ps.setString(3,cliente.getCpf());
        ps.setString(4,cliente.getEmail());
        ps.setString(5,null);
        ps.setString(6,cliente.getPhone());
        ps.setString(7, cliente.getDataDeCadastro());
        ps.setString(0, cliente.getTipoDeCliente());
        System.out.println("Cliente Cadastrado com SUCESSO!");
        return true;
      } catch (Exception e){
        System.out.println("Erro" + e);
        return false;
      }
  }
}
