package com.smarthint.clientes.adaptadores.saida;

import com.smarthint.clientes.adaptadores.ClienteMapper;
import com.smarthint.clientes.adaptadores.saida.repositorio.ClienteEntity;
import com.smarthint.clientes.adaptadores.saida.repositorio.ClienteRepository;
import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.portas.saidas.InserirClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirClienteAdapter implements InserirClienteOutputPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public Cliente inserir(Cliente cliente) {
        ClienteEntity clienteEntity = clienteRepository.save(clienteMapper.toClienteEntity(cliente));
        return clienteMapper.toCliente(clienteEntity);
    }
}
