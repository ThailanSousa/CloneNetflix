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

        System.out.println("Bem-vindo ao cadastro de cliente!");
        System.out.println("Insira as informações do cliente:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();




        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        if(idade < 18){
            System.out.println("voce não tem permiçã para criar conta");
            System.out.println("voce deve ter mais de 18 anos");
        }else{
        scanner.nextLine(); // Limpa o buffer
        }


        System.out.print("CPF (11 dígitos): ");
        String cpf = scanner.nextLine();
        while (cpf.length() != 11) {
            System.out.println("CPF deve ter 11 dígitos. Tente novamente:");
            cpf = scanner.nextLine();
        }

        System.out.print("Email: ");
        String email = scanner.nextLine();



        System.out.print("Telefone: ");
        System.out.print("(81)9.:");
        String telefone = scanner.nextLine();



        System.out.print("Nome de usuário (sem caracteres especiais): ");
        String username = scanner.nextLine();




        // Validar o nome de usuário
        while (!username.matches("^[a-zA-Z0-9]*$")) {
            System.out.println("Nome de usuário não pode conter caracteres especiais. Tente novamente:");
            username = scanner.nextLine();
        }

        System.out.print("Senha (até 20 dígitos): ");
        String senha = scanner.nextLine();

        // Validar a senha
        while (senha.length() > 20) {
            System.out.println("Senha não pode ter mais de 20 dígitos. Tente novamente:");
            senha = scanner.nextLine();
        }

        Cliente novoCliente = new Cliente(username, senha, nome, idade, cpf, email, telefone);

        boolean cadastrado = clienteRepository.cadastrarCliente(novoCliente);

        if (cadastrado) {
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar o cliente.");
        }
        return cadastrado;
    }

    public Cliente consultarCliente(Long id) {
        return clienteRepository.consultarCliente(id);
    }

    public boolean atualizarCliente(Long id, String newPassword, String newEmail, String newPhone) {
        Cliente cliente = consultarCliente(id);

        if (cliente != null) {
            cliente.setPassword(newPassword);
            cliente.setEmail(newEmail);
            cliente.setPhone(newPhone);
            return clienteRepository.atualizarCliente(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
            return false;
        }
    }

    public boolean deletarCliente(Long id) {
        return clienteRepository.deletarCliente(id);
    }
    public Cliente autenticarCliente(String username, String password) {
        return clienteRepository.autenticarCliente(username, password);
    }
}
