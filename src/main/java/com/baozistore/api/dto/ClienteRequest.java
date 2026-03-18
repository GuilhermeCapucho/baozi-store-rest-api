package com.baozistore.api.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank(message = "O nome do cliente e obrigatorio.")
    private String nome;

    @NotNull(message = "A data clienteDesde e obrigatoria.")
    private LocalDate clienteDesde;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getClienteDesde() {
        return clienteDesde;
    }

    public void setClienteDesde(LocalDate clienteDesde) {
        this.clienteDesde = clienteDesde;
    }
}
