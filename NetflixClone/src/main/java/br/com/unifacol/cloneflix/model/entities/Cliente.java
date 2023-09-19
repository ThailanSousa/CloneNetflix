package br.com.unifacol.cloneflix.model.entities;

import java.sql.Timestamp;
import java.util.Date;

public class Cliente extends Pessoa {
    private String password;
    private Timestamp dataDeCadastro;

    public Cliente(String name, String cpf) {
        super(name, cpf);
        this.dataDeCadastro = new Timestamp(new Date().getTime()); // Define a data de cadastro automaticamente
    }

    public Cliente(String name, int age, String cpf, String email, String phone, String password) {
        super(name, age, cpf, email, phone);
        this.dataDeCadastro = new Timestamp(new Date().getTime()); // Define a data de cadastro automaticamente
        this.password = password;
    }

    public Timestamp getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Timestamp dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
