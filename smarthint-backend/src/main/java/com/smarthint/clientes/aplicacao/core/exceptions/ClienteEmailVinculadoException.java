package com.smarthint.clientes.aplicacao.core.exceptions;

public class ClienteEmailVinculadoException extends ClienteInvalidoException {

    public ClienteEmailVinculadoException() {
        super("E-mail já vinculado a outro Comprador");
    }
}
