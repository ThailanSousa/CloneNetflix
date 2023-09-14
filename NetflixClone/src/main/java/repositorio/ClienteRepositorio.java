package main.java.repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import main.java.model.Interface.IClienteMSQL;
import main.java.model.entities.Cliente;
import util.ConnectionSingleton;

public class ClienteRepositorio implements IClienteMSQL {

  private Connection conn = null;
  public ClienteRepositorio()  {
		try {
			this.conn = ConnectionSingleton.getInstance().conexao;			 
		} catch (Exception e) {}
		}

  public boolean cadastrarCliente(Cliente cliente){
    try{
        String sql ="INSERT INTO  cliente"
        +"(`name`,`agedate`,`cpf`,`email`,`password`,`phone`,`dataDeCadatros`)"
        +"VALUES(?,?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,cliente.getName());
        ps.setInt(2, cliente.getAge());
        ps.setString(3,cliente.getCpf());
        ps.setString(4,cliente.getEmail());
        ps.setString(5,cliente.getPassword());//senha
        ps.setString(6,cliente.getPhone());        
        ps.setString(7, cliente.getDataDeCadastro());
        System.out.println("aqui");
        ps.executeUpdate();
        System.out.println("Cliente Cadastrado com SUCESSO!");

        return true;
      } catch (Exception e){
        System.out.println("Erro" + e);
        return false;
      }
  }
}
