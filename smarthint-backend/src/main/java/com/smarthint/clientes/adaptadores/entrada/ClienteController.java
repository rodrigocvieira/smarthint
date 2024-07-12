package com.smarthint.clientes.adaptadores.entrada;

import com.smarthint.clientes.adaptadores.ClienteMapper;
import com.smarthint.clientes.adaptadores.entrada.request.InserirClienteRequest;
import com.smarthint.clientes.adaptadores.entrada.response.ClienteResponse;
import com.smarthint.clientes.aplicacao.portas.entradas.InserirClienteInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private InserirClienteInputPort inserirClienteInputPort;

    @Autowired
    private ClienteMapper clienteMapper;

    @PostMapping("inserir")
    public ResponseEntity<ClienteResponse> inserir(
            @Valid
            @RequestBody InserirClienteRequest inserirClienteRequest) {

        inserirClienteInputPort.inserir(clienteMapper.toCliente(inserirClienteRequest));

        return new ResponseEntity<>(new ClienteResponse("Cliente cadastrado com sucesso!"),
                HttpStatus.CREATED
        );
    }
}
