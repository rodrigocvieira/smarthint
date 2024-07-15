package com.smarthint.clientes.adaptadores.saida;

import com.smarthint.clientes.adaptadores.ClienteMapper;
import com.smarthint.clientes.adaptadores.saida.repositorio.ClienteRepository;
import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.portas.saidas.ClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteAdapter implements ClienteOutputPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public void inserir(Cliente cliente) {
        clienteRepository.save(clienteMapper.toClienteEntity(cliente));
    }

    @Override
    public void editar(String id, Cliente cliente) {
        clienteRepository.save(clienteMapper.toClienteEntity(id, cliente));
    }
}
