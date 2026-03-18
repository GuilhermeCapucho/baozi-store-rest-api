package com.baozistore.api.dto;

import java.math.BigDecimal;

public class PedidoResponse {

    private Long id;
    private Long clienteId;
    private String clienteNome;
    private Long produtoId;
    private String produtoNome;
    private BigDecimal produtoPreco;
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public BigDecimal getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(BigDecimal produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
