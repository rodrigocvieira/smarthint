package com.smarthint.clientes.aplicacao.core.dominios;

import com.smarthint.clientes.aplicacao.core.ValidaCampoCliente;
import com.smarthint.clientes.aplicacao.core.enuns.GeneroPessoa;
import com.smarthint.clientes.aplicacao.core.enuns.TipoPessoa;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoEmailInformadoInvalidoException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoSenhasDiferentesException;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Cliente(
        String nomeRazaoSocial,
        String email,
        String telefone,
        TipoPessoa tipo,
        String cpfCnpj,
        String inscricaoEstadual,
        GeneroPessoa genero,
        Date dataNascimento,
        boolean bloqueado,
        String senha,
        String senhaConfirmacao
) {
    public static final int TAMANHO_150 = 150;
    public static final int TAMANHO_15 = 15;
    public static final int TAMANHO_14 = 14;
    public static final int TAMANHO_12 = 12;
    public static final int TAMANHO_11 = 11;
    public static final int TAMANHO_8 = 8;
    public static final int TAMANHO_0 = 0;

    private static final String NOME_OU_RAZAO_SOCIAL = "Nome ou Razão Social";
    private static final String E_MAIL = "E-mail";
    private static final String TELEFONE = "Telefone";
    private static final String TIPO_DE_PESSOA = "Tipo de pessoa";
    private static final String CNPJ = "CNPJ";
    private static final String INSCRICAO_ESTADUAL = "Inscrição estadual";
    private static final String CPF = "CPF";
    private static final String GENERO = "Genero";
    private static final String DATA_DE_NASCIMENTO = "Data de nascimento";
    private static final String SENHA = "Senha";
    private static final String SENHA_CONFIRMACAO = "Confirmação da senha";


    public void isValido() {
        ValidaCampoCliente.campoPreenchio(NOME_OU_RAZAO_SOCIAL, nomeRazaoSocial);
        ValidaCampoCliente.comprimentoPermitido(NOME_OU_RAZAO_SOCIAL, nomeRazaoSocial, TAMANHO_0, TAMANHO_150);

        ValidaCampoCliente.campoPreenchio(E_MAIL, email);
        ValidaCampoCliente.comprimentoPermitido(E_MAIL, email, TAMANHO_0, TAMANHO_150);
        valdaFormatoEmail();

        ValidaCampoCliente.campoPreenchio(TELEFONE, telefone);
        ValidaCampoCliente.comprimentoPermitido(TELEFONE, telefone, TAMANHO_0, TAMANHO_11);

        ValidaCampoCliente.campoPreenchio(TIPO_DE_PESSOA, tipo);

        if (tipo.isJuridica()) {
            ValidaCampoCliente.campoPreenchio(CNPJ, cpfCnpj);
            ValidaCampoCliente.comprimentoPermitido(CNPJ, cpfCnpj, TAMANHO_14, TAMANHO_14);

            ValidaCampoCliente.campoPreenchio(INSCRICAO_ESTADUAL, inscricaoEstadual);
            ValidaCampoCliente.comprimentoPermitido(INSCRICAO_ESTADUAL, inscricaoEstadual, TAMANHO_12, TAMANHO_12);
        } else {
            ValidaCampoCliente.campoPreenchio(CPF, cpfCnpj);
            ValidaCampoCliente.comprimentoPermitido(CPF, cpfCnpj, TAMANHO_11, TAMANHO_11);

            ValidaCampoCliente.deveSerNuloOuVazio(INSCRICAO_ESTADUAL, inscricaoEstadual);

            ValidaCampoCliente.campoPreenchio(GENERO, genero);

            ValidaCampoCliente.campoPreenchio(DATA_DE_NASCIMENTO, dataNascimento);
        }

        ValidaCampoCliente.campoPreenchio(SENHA, senha);
        ValidaCampoCliente.comprimentoPermitido(SENHA, senha, TAMANHO_8, TAMANHO_15);

        ValidaCampoCliente.campoPreenchio(SENHA_CONFIRMACAO, senhaConfirmacao);
        senhasDiferentes();

    }

    private void senhasDiferentes() {
        if (!senha.equals(senhaConfirmacao))
            throw new ClienteCampoSenhasDiferentesException();
    }

    private void valdaFormatoEmail() {
        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        Matcher matcher = EMAIL_PATTERN.matcher(email);
        boolean matches = matcher.matches();
        if (!matches)
            throw new ClienteCampoEmailInformadoInvalidoException();
    }
}
