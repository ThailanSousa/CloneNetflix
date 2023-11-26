package com.cloneflix.controller;

import com.cloneflix.model.entities.Cliente;
import com.cloneflix.service.ClienteService;

public class AutenticacaoController {

    private ClienteService clienteService;

    public AutenticacaoController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public String autenticar(String username, String password) {
        Cliente clienteAutenticado = clienteService.autenticarCliente(username, password);

        if (clienteAutenticado != null) {
            return "Login bem-sucedido!";
        } else {
            return "Falha na autenticação";
        }
    }

    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        AutenticacaoController autenticacaoController = new AutenticacaoController(clienteService);

        String resultado = autenticacaoController.autenticar("user1", "senha1");

        System.out.println(resultado);
    }
}
