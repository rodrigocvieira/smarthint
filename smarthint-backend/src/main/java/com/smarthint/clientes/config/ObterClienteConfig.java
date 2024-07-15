package com.smarthint.clientes.config;

import com.smarthint.clientes.aplicacao.core.casoDeUso.ObterClienteUseCase;
import com.smarthint.clientes.aplicacao.portas.entradas.ObterClienteInputPort;
import com.smarthint.clientes.aplicacao.portas.saidas.ObterClienteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObterClienteConfig {

    @Bean
    public ObterClienteInputPort obterClienteInputPort(
            ObterClienteOutputPort obterClienteOutputPort
    ) {
        return new ObterClienteUseCase(obterClienteOutputPort);
    }
}
