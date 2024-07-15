package com.smarthint.clientes.adaptadores;

import com.smarthint.clientes.adaptadores.entrada.request.InserirClienteRequest;
import com.smarthint.clientes.adaptadores.saida.repositorio.ClienteEntity;
import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.core.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteEntity toClienteEntity(Cliente cliente);

    Cliente toCliente(ClienteEntity clienteEntity);

    @Mapping(source = "dataNascimento", target = "dataNascimento", dateFormat = "dd-MM-yyyy")
    Cliente toCliente(InserirClienteRequest inserirClienteRequest);

    ClienteDTO toClienteDto(ClienteEntity clienteEntity);
}
