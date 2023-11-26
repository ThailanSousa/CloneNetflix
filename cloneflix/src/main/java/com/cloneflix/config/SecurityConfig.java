package com.cloneflix.config;

import com.cloneflix.model.entities.Cliente;
import com.cloneflix.service.ClienteService;

public class SecurityConfig {

    private ClienteService clienteService;

    public SecurityConfig(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public boolean autenticar(String username, String password) {
        Cliente clienteAutenticado = clienteService.autenticarCliente(username, password);
        return clienteAutenticado != null;
    }

    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        SecurityConfig securityConfig = new SecurityConfig(clienteService);

        boolean autenticado = securityConfig.autenticar("user1", "senha1");

        if (autenticado) {
            System.out.println("Usuário autenticado com sucesso!");
        } else {
            System.out.println("Falha na autenticação");
        }
    }
}
