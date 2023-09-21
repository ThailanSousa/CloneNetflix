package br.com.unifacol.cloneflix.model.Interface;


import br.com.unifacol.cloneflix.model.entities.Funcionario;

public interface IFuncionarioMSQL {
  public boolean cadastrarFuncionario();

  public boolean atualizarFuncionario(Funcionario funcionario);
}
