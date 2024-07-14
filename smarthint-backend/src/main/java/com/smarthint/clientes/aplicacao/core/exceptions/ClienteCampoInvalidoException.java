package com.smarthint.clientes.aplicacao.core.exceptions;

public class ClienteCampoInvalidoException extends ClienteInvalidoException {

    public ClienteCampoInvalidoException(String campo) {
        super(String.format("%s não informado!", campo));
    }
}
