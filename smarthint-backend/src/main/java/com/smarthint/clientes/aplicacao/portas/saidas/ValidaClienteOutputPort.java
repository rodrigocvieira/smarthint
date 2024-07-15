package com.smarthint.clientes.aplicacao.portas.saidas;

public interface ValidaClienteOutputPort {

    boolean emailJaExiste(String email);

    boolean emailJaExiste(String id, String email);

    boolean cpfCnpjJaExiste(String cpfCnpj);

    boolean cpfCnpjJaExiste(String id, String cpfCnpj);

    boolean inscricaoEstadualJaExiste(String inscricaoEstadual);

    boolean inscricaoEstadualJaExiste(String id, String inscricaoEstadual);
}
