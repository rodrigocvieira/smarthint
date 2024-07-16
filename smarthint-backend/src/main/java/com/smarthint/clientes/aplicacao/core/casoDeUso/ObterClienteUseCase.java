package com.smarthint.clientes.aplicacao.core.casoDeUso;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.core.dto.PaginacaoDTO;
import com.smarthint.clientes.aplicacao.portas.entradas.ObterClienteInputPort;
import com.smarthint.clientes.aplicacao.portas.saidas.ObterClienteOutputPort;

public class ObterClienteUseCase implements ObterClienteInputPort {

    private final ObterClienteOutputPort obterClienteOutputPort;

    public ObterClienteUseCase(ObterClienteOutputPort obterClienteOutputPort) {
        this.obterClienteOutputPort = obterClienteOutputPort;
    }

    @Override
    public PaginacaoDTO obterPaginado(int pagina) {
        return obterClienteOutputPort.obterPaginado(pagina);
    }

    @Override
    public Cliente obterPorId(String id) {
        return obterClienteOutputPort.obterPorId(id);
    }

    @Override
    public PaginacaoDTO obterPaginado(int pagina, String filtro) {
        return obterClienteOutputPort.obterPaginado(pagina, filtro);
    }
}
