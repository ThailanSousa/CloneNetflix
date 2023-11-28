package com.cloneflix.service;

import com.cloneflix.model.entities.Funcionario;
import com.cloneflix.repository.FuncionarioRepository;

public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService() {
        this.funcionarioRepository = new FuncionarioRepository();
    }

    public boolean cadastrarFuncionario(String username, String password, String name, int age, String cpf, String email, String phone, boolean administrador) {
        Funcionario novoFuncionario = new Funcionario(username, password, name, age, cpf, email, phone, administrador);
        return funcionarioRepository.cadastrarFuncionario(novoFuncionario);
    }

    public Funcionario consultarFuncionario(String cpf) {
        return funcionarioRepository.consultarFuncioanrioPorCpf(cpf);
    }

    public boolean atualizarFuncionario(String cpf, String newPassword, String newEmail, String newPhone) {
        Funcionario funcionario = consultarFuncionario(cpf);

        if (funcionario != null) {
            funcionario.setPassword(newPassword);
            funcionario.setEmail(newEmail);
            funcionario.setPhone(newPhone);
            return funcionarioRepository.atualizarFuncioanrio(funcionario);
        } else {
            System.out.println("Funcionário não encontrado.");
            return false;
        }
    }

    public boolean deletarFuncionario(String cpf) {
        return funcionarioRepository.deletarFuncionario(cpf);
    }
   
    public Funcionario autenticarFuncionario(String username, String password) {
        return funcionarioRepository.autenticarFuncionario(username, password);
    }
}
