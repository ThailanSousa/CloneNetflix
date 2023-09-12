package main.java.repositorio;

import java.sql.PreparedStatement;
import java.sql.Connection;


import main.java.model.Interface.IClienteMSQL;
import main.java.model.entities.Cliente;
import util.ConnectionSingleton;

public class ClienteRepositorio implements IClienteMSQL {

  private Connection conn = null;
  public ClienteRepositorio()  {
		try {
			this.conn = ConnectionSingleton.getInstance().conexao;			 
		} catch (Exception e) {}
			// TODO: handle exception
		}

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
        ps.setString(8, cliente.getTipoDeCliente());
        ps.executeUpdate();
        System.out.println("Cliente Cadastrado com SUCESSO!");

        return true;
      } catch (Exception e){
        System.out.println("Erro" + e);
        return false;
      }
  }
}
