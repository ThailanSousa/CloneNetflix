package com.cloneflix.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private int age;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;

    public enum Cargo {
        JUNIOR, AUX_PRODUCAO, ADM
    }

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    // Construtor vazio para JPA
    public Funcionario() {
    }

    public Funcionario(String username, String password, String name, int age, String cpf, String email, String phone,
            Cargo cargo) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.cargo = cargo;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", username=" + username + ", name=" + name + ", age=" + age + ", cpf=" + cpf
                + ", email=" + email + ", phone=" + phone + ", cargo=" + cargo + "]";
    }
}
