package com.smarthint.clientes.adaptadores.saida.repositorio;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "cliente")
public record ClienteEntity(
        @Id
        String id,
        @Field("nome_razao_social")
        String nomeRazaoSocial,
        String email,
        String telefone,
        String tipo,
        @Indexed(unique = true)
        @Field("cpf_cnpj")
        String cpfCnpj,
        @Field("inscricao_estadual")
        String inscricaoEstadual,
        String genero,
        @Field("data_nascimento")
        Date dataNascimento,
        @Field("bloqueado")
        boolean bloqueado,
        String senha,
        @CreatedDate
        @Field("data_cadastro")
        Date dataDeCadastro
) {
}
