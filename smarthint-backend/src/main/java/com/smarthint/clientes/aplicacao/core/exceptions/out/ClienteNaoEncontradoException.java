package com.smarthint.clientes.aplicacao.core.exceptions.out;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado!");
    }
}
