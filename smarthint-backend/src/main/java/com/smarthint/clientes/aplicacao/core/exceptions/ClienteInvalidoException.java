package com.smarthint.clientes.aplicacao.core.exceptions;

public abstract class ClienteInvalidoException extends RuntimeException {

    public ClienteInvalidoException(String message) {
        super(message);
    }
}
