package com.smarthint.clientes.aplicacao.core.dto;

import java.util.Date;

public record ClienteDTO(
        String id,
        String nomeRazaoSocial,
        String email,
        String telefone,
        Date dataDeCadastro,
        boolean bloqueado
) {
}
