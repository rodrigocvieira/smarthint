package com.smarthint.clientes.aplicacao.portas.saidas;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;

public interface ClienteOutputPort {

    void inserir(Cliente cliente);

    void editar(String id, Cliente cliente);
}
