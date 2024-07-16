package com.smarthint.clientes.aplicacao.portas.entradas;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.core.dto.PaginacaoDTO;

public interface ObterClienteInputPort {

    PaginacaoDTO obterPaginado(int pagina);

    Cliente obterPorId(String id);

    PaginacaoDTO obterPaginado(int pagina, String filtro);
}
