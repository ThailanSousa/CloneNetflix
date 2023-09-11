package main.java.model.Interface;

import java.util.ArrayList;

import main.java.model.entities.Pessoa;

public interface IPessoaRepositorio {

    public boolean salvarPessoa(Pessoa pessoa);

    public ArrayList<Pessoa> listarPessoa();

    public boolean deleletarPessao(String cpf);

    public boolean alterarPessoa(Pessoa pessoa);

    
}
