package com.baozistore.api.service;

import com.baozistore.api.dto.ClienteRequest;
import com.baozistore.api.exception.ResourceNotFoundException;
import com.baozistore.api.model.Cliente;
import com.baozistore.api.repository.ClienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criar(ClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setNome(request.getNome());
        cliente.setClienteDesde(request.getClienteDesde());
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente nao encontrado para o id " + id));
    }

    public Cliente atualizar(Long id, ClienteRequest request) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(request.getNome());
        cliente.setClienteDesde(request.getClienteDesde());
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }
}
