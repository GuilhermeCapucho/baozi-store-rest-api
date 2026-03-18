package com.baozistore.api.service;

import com.baozistore.api.dto.ProdutoRequest;
import com.baozistore.api.exception.ResourceNotFoundException;
import com.baozistore.api.model.Produto;
import com.baozistore.api.repository.ProdutoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto criar(ProdutoRequest request) {
        Produto produto = new Produto();
        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        produto.setEstoque(request.getEstoque());
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto nao encontrado para o id " + id));
    }

    public Produto atualizar(Long id, ProdutoRequest request) {
        Produto produto = buscarPorId(id);
        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        produto.setEstoque(request.getEstoque());
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = buscarPorId(id);
        produtoRepository.delete(produto);
    }
}
