package com.smarthint.clientes.aplicacao.portas.saidas;

public interface ValidaClienteOutputPort {

    boolean validaEmail(String email);

    boolean validaCpfCnpj(String cpfCnpj);

    boolean validaInscricaoEstadual(String inscricaoEstadual);
}
