package com.smarthint.clientes.adaptadores.entrada.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InserirClienteRequest(
        @NotBlank
        @Size(max = 150)
        String nomeRazaoSocial,
        @NotBlank
        @Size(max = 150)
        String email,
        @NotBlank
        @Size(max = 11)
        String telefone,
        @NotBlank
        String tipo,
        @NotBlank
        @Size(max = 14, min = 11)
        String cpfCnpj,
        String inscricaoEstadual,
        @NotBlank
        String genero,
        @NotBlank
        String dataNascimento,
        boolean isBloqueado,
        @NotBlank
        @Size(min = 8, max = 15)
        String senha
) {
}
