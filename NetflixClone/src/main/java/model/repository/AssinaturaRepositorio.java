package main.java.model.repository;

import java.util.ArrayList;

import main.java.model.Interface.IAssinaturaRepositoiro;
import main.java.model.entities.Assinatura;

public class AssinaturaRepositorio implements IAssinaturaRepositoiro {
    
    public ArrayList<Assinatura> listaAssinaturas = new ArrayList<Assinatura>();


    @Override
    public boolean alterarAssinatura(Assinatura assinatura) {
        
        /*for (int cont = 0; cont < listaAssinaturas.size(); cont++){

             Assinatura assinatura = listaAssinaturas.get(cont);

            if (assinatura != null && Assinatura.getNomeAssinante.equal(getNomeAssinante)){

            }
        }*/


        return true;
    }

    @Override
    public boolean deletarAssinatura(String nomeAssinante) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<Assinatura> listaAssinatura() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override

    public boolean salvarAssinatura(Assinatura assinatura) {
        return false;
    }

}
