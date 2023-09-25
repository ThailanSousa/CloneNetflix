package br.com.unifacol.cloneflix.model.Interface;


import br.com.unifacol.cloneflix.model.entities.Assinatura;

public interface IAssinaturaMSQL {

    public boolean cadastrarAssinatura(Assinatura assinatura);

    public boolean atualizarAssinatura(Assinatura assinatura);

    public Assinatura obterAssinaturaPorNomeAssinatura(String nomeAssinatura);

    public void removerAssinatura(String nome);

}
