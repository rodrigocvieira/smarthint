package com.smarthint.clientes.aplicacao.core.exceptions;

public class ClienteCampoInscricaoEstadualEmUsoException extends ClienteInvalidoException {

    public ClienteCampoInscricaoEstadualEmUsoException() {
        super("Inscrição Estadual já está vinculada a outro Comprador");
    }
}
