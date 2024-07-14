package com.smarthint.clientes.aplicacao.core.dominios;

import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoEmailInformadoInvalidoException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoInvalidoException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoTamanhoCampoInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClienteTest {

    @Test
    public void deveInvalidarNomeRazaoSocial() {
        Cliente cliente = new Cliente("",
                "",
                "",
                null,
                "",
                "",
                null,
                null,
                false,
                "",
                "");

        ClienteCampoInvalidoException exception = assertThrows(ClienteCampoInvalidoException.class, cliente::isValido);
        assertEquals("Nome ou Razão Social não informado!", exception.getMessage());
    }

    @Test
    public void deveInvalidarNomeRazaoSocialPorComprimento() {
        Cliente cliente = new Cliente(gerarTexto(151),
                "",
                "",
                null,
                "",
                "",
                null,
                null,
                false,
                "",
                "");

        ClienteCampoTamanhoCampoInvalidoException exception = assertThrows(ClienteCampoTamanhoCampoInvalidoException.class, cliente::isValido);
        assertEquals("Tamanho inválido do campo Nome ou Razão Social", exception.getMessage());
    }

    @Test
    public void deveInvalidarEmail() {
        Cliente cliente = new Cliente("Cliente",
                "",
                "",
                null,
                "",
                "",
                null,
                null,
                false,
                "",
                "");

        ClienteCampoInvalidoException exception = assertThrows(ClienteCampoInvalidoException.class, cliente::isValido);
        assertEquals("E-mail não informado!", exception.getMessage());
    }

    @Test
    public void deveInvalidarEmailPorComprimento() {
        Cliente cliente = new Cliente("Cliente",
                gerarTexto(151),
                "",
                null,
                "",
                "",
                null,
                null,
                false,
                "",
                "");

        ClienteCampoTamanhoCampoInvalidoException exception = assertThrows(ClienteCampoTamanhoCampoInvalidoException.class, cliente::isValido);
        assertEquals("Tamanho inválido do campo E-mail", exception.getMessage());
    }

    @Test
    public void deveInvalidarEmailFormatoErrado() {
        Cliente cliente = new Cliente("Cliente",
                "@teste.com",
                "",
                null,
                "",
                "",
                null,
                null,
                false,
                "",
                "");

        ClienteCampoEmailInformadoInvalidoException exception = assertThrows(ClienteCampoEmailInformadoInvalidoException.class, cliente::isValido);
        assertEquals("E-mail invalido!", exception.getMessage());

        cliente = new Cliente("Cliente",
                "teste@teste",
                "",
                null,
                "",
                "",
                null,
                null,
                false,
                "",
                "");

        exception = assertThrows(ClienteCampoEmailInformadoInvalidoException.class, cliente::isValido);
        assertEquals("E-mail invalido!", exception.getMessage());

        cliente = new Cliente("Cliente",
                "teste",
                "",
                null,
                "",
                "",
                null,
                null,
                false,
                "",
                "");

        exception = assertThrows(ClienteCampoEmailInformadoInvalidoException.class, cliente::isValido);
        assertEquals("E-mail invalido!", exception.getMessage());

        cliente = new Cliente("Cliente",
                "teste@",
                "",
                null,
                "",
                "",
                null,
                null,
                false,
                "",
                "");

        exception = assertThrows(ClienteCampoEmailInformadoInvalidoException.class, cliente::isValido);
        assertEquals("E-mail invalido!", exception.getMessage());
    }

    //TODO: os demais testes são no mesmo formato.

    private String gerarTexto(int comprimentoMax) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < comprimentoMax; i++)
            s.append("a");
        return s.toString();
    }
}