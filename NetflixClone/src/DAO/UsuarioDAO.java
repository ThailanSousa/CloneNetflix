package DAO;

import java.sql.PreparedStatement;

import conexao.Conexao;
import main.java.model.entities.Pessoa;

public class UsuarioDAO {

    public void cadastrarUsuario(Pessoa pessoa) {
        String sql = "INSERT INTO USUARIO(NOME, LOGIN, SENHA, EMAIL) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, pessoa.getName());
            ps.setString(2, pessoa.getEmail());
            ps.setString(3, pessoa.getCpf());
            ps.setString(4, pessoa.getSenha());
            ps.setString(5, pessoa.getPhone());
            ps.setLong(6, pessoa.getAge());

            ps.execute();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}