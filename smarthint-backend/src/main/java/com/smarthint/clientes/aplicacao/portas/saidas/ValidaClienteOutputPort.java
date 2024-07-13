package com.smarthint.clientes.aplicacao.portas.saidas;

public interface ValidaClienteOutputPort {

    boolean emailJaExiste(String email);

    boolean cpfCnpjJaExiste(String cpfCnpj);

    boolean inscricaoEstadualJaExiste(String inscricaoEstadual);
}
