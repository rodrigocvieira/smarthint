package com.smarthint.clientes.aplicacao.core.enuns;

public enum TipoPessoa {

    FISICA("física"),
    JURIDICA("jurídica");

    private String descricao;

    TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isJuridica() {
        return this.equals(JURIDICA);
    }
}
