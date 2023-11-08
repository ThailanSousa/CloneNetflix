package br.com.unifacol.cloneflix.model.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import java.sql.Timestamp;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {
    @Id
    @Column( name= "id")
	private int idCliente;
    private String password;
    private Timestamp dataDeCadastro;
    

    public Cliente(String name, String cpf) {
        super(name, cpf);
    }

    public Cliente(String name, int age, String cpf, String email, String phone, String password) {
        super(name, age, cpf, email, phone);
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
