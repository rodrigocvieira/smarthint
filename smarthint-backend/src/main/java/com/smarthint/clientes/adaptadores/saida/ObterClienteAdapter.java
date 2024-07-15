package com.smarthint.clientes.adaptadores.saida;

import com.smarthint.clientes.adaptadores.ClienteMapper;
import com.smarthint.clientes.adaptadores.saida.repositorio.ClienteRepository;
import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.core.dto.ClienteDTO;
import com.smarthint.clientes.aplicacao.core.dto.PaginacaoDTO;
import com.smarthint.clientes.aplicacao.core.exceptions.out.ClienteNaoEncontradoException;
import com.smarthint.clientes.aplicacao.portas.saidas.ObterClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class ObterClienteAdapter implements ObterClienteOutputPort {

    private final int TOTAL_POR_PAGINA = 20;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public Cliente obterPorId(String id) {
        return clienteRepository.findById(id)
                .map(clienteEntity -> clienteMapper.toCliente(clienteEntity))
                .orElseThrow(ClienteNaoEncontradoException::new);
    }

    @Override
    public PaginacaoDTO obterPaginado(int paginacao) {
        Page<ClienteDTO> page = clienteRepository.findAll(
                        PageRequest.of(paginacao, TOTAL_POR_PAGINA, Sort.Direction.ASC, "id")
                )
                .map(
                        clienteEntity -> clienteMapper.toClienteDto(clienteEntity)
                );

        return new PaginacaoDTO(page.hasNext(), page.getContent());
    }
}
