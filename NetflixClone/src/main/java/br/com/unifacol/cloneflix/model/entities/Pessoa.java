package br.com.unifacol.cloneflix.model.entities;


abstract class Pessoa {

        private String name;
        private int age;
        private String cpf;
        private String email;
        private String phone;


        public Pessoa(String name, String cpf){
            this.name = name;
            this.cpf = cpf;
        }

        public Pessoa(String name, int age, String cpf, String email, String phone ) {
            this.name = name;
            this.age = age;
            this.cpf = cpf;
            this.email = email;
            this.phone = null;
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

        // METODO DE ALTERAÇÃO DO OBJETO PARA STRING
        public String toString() {
            return ("O Nome  informado foi: " + this.name + "\nA Idade informada foi: " + this.age
                    + "\nO CPF informado foi:  " + this.cpf + "\nO E-mail informado foi: " + this.email
                    + "\nO telefone informado foi: " + this.phone + "\nO Nivel de prioridade: " );
        }
    
        public static void main(String[] args) {
            // Crie uma instância de Pessoa
            //Pessoa pessoa = new Pessoa("Alice", 30, "123456789", "alice@example.com", "123-456-789");
    
            // Use os métodos getters para acessar os atributos e imprima-os
            // System.out.println("Nome: " + pessoa.getName());
            // System.out.println("Idade: " + pessoa.getAge());
            // System.out.println("CPF: " + pessoa.getCpf());
            // System.out.println("E-mail: " + pessoa.getEmail());
            // System.out.println("Telefone: " + pessoa.getPhone());

    }
}


