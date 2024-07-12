package com.smarthint.clientes.aplicacao.portas.saidas;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;

public interface InserirClienteOutputPort {

    Cliente inserir(Cliente cliente);
}
