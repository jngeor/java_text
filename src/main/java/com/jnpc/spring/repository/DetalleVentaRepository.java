package com.jnpc.spring.repository;

import com.jnpc.spring.models.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    List<DetalleVenta> findbyId(Long Id);
}
