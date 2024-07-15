package com.smarthint.clientes.adaptadores.entrada;

import com.smarthint.clientes.aplicacao.core.dto.PaginacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    public static final String KEY_CLIENTE = "CLIENTE";
    @Autowired
    private RedisTemplate<String, PaginacaoDTO> redisTemplate;

    public void gravar(int paginacao, PaginacaoDTO paginacaoDTO) {
        redisTemplate.opsForHash().put(KEY_CLIENTE, String.valueOf(paginacao), paginacaoDTO);
    }

    public PaginacaoDTO obterPorPagina(int paginacao) {
        return (PaginacaoDTO) redisTemplate.opsForHash().get(KEY_CLIENTE, String.valueOf(paginacao));
    }

    public void limparCache() {
        redisTemplate.delete(KEY_CLIENTE);
    }
}
