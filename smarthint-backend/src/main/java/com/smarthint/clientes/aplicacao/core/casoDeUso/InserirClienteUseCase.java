package com.smarthint.clientes.aplicacao.core.casoDeUso;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoCpfCnpjEmUsoException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoInscricaoEstadualEmUsoException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteEmailVinculadoException;
import com.smarthint.clientes.aplicacao.portas.entradas.InserirClienteInputPort;
import com.smarthint.clientes.aplicacao.portas.saidas.InserirClienteOutputPort;
import com.smarthint.clientes.aplicacao.portas.saidas.ValidaClienteOutputPort;

public class InserirClienteUseCase implements InserirClienteInputPort {

    private final InserirClienteOutputPort inserirClienteOutputPort;
    private final ValidaClienteOutputPort validaClienteOutputPort;

    public InserirClienteUseCase(InserirClienteOutputPort inserirClienteOutputPort,
                                 ValidaClienteOutputPort validaClienteOutputPort) {
        this.inserirClienteOutputPort = inserirClienteOutputPort;
        this.validaClienteOutputPort = validaClienteOutputPort;
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        cliente.isValido();

        if (validaClienteOutputPort.emailJaExiste(cliente.email()))
            throw new ClienteEmailVinculadoException();

        if (validaClienteOutputPort.cpfCnpjJaExiste(cliente.cpfCnpj()))
            throw new ClienteCampoCpfCnpjEmUsoException();

        if (cliente.tipo().isJuridica())
            if (validaClienteOutputPort.inscricaoEstadualJaExiste(cliente.inscricaoEstadual()))
                throw new ClienteCampoInscricaoEstadualEmUsoException();

        return inserirClienteOutputPort.inserir(cliente);
    }
}
