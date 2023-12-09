package com.cloneflix.service;

import java.util.Scanner;

import com.cloneflix.model.entities.Funcionario;
import com.cloneflix.repository.FuncionarioRepository; // Alteração do import para o novo repositório

public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService() {
        this.funcionarioRepository = new FuncionarioRepository();
    }


    public boolean cadastrarFuncionario() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();
        System.out.print("Digite o nome: ");
        String name = scanner.nextLine();
        System.out.print("Digite a idade: ");
        int age = 0;
        while (age <= 0 || age < 18) {
            System.out.print("Idade: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    System.out.println("Idade deve ser um número positivo. Tente novamente.");
                } else if (age < 18) {
                    System.out.println("Você deve ter pelo menos 18 anos para se cadastrar. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dados incorretos, por favor, verifique os campos e preencha novamente");
            }
        }
        System.out.print("Digite o CPF: ");
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
        System.out.print("Digite o email: ");
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
        System.out.print("Digite o telefone: ");
        String phone = "";
        while (phone.trim().isEmpty() || !phone.matches("^\\(\\d{2}\\)\\d\\.\\d{8}$")) {
            System.out.print("Telefone: ");
            System.out.print("(XX)X.:");
            phone = scanner.nextLine();
            if (phone.trim().isEmpty()) {
                System.out.println("Telefone não pode ser deixado em branco. Tente novamente.");
            } else if (!phone.matches("^\\(\\d{2}\\)\\d\\.\\d{8}$")) {
                System.out.println("O telefone deve estar no formato (XX)X.XXXXXXXX. Tente novamente.");
            }
        }
    
        System.out.println("Escolha o cargo:");
        System.out.println("1. Junior");
        System.out.println("2. Aux. Produção");
        System.out.println("3. Adm");
    
        int escolhaCargo = obterEscolhaValida(scanner);
    
        Funcionario.Cargo cargo;
    
        switch (escolhaCargo) {
            case 1:
                cargo = Funcionario.Cargo.JUNIOR;
                break;
            case 2:
                cargo = Funcionario.Cargo.AUX_PRODUCAO;
                break;
            case 3:
                cargo = Funcionario.Cargo.ADM;
                break;
            default:
                System.out.println("Opção inválida. Cargo definido como Junior.");
                cargo = Funcionario.Cargo.JUNIOR;
        }
    
        Funcionario novoFuncionario = new Funcionario(username, password, name, age, cpf, email, phone, cargo);
    
        boolean cadastrado = funcionarioRepository.cadastrarFuncionario(novoFuncionario);
    
        if (cadastrado) {
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar o funcionário.");
        }
        return cadastrado;
    }
    

    private int obterEscolhaValida(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Insira um número válido:");
            }
        }
    }

    public Funcionario consultarFuncionarioPorCpf() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();

        return funcionarioRepository.consultarFuncionarioPorCpf(cpf);
    }

    public boolean atualizarFuncionario() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();
    
        Funcionario funcionario = consultarFuncionarioPorCpf();
    
        if (funcionario != null) {
            // Adicionando tratamentos para os atributos a serem atualizados
            System.out.print("Nova senha (ou Enter para manter a mesma): ");
            String newPassword = scanner.nextLine();
            if (!newPassword.trim().isEmpty()) {
                // Validar a nova senha se não estiver em branco
                while (newPassword.length() > 20) {
                    System.out.print("Senha não pode ter mais de 20 dígitos. Tente novamente: ");
                    newPassword = scanner.nextLine();
                }
                funcionario.setPassword(newPassword);
            }
    
            System.out.print("Novo email (ou Enter para manter o mesmo): ");
            String newEmail = scanner.nextLine();
            if (!newEmail.trim().isEmpty()) {
                // Validar o novo email se não estiver em branco
                while (newEmail.trim().isEmpty() || !newEmail.contains("@")) {
                    System.out.print("Email inválido. Tente novamente: ");
                    newEmail = scanner.nextLine();
                }
                funcionario.setEmail(newEmail);
            }
    
            System.out.print("Novo telefone (ou Enter para manter o mesmo): ");
            String newPhone = scanner.nextLine();
            if (!newPhone.trim().isEmpty()) {
                // Validar o novo telefone se não estiver em branco
                while (newPhone.trim().isEmpty() || !newPhone.matches("^\\(\\d{2}\\)\\d\\.\\d{8}$")) {
                    System.out.print("Telefone inválido. Tente novamente: ");
                    newPhone = scanner.nextLine();
                }
                funcionario.setPhone(newPhone);
            }
    
            return funcionarioRepository.atualizarFuncionario(funcionario);
        } else {
            System.out.println("Funcionário não encontrado.");
            return false;
        }
    }
    
    public boolean deletarFuncionario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();

        return funcionarioRepository.deletarFuncionario(cpf);
    }

    public Funcionario autenticarFuncionario(String cpf, String password) {
        return funcionarioRepository.autenticarFuncionario(cpf, password);
    }
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


}
