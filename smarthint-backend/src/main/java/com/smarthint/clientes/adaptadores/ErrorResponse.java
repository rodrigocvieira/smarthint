package com.smarthint.clientes.adaptadores;

import java.io.Serializable;

public record ErrorResponse(String mensagem)
        implements Serializable {
}
