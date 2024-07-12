package com.smarthint.clientes.aplicacao.core.exceptions;

public class ClienteCampoSenhasDiferentesException extends ClienteInvalidoException {

    public ClienteCampoSenhasDiferentesException() {
        super("“As senhas não conferem");
    }

}
