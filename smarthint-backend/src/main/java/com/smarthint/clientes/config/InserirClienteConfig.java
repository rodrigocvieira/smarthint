package com.smarthint.clientes.config;

import com.smarthint.clientes.adaptadores.saida.InserirClienteAdapter;
import com.smarthint.clientes.aplicacao.core.casoDeUso.InserirClienteUseCase;
import com.smarthint.clientes.aplicacao.portas.entradas.InserirClienteInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirClienteConfig {

    @Bean
    public InserirClienteInputPort inserirClienteInputPort(
            InserirClienteAdapter inserirClienteAdapter
    ) {
        return new InserirClienteUseCase(inserirClienteAdapter);
    }
}
