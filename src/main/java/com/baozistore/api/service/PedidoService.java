package com.baozistore.api.service;

import com.baozistore.api.dto.PedidoRequest;
import com.baozistore.api.dto.PedidoResponse;
import com.baozistore.api.exception.ResourceNotFoundException;
import com.baozistore.api.model.Cliente;
import com.baozistore.api.model.Pedido;
import com.baozistore.api.model.Produto;
import com.baozistore.api.repository.PedidoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService, ProdutoService produtoService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    public PedidoResponse criar(PedidoRequest request) {
        Pedido pedido = new Pedido();
        preencherPedido(pedido, request);
        return toResponse(pedidoRepository.save(pedido));
    }

    public List<PedidoResponse> listarTodos() {
        return pedidoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public PedidoResponse buscarPorId(Long id) {
        return toResponse(buscarEntidade(id));
    }

    public PedidoResponse atualizar(Long id, PedidoRequest request) {
        Pedido pedido = buscarEntidade(id);
        preencherPedido(pedido, request);
        return toResponse(pedidoRepository.save(pedido));
    }

    public void deletar(Long id) {
        Pedido pedido = buscarEntidade(id);
        pedidoRepository.delete(pedido);
    }

    private Pedido buscarEntidade(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido nao encontrado para o id " + id));
    }

    private void preencherPedido(Pedido pedido, PedidoRequest request) {
        Cliente cliente = clienteService.buscarPorId(request.getClienteId());
        Produto produto = produtoService.buscarPorId(request.getProdutoId());
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(request.getQuantidade());
    }

    private PedidoResponse toResponse(Pedido pedido) {
        PedidoResponse response = new PedidoResponse();
        response.setId(pedido.getId());
        response.setClienteId(pedido.getCliente().getId());
        response.setClienteNome(pedido.getCliente().getNome());
        response.setProdutoId(pedido.getProduto().getId());
        response.setProdutoNome(pedido.getProduto().getNome());
        response.setProdutoPreco(pedido.getProduto().getPreco());
        response.setQuantidade(pedido.getQuantidade());
        return response;
    }
}
