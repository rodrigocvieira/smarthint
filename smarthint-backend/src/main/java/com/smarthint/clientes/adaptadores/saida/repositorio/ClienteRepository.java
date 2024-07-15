package com.smarthint.clientes.adaptadores.saida.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {

    boolean existsByEmail(String email);

    boolean existsByIdNotAndEmail(String id, String email);

    boolean existsByCpfCnpj(String cpfCnpj);

    boolean existsByIdNotAndCpfCnpj(String id, String cpfCnpj);

    boolean existsByInscricaoEstadual(String inscricaoEstadual);

    boolean existsByIdNotAndInscricaoEstadual(String id, String inscricaoEstadual);

}
