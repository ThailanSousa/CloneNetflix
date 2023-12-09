package com.cloneflix.config;

import com.cloneflix.model.entities.Cliente;
import com.cloneflix.service.ClienteService;

public class SecurityConfig {

    private ClienteService clienteService;

    public SecurityConfig(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public boolean autenticar(String cpf, String password) {
        Cliente clienteAutenticado = clienteService.autenticarCliente(cpf, password);
        return clienteAutenticado != null;
    }
    

}
