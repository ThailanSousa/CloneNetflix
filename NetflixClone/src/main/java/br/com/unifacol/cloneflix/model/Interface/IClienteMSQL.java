package br.com.unifacol.cloneflix.model.Interface;

import br.com.unifacol.cloneflix.model.entities.Cliente;

public interface IClienteMSQL{

  public boolean cadastrarCliente(Cliente Cliente)  ;
  
  public void removerClienteForCpf(String cpf) ; 
  
}