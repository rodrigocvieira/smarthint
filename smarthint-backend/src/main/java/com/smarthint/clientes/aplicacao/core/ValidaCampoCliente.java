package com.smarthint.clientes.aplicacao.core;

import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoCampoDeveSerNuloOuVazioException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoInvalidoException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoTamanhoCampoInvalidoException;
import org.springframework.util.ObjectUtils;

public class ValidaCampoCliente {

    private ValidaCampoCliente() {
    }

    public static void campoPreenchio(String campo, Object valor) {
        if (ObjectUtils.isEmpty(valor))
            throw new ClienteCampoInvalidoException(campo);
    }

    public static void campoPreenchio(String campo, String valor) {
        if (ObjectUtils.isEmpty(valor))
            throw new ClienteCampoInvalidoException(campo);
    }

    public static void deveSerNuloOuVazio(String campo, Object valor) {
        if (!ObjectUtils.isEmpty(valor))
            throw new ClienteCampoCampoDeveSerNuloOuVazioException(campo);
    }

    public static void comprimentoPermitido(String campo, String valor, int minimo, int maximo) {
        if (valor.length() < minimo && valor.length() > maximo)
            throw new ClienteCampoTamanhoCampoInvalidoException(campo);
    }

}
