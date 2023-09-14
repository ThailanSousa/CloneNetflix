package main.java.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;

import main.java.model.entities.Assinatura;
import util.ConnectionSingleton;

public class AssinaturaRepositorio {

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

            System.out.println("Assinatura cadastrada com SUCESSO!");
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        }
    }
}
