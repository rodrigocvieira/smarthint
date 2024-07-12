package com.smarthint.clientes.aplicacao.core.dominios;

import com.smarthint.clientes.aplicacao.core.enuns.GeneroPessoa;
import com.smarthint.clientes.aplicacao.core.enuns.TipoPessoa;

import java.util.Date;

public record Cliente(
        String nomeRazaoSocial,
        String email,
        String telefone,
        TipoPessoa tipo,
        String cpfCnpj,
        String inscricaoEstadual,
        GeneroPessoa genero,
        Date dataNascimento,
        boolean isBloqueado,
        String senha
) {
}
