package com.cloneflix.service;

import java.util.Scanner;

import com.cloneflix.model.entities.Cliente;
import com.cloneflix.repository.ClienteRepository;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    public boolean cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("|-------------------------------------------|");
        System.out.println("|     Bem-vindo ao cadastro de cliente!     |");
        System.out.println("|-------------------------------------------|");

        // Loop para garantir que todos os campos não fiquem em branco
        String nome = "";
        while (nome.trim().isEmpty()) {
            System.out.print("Nome: ");
            nome = scanner.nextLine();
            if (nome.trim().isEmpty()) {
                System.out.println("Nome não pode ser deixado em branco. Tente novamente.");
            }
        }

        int idade = 0;
        while (idade <= 0 || idade < 18) {
            System.out.print("Idade: ");
            try {
                idade = Integer.parseInt(scanner.nextLine());
                if (idade <= 0) {
                    System.out.println("Idade deve ser um número positivo. Tente novamente.");
                } else if (idade < 18) {
                    System.out.println("Você deve ter pelo menos 18 anos para se cadastrar. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dados incorretos, por favor, verifique os campos e preencha novamente");
            }
        }

        String cpf = "";
        while (cpf.length() != 11) {
            System.out.print("CPF (11 dígitos): ");
            cpf = scanner.nextLine();
            if (cpf.length() != 11) {
                System.out.println("CPF deve ter 11 dígitos. Tente novamente.");
            } else {
                // Verificar se o CPF é válido
                if (!validarCPF(cpf)) {
                    System.out.println("CPF inválido. Tente novamente.");
                    cpf = "";
                }
            }
        }

        String email = "";
        while (email.trim().isEmpty() || !email.contains("@")) {
            System.out.print("Email: ");
            email = scanner.nextLine();

            if (email.trim().isEmpty()) {
                System.out.println("Email não pode ser deixado em branco. Tente novamente.");
            } else if (!email.contains("@")) {
                System.out.println("O email deve conter o símbolo '@'. Tente novamente.");
            }
        }

        String telefone = "";
        while (telefone.trim().isEmpty() || !telefone.matches("^\\(\\d{2}\\)\\d\\.\\d{8}$")) {
            System.out.print("Telefone: ");
            System.out.print("(XX)X.:");
            telefone = scanner.nextLine();
        
            if (telefone.trim().isEmpty()) {
                System.out.println("Telefone não pode ser deixado em branco. Tente novamente.");
            } else if (!telefone.matches("^\\(\\d{2}\\)\\d\\.\\d{8}$")) {
                System.out.println("O telefone deve estar no formato (XX)X.XXXXXXXX. Tente novamente.");
            }
        }
        

        String username = "";
        while (username.trim().isEmpty() || !username.matches("^[a-zA-Z0-9]*$")) {
            System.out.print("Nome de usuário: ");
            username = scanner.nextLine();
            if (username.trim().isEmpty() || !username.matches("^[a-zA-Z0-9]*$")) {
                System.out.println("Nome de usuário não pode conter caracteres especiais. Tente novamente.");
            }
        }

        String senha = "";
        while (senha.length() > 20 || senha.trim().isEmpty()) {
            System.out.print("Senha : ");
            senha = scanner.nextLine();
            if (senha.length() > 20 || senha.trim().isEmpty()) {
                System.out.println("Senha não pode ter mais de 20 dígitos. Tente novamente.");
            }
        }

        Cliente novoCliente = new Cliente(null, username, senha, nome, idade, cpf, email, telefone);

        boolean cadastrado = clienteRepository.cadastrarCliente(novoCliente);

        if (cadastrado) {
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Dados incorretos, por favor, verifique os campos e preencha novamente");
        }
        return cadastrado;
    }

    // Função para validar o CPF
    public static boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos após a remoção de caracteres não
        // numéricos
        if (cpf.length() != 11) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }

        // Verifica se o primeiro dígito verificador é igual ao décimo caractere do CPF
        if (Character.getNumericValue(cpf.charAt(9)) != primeiroDigito) {
            return false;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }

        // Verifica se o segundo dígito verificador é igual ao décimo primeiro caractere
        // do CPF
        return Character.getNumericValue(cpf.charAt(10)) == segundoDigito;
    }

    public Cliente consultarClientePorCpf() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        return clienteRepository.consultarClientePorCpf(cpf);
    }

    public boolean atualizarCliente() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o CPF do cliente: ");
    String cpf = scanner.nextLine();

    Cliente cliente = consultarClientePorCpf();

    if (cliente != null) {
        // Adicionando tratamentos para os atributos a serem atualizados
        System.out.print("Nova senha (ou Enter para manter a mesma): ");
        String newPassword = scanner.nextLine();
        if (!newPassword.trim().isEmpty()) {
            // Validar a nova senha se não estiver em branco
            while (newPassword.length() > 20) {
                System.out.print("Senha não pode ter mais de 20 dígitos. Tente novamente: ");
                newPassword = scanner.nextLine();
            }
            cliente.setPassword(newPassword);
        }

        System.out.print("Novo email (ou Enter para manter o mesmo): ");
        String newEmail = scanner.nextLine();
        if (!newEmail.trim().isEmpty()) {
            // Validar o novo email se não estiver em branco
            while (newEmail.trim().isEmpty() || !newEmail.contains("@")) {
                System.out.print("Email inválido. Tente novamente: ");
                newEmail = scanner.nextLine();
            }
            cliente.setEmail(newEmail);
        }

        System.out.print("Novo telefone (ou Enter para manter o mesmo): ");
        String newPhone = scanner.nextLine();
        if (!newPhone.trim().isEmpty()) {
            // Validar o novo telefone se não estiver em branco
            while (newPhone.trim().isEmpty() || !newPhone.matches("^\\(\\d{2}\\)\\d\\.\\d{8}$")) {
                System.out.print("Telefone inválido. Tente novamente: ");
                newPhone = scanner.nextLine();
            }
            cliente.setPhone(newPhone);
        }

        return clienteRepository.atualizarCliente(cliente);
    } else {
        System.out.println("Cliente não encontrado.");
        return false;
    }
}

    public boolean deletarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        return clienteRepository.deletarCliente(cpf);
    }

    public Cliente autenticarCliente(String cpf, String password) {
        return clienteRepository.autenticarCliente(cpf, password);
    }
    public void visualizarDadosCliente() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
    
        Cliente cliente = clienteRepository.consultarClientePorCpf(cpf);
    
        if (cliente != null) {
            System.out.println("Dados do Cliente:");
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Nome: " + cliente.getName());
            System.out.println("Idade: " + cliente.getAge());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getPhone());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
    

}
