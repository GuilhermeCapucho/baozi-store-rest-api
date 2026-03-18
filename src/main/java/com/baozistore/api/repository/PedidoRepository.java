package com.baozistore.api.repository;

import com.baozistore.api.model.Pedido;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Override
    @EntityGraph(attributePaths = {"cliente", "produto"})
    List<Pedido> findAll();

    @Override
    @EntityGraph(attributePaths = {"cliente", "produto"})
    Optional<Pedido> findById(Long id);
}
