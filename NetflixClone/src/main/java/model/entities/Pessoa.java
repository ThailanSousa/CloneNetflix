package main.java.model.entities;

public class Pessoa {

        private String name;
        private int age;
        private String cpf;
        private String email;
        private String senha;
        private String phone;
        private int adm;

        public Pessoa(){}

        public Pessoa(String name, int age, String cpf, String email,String senha, String phone, int adm) {
            this.name = name;
            this.age = age;
            this.cpf = cpf;
            this.email = email;
            this.phone = null;
            this.adm = adm;
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

        public String getSenha(){
            return senha;
        }

        public void setSenha(String senha){

            this.senha = senha;
            
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int isAdm() {
            return adm;
        }

        public void setAdm(int adm) {
            this.adm = adm;
        }

        // METODO DE ALTERAÇÃO DO OBJETO PARA STRING
        public String toString() {
            return ("O Nome  informado foi: " + this.name + "\nA Idade informada foi: " + this.age
                    + "\nO CPF informado foi:  " + this.cpf + "\nO E-mail informado foi: " + this.email
                    + "\nO telefone informado foi: " + this.phone + "\nO Nivel de prioridade: " + this.adm);
        }
    
        

    }


