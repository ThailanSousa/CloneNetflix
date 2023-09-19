package br.com.unifacol.cloneflix.model.Interface;


import java.util.ArrayList;

import br.com.unifacol.cloneflix.model.entities.Assinatura;

public interface IAssinaturaMSQL {

    public boolean salvarAssinatura(Assinatura assinatura);

    public ArrayList<Assinatura> listaAssinatura();

    public boolean deletarAssinatura(String nomeAssinatura);

    public boolean alterarAssinatura (Assinatura assinatura);

    

    
}
