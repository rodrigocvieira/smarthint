package com.smarthint.clientes.aplicacao.core.casoDeUso;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.portas.entradas.InserirClienteInputPort;
import com.smarthint.clientes.aplicacao.portas.saidas.InserirClienteOutputPort;

public class InserirClienteUseCase implements InserirClienteInputPort {

    private final InserirClienteOutputPort inserirClienteOutputPort;

    public InserirClienteUseCase(InserirClienteOutputPort inserirClienteOutputPort) {
        this.inserirClienteOutputPort = inserirClienteOutputPort;
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        return inserirClienteOutputPort.inserir(cliente);
    }
}
