package com.smarthint.clientes.aplicacao.core.exceptions;

public class ClienteCampoCampoDeveSerNuloOuVazioException extends ClienteInvalidoException {

    public ClienteCampoCampoDeveSerNuloOuVazioException(String campo) {
        super(String.format(" %s não deve ser informado!", campo));
    }
}
