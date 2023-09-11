package main.java.model.Interface;

import java.util.ArrayList;

import main.java.model.entities.Filme;

public interface IFilmeRepositorio {

    public boolean salvarFilme(Filme filme);

    public ArrayList<Filme> listarFilme();

    public boolean  deletarFilme(String titulo);

    public boolean alterarFilme(Filme filme);
    
    
}
