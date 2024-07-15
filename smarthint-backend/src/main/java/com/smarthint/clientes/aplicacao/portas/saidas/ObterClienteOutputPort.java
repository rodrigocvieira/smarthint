package com.smarthint.clientes.aplicacao.portas.saidas;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.core.dto.PaginacaoDTO;

public interface ObterClienteOutputPort {


    Cliente obterPorId(String id);

    PaginacaoDTO obterPaginado(int paginacao);
}
