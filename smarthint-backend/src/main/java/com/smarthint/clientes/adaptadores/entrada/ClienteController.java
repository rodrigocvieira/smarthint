package com.smarthint.clientes.adaptadores.entrada;

import com.smarthint.clientes.adaptadores.ClienteMapper;
import com.smarthint.clientes.adaptadores.entrada.request.InserirClienteRequest;
import com.smarthint.clientes.adaptadores.entrada.response.ClienteResponse;
import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.core.dto.PaginacaoDTO;
import com.smarthint.clientes.aplicacao.portas.entradas.InserirClienteInputPort;
import com.smarthint.clientes.aplicacao.portas.entradas.ObterClienteInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private InserirClienteInputPort inserirClienteInputPort;

    @Autowired
    private ObterClienteInputPort obterClienteInputPort;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private RedisService redisService;

    @PostMapping("inserir")
    public ResponseEntity<ClienteResponse> inserir(
            @Valid
            @RequestBody InserirClienteRequest inserirClienteRequest) {

        inserirClienteInputPort.inserir(clienteMapper.toCliente(inserirClienteRequest));
        redisService.limparCache();

        return new ResponseEntity<>(new ClienteResponse("Cliente cadastrado com sucesso!"),
                HttpStatus.CREATED
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> obterPorId(
            @PathVariable("id") String id
    ) {
        return new ResponseEntity<>(obterClienteInputPort.obterPorId(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<PaginacaoDTO> listarTodos(
            @RequestParam("paginacao") int paginacao
    ) {
        PaginacaoDTO paginaCache = redisService.obterPorPagina(paginacao);

        if (paginaCache != null)
            return new ResponseEntity<>(paginaCache, HttpStatus.OK);

        PaginacaoDTO paginaBanco = obterClienteInputPort.obterPaginado(paginacao);
        redisService.gravar(paginacao, paginaBanco);
        return new ResponseEntity<>(paginaBanco, HttpStatus.OK);
    }
}
