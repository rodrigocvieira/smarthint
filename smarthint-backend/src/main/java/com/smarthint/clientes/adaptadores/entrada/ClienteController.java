package com.smarthint.clientes.adaptadores.entrada;

import com.smarthint.clientes.adaptadores.ClienteMapper;
import com.smarthint.clientes.adaptadores.ErrorResponse;
import com.smarthint.clientes.adaptadores.entrada.request.ClienteRequest;
import com.smarthint.clientes.adaptadores.entrada.response.ClienteResponse;
import com.smarthint.clientes.aplicacao.core.dominios.Cliente;
import com.smarthint.clientes.aplicacao.core.dto.PaginacaoDTO;
import com.smarthint.clientes.aplicacao.portas.entradas.ClienteInputPort;
import com.smarthint.clientes.aplicacao.portas.entradas.ObterClienteInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteInputPort clienteInputPort;

    @Autowired
    private ObterClienteInputPort obterClienteInputPort;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private RedisService redisService;

    @Operation(summary = "Inserir novos clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente cadastrado."),
            @ApiResponse(responseCode = "400",
                    description = "Atributo(s) não informado ou vazio na request.",
                    content = {
                            @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ErrorResponse.class))
                    }),
            @ApiResponse(responseCode = "409",
                    description = "Atributo(s) invalido ou informação ja cadastrado para outro comprador.",
                    content = {
                            @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ErrorResponse.class))
                    }),
    })
    @PostMapping("inserir")
    public ResponseEntity<ClienteResponse> inserir(
            @Valid
            @RequestBody ClienteRequest clienteRequest) {

        clienteInputPort.inserir(clienteMapper.toCliente(clienteRequest));
        redisService.limparCache();

        return new ResponseEntity<>(new ClienteResponse("Cliente cadastrado com sucesso!"),
                HttpStatus.CREATED
        );
    }

    @Operation(summary = "Editar cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente editado."),
            @ApiResponse(responseCode = "400",
                    description = "Atributo(s) não informado ou vazio na request.",
                    content = {
                            @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ErrorResponse.class))
                    }),
            @ApiResponse(responseCode = "409",
                    description = "Atributo(s) invalido ou informação ja cadastrado para outro comprador.",
                    content = {
                            @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ErrorResponse.class))
                    }),
            @ApiResponse(responseCode = "404",
                    description = "Cliente não encontrado",
                    content = {
                            @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ErrorResponse.class))
                    }),
    })
    @PutMapping("{id}")
    public ResponseEntity<ClienteResponse> editar(
            @PathVariable("id") String id,
            @Valid
            @RequestBody ClienteRequest clienteRequest) {

        clienteInputPort.editar(id, clienteMapper.toCliente(clienteRequest));
        redisService.limparCache();

        return new ResponseEntity<>(new ClienteResponse("Cliente alterado com sucesso!"),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Obter informacoes de cliente dado seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna dados de um cliente"),
            @ApiResponse(responseCode = "404",
                    description = "Cliente não encontrado",
                    content = {
                            @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ErrorResponse.class))
                    }),
    })
    @GetMapping("{id}")
    public ResponseEntity<Cliente> obterPorId(
            @PathVariable("id") String id
    ) {
        return new ResponseEntity<>(obterClienteInputPort.obterPorId(id), HttpStatus.OK);
    }

    @Operation(summary = "Obter informacoes de varios clientes por pagina")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna dados de clientes por pagina")
    })
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
