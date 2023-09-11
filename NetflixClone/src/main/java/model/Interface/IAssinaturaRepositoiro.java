package main.java.model.Interface;

import java.util.ArrayList;

import main.java.model.entities.Assinatura;

public interface IAssinaturaRepositoiro {

    public boolean salvarAssinatura(Assinatura assinatura);

    public ArrayList<Assinatura> listaAssinatura();

    public boolean deletarAssinatura(String nomeAssinatura);

    public boolean alterarAssinatura (Assinatura assinatura);

    

    
}
