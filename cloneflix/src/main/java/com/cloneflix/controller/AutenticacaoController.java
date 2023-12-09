package com.cloneflix.controller;

import com.cloneflix.model.entities.Cliente;
import com.cloneflix.service.ClienteService;

public class AutenticacaoController {

    private ClienteService clienteService;

    public AutenticacaoController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public String autenticar(String cpf, String password) {
        Cliente clienteAutenticado = clienteService.autenticarCliente(cpf, password);

        if (clienteAutenticado != null) {
            return "Login bem-sucedido!";
        } else {
            return "Falha na autenticação";
        }
    }
}
