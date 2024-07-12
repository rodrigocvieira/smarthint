package com.smarthint.clientes.adaptadores.entrada.request;

public record InserirClienteRequest(
        String nomeRazaoSocial,
        String email,
        String telefone,
        String tipo,
        String cpfCnpj,
        String inscricaoEstadual,
        String Genero,
        String dataNascimento,
        boolean isBloqueado,
        String senha
) {
}
