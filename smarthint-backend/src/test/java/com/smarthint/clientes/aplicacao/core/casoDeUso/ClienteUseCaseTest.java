package com.smarthint.clientes.aplicacao.core.casoDeUso;

import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.core.enuns.GeneroPessoa;
import com.smarthint.clientes.aplicacao.core.enuns.TipoPessoa;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoCpfCnpjEmUsoException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteCampoInscricaoEstadualEmUsoException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteEmailVinculadoException;
import com.smarthint.clientes.aplicacao.portas.saidas.ClienteOutputPort;
import com.smarthint.clientes.aplicacao.portas.saidas.ValidaClienteOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteUseCaseTest {

    @Mock
    ClienteOutputPort clienteOutputPort;
    @Mock
    ValidaClienteOutputPort validaClienteOutputPort;

    ClienteUseCase clienteUseCase;
    Cliente clienteFisica;
    Cliente clienteJuridica;

    @BeforeEach
    public void init() {
        clienteUseCase = new ClienteUseCase(clienteOutputPort, validaClienteOutputPort);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JULY, 13);

        clienteFisica = new Cliente("Cliente fisico",
                "cliente@cliente.com.br",
                "44999999999",
                TipoPessoa.FISICA,
                "12345678901",
                "",
                GeneroPessoa.MASCULINO,
                calendar.getTime(),
                false,
                "123456789",
                "123456789");

        clienteJuridica = new Cliente("Razao",
                "empresa@empresa.com.br",
                "44999999999",
                TipoPessoa.JURIDICA,
                "12345678901234",
                "12345678",
                null,
                null,
                false,
                "123456789",
                "123456789");
    }

    @Test
    public void deveInserirClienteFisicaNaPortaDeSaida() {
        when(validaClienteOutputPort.emailJaExiste(any())).thenReturn(false);
        when(validaClienteOutputPort.cpfCnpjJaExiste(any())).thenReturn(false);

        clienteUseCase.inserir(clienteFisica);

        verify(clienteOutputPort, times(1)).inserir(clienteFisica);
    }

    @Test
    public void deveInserirClienteJuridicaNaPortaDeSaida() {
        when(validaClienteOutputPort.emailJaExiste(any())).thenReturn(false);
        when(validaClienteOutputPort.cpfCnpjJaExiste(any())).thenReturn(false);
        when(validaClienteOutputPort.inscricaoEstadualJaExiste(any())).thenReturn(false);

        clienteUseCase.inserir(clienteJuridica);

        verify(clienteOutputPort, times(1)).inserir(clienteJuridica);
    }

    @Test
    public void naoDeveConseguirInserirClientePorEmailJaExistir() {
        when(validaClienteOutputPort.emailJaExiste(any())).thenReturn(true);
        ClienteEmailVinculadoException clienteEmailVinculadoException = assertThrows(ClienteEmailVinculadoException.class,
                () -> clienteUseCase.inserir(clienteFisica)
        );

        verify(clienteOutputPort, never()).inserir(clienteFisica);
        assertEquals("E-mail já vinculado a outro Comprador", clienteEmailVinculadoException.getMessage());
    }

    @Test
    public void naoDeveConseguirInserirClientePorCpfCnpjJaExistir() {
        when(validaClienteOutputPort.emailJaExiste(any())).thenReturn(false);
        when(validaClienteOutputPort.cpfCnpjJaExiste(any())).thenReturn(true);

        ClienteCampoCpfCnpjEmUsoException clienteCampoCpfCnpjEmUsoException = assertThrows(ClienteCampoCpfCnpjEmUsoException.class,
                () -> clienteUseCase.inserir(clienteFisica)
        );

        verify(clienteOutputPort, never()).inserir(clienteFisica);
        assertEquals("CPF/CNPJ já está vinculado a outro Comprador", clienteCampoCpfCnpjEmUsoException.getMessage());
    }

    @Test
    public void naoDeveConseguirInserirClientePorInscricaoEstadualJaExistir() {
        when(validaClienteOutputPort.emailJaExiste(any())).thenReturn(false);
        when(validaClienteOutputPort.cpfCnpjJaExiste(any())).thenReturn(false);
        when(validaClienteOutputPort.inscricaoEstadualJaExiste(any())).thenReturn(true);

        ClienteCampoInscricaoEstadualEmUsoException clienteCampoInscricaoEstadualEmUsoException = assertThrows(ClienteCampoInscricaoEstadualEmUsoException.class,
                () -> clienteUseCase.inserir(clienteJuridica)
        );

        verify(clienteOutputPort, never()).inserir(clienteJuridica);
        assertEquals("Inscrição Estadual já está vinculada a outro Comprador", clienteCampoInscricaoEstadualEmUsoException.getMessage());
    }

}