package com.smarthint.clientes.adaptadores.entrada.request;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteRequest(
        @NotBlank
        @Size(max = Cliente.TAMANHO_150)
        String nomeRazaoSocial,
        @NotBlank
        @Size(max = Cliente.TAMANHO_150)
        String email,
        @NotBlank
        @Size(max = Cliente.TAMANHO_11)
        String telefone,
        @NotBlank
        String tipo,
        @NotBlank
        @Size(max = Cliente.TAMANHO_14, min = Cliente.TAMANHO_11)
        String cpfCnpj,
        String inscricaoEstadual,
        @NotBlank
        String genero,
        @NotBlank
        String dataNascimento,
        boolean isBloqueado,
        @NotBlank
        @Size(min = Cliente.TAMANHO_8, max = Cliente.TAMANHO_15)
        String senha,
        @NotBlank
        @Size(min = Cliente.TAMANHO_8, max = Cliente.TAMANHO_15)
        String senhaConfirmacao
) {
}
