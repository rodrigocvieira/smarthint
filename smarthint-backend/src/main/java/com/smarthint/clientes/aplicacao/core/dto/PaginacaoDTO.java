package com.smarthint.clientes.aplicacao.core.dto;

import java.util.List;

public record PaginacaoDTO(
        boolean proximaPagina,
        List<ClienteDTO> clientes
) {
}
