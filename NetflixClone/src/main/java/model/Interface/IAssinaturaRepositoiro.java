package main.java.model.Interface;

import java.util.ArrayList;

import main.java.model.entities.Assinatura;

public interface IAssinaturaRepositoiro {

    public boolean salvarAssinatura(Assinatura assinatura);

    public ArrayList<Assinatura> listarAssinatura();

    public boolean deletarAssinatura(String nomeAssinante);

    public boolean alterarAssinatura (Assinatura assinatura);

    

    
}
