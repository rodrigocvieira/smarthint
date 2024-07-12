package com.smarthint.clientes.adaptadores.entrada;

import com.smarthint.clientes.adaptadores.entrada.request.InserirClienteRequest;
import com.smarthint.clientes.adaptadores.entrada.response.ClienteResponse;
import com.smarthint.clientes.aplicacao.portas.entradas.InserirClienteInputPort;
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

    @PostMapping("inserir")
    public ResponseEntity<ClienteResponse> inserir(
            @RequestBody InserirClienteRequest inserirClienteRequest) {

        return new ResponseEntity<>(new ClienteResponse("teste"),
                HttpStatus.CREATED
        );
    }
}
