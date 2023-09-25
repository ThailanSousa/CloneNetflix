package br.com.unifacol.cloneflix.model.Interface;


import br.com.unifacol.cloneflix.model.entities.Funcionario;

public interface IFuncionarioMSQL {
  
  public boolean cadastrarFuncionario(Funcionario funcionario);

  public boolean atualizarFuncionario(Funcionario funcionario);

  public Funcionario obterFuncionarioCpf(String cpf);

  public void removerFuncionarioForCpf(String cpf);
}
