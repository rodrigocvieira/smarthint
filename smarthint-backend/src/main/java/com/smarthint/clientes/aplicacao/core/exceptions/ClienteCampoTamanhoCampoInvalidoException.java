package com.smarthint.clientes.aplicacao.core.exceptions;

public class ClienteCampoTamanhoCampoInvalidoException extends ClienteInvalidoException {

    public ClienteCampoTamanhoCampoInvalidoException(String campo) {
        super(String.format("Tamanho inválido do campo %s", campo));
    }
}
