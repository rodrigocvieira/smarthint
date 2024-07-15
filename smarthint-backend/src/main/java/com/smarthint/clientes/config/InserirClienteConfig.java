package com.smarthint.clientes.config;

import com.smarthint.clientes.adaptadores.saida.ClienteAdapter;
import com.smarthint.clientes.adaptadores.saida.ValidaClienteAdapter;
import com.smarthint.clientes.aplicacao.core.casoDeUso.ClienteUseCase;
import com.smarthint.clientes.aplicacao.portas.entradas.ClienteInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirClienteConfig {

    @Bean
    public ClienteInputPort inserirClienteInputPort(
            ClienteAdapter inserirClienteAdapter,
            ValidaClienteAdapter validaClienteAdapter
    ) {
        return new ClienteUseCase(inserirClienteAdapter, validaClienteAdapter);
    }
}
