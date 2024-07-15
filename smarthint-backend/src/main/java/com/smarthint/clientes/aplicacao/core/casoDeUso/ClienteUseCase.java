package com.smarthint.clientes.aplicacao.core.casoDeUso;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoCpfCnpjEmUsoException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoInscricaoEstadualEmUsoException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteEmailVinculadoException;
import com.smarthint.clientes.aplicacao.portas.entradas.ClienteInputPort;
import com.smarthint.clientes.aplicacao.portas.saidas.ClienteOutputPort;
import com.smarthint.clientes.aplicacao.portas.saidas.ValidaClienteOutputPort;

public class ClienteUseCase implements ClienteInputPort {

    private final ClienteOutputPort clienteOutputPort;
    private final ValidaClienteOutputPort validaClienteOutputPort;

    public ClienteUseCase(ClienteOutputPort clienteOutputPort,
                          ValidaClienteOutputPort validaClienteOutputPort) {
        this.clienteOutputPort = clienteOutputPort;
        this.validaClienteOutputPort = validaClienteOutputPort;
    }

    @Override
    public void inserir(Cliente cliente) {
        cliente.isValido();

        if (validaClienteOutputPort.emailJaExiste(cliente.email()))
            throw new ClienteEmailVinculadoException();

        if (validaClienteOutputPort.cpfCnpjJaExiste(cliente.cpfCnpj()))
            throw new ClienteCampoCpfCnpjEmUsoException();

        if (cliente.tipo().isJuridica())
            if (validaClienteOutputPort.inscricaoEstadualJaExiste(cliente.inscricaoEstadual()))
                throw new ClienteCampoInscricaoEstadualEmUsoException();

        clienteOutputPort.inserir(cliente);
    }

    @Override
    public void editar(String id, Cliente cliente) {
        cliente.isValido();

        if (validaClienteOutputPort.emailJaExiste(id, cliente.email()))
            throw new ClienteEmailVinculadoException();

        if (validaClienteOutputPort.cpfCnpjJaExiste(id, cliente.cpfCnpj()))
            throw new ClienteCampoCpfCnpjEmUsoException();

        if (cliente.tipo().isJuridica())
            if (validaClienteOutputPort.inscricaoEstadualJaExiste(id, cliente.inscricaoEstadual()))
                throw new ClienteCampoInscricaoEstadualEmUsoException();

        clienteOutputPort.editar(id, cliente);
    }
}
