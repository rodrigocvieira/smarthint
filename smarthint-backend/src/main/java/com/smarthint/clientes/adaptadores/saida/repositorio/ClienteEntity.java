package com.smarthint.clientes.adaptadores.saida.repositorio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cliente")
public class ClienteEntity {

    @Id
    private String id;

    @Field("nome_razao_social")
    private String nomeRazaoSocial;

    private String email;

    private String telefone;

    private String tipo;

    @Indexed(unique = true)
    @Field("cpf_cnpj")
    private String cpfCnpj;

    @Field("inscricao_estadual")
    private String inscricaoEstadual; //TODO: validacao personalizada quando for Juridico este e obrigatorio

    private String genero;

    @Field("data_nascimento")
    private Date dataNascimento;

    @Field("bloqueado")
    private boolean isBloqueado;

    private String senha;
}
