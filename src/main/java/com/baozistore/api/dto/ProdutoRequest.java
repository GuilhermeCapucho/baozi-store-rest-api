package com.baozistore.api.dto;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoRequest {

    @NotBlank(message = "O nome do produto e obrigatorio.")
    private String nome;

    @NotNull(message = "O preco e obrigatorio.")
    @DecimalMin(value = "0.01", message = "O preco deve ser maior que zero.")
    private BigDecimal preco;

    @NotNull(message = "O estoque e obrigatorio.")
    private Boolean estoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Boolean getEstoque() {
        return estoque;
    }

    public void setEstoque(Boolean estoque) {
        this.estoque = estoque;
    }
}
