package com.smarthint.clientes.aplicacao.portas.entradas;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;

public interface ClienteInputPort {

    void inserir(Cliente cliente);

    void editar(String id, Cliente cliente);
}
