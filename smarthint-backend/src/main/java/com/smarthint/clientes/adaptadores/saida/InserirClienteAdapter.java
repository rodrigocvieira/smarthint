package com.smarthint.clientes.adaptadores.saida;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.portas.saidas.InserirClienteOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InserirClienteAdapter implements InserirClienteOutputPort {

    @Override
    public Cliente inserir(Cliente cliente) {
        return null;
    }
}
