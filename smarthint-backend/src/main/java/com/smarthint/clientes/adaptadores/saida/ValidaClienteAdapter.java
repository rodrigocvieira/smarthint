package com.smarthint.clientes.adaptadores.saida;

import com.smarthint.clientes.adaptadores.saida.repositorio.ClienteRepository;
import com.smarthint.clientes.aplicacao.portas.saidas.ValidaClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaClienteAdapter implements ValidaClienteOutputPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public boolean emailJaExiste(String email) {
        return clienteRepository.existsByEmail(email);
    }

    @Override
    public boolean emailJaExiste(String id, String email) {
        return clienteRepository.existsByIdNotAndEmail(id, email);
    }

    @Override
    public boolean cpfCnpjJaExiste(String cpfCnpj) {
        return clienteRepository.existsByCpfCnpj(cpfCnpj);
    }

    @Override
    public boolean cpfCnpjJaExiste(String id, String cpfCnpj) {
        return clienteRepository.existsByIdNotAndCpfCnpj(id, cpfCnpj);
    }

    @Override
    public boolean inscricaoEstadualJaExiste(String inscricaoEstadual) {
        return clienteRepository.existsByInscricaoEstadual(inscricaoEstadual);
    }

    @Override
    public boolean inscricaoEstadualJaExiste(String id, String inscricaoEstadual) {
        return clienteRepository.existsByIdNotAndInscricaoEstadual(id, inscricaoEstadual);
    }
}
