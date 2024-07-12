package com.smarthint.clientes.aplicacao.portas.entradas;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;

public interface InserirClienteInputPort {

    Cliente inserir(Cliente cliente);
}
