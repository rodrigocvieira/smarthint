package com.smarthint.clientes.aplicacao.core.enuns;

public enum GeneroPessoa {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String descricao;

    GeneroPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
