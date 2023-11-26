package com.cloneflix.model.entities;

import javax.persistence.Entity;
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

    private String username;
    private String password;
    private String name;
    private int age;
    private String cpf;
    private String email;
    private String phone;

    private boolean administrador;

    public Funcionario() {
    }

    public Funcionario(String username, String password, String name, int age, String cpf, String email, String phone,
            boolean administrador) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.administrador = administrador;
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

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", username=" + username + ", name=" + name + ", age=" + age + ", cpf=" + cpf +
                ", email=" + email + ", phone=" + phone + ", administrador=" + administrador + "]";
    }
}