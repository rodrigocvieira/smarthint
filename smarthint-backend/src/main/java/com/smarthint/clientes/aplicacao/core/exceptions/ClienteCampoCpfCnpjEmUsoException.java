package com.smarthint.clientes.aplicacao.core.exceptions;

public class ClienteCampoCpfCnpjEmUsoException extends ClienteInvalidoException {

    public ClienteCampoCpfCnpjEmUsoException() {
        super("CPF/CNPJ já está vinculado a outro Comprador");
    }
}
