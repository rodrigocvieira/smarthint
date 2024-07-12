package com.smarthint.clientes.adaptadores.saida.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {
}
