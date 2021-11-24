package com.jnpc.spring.repository;

import com.jnpc.spring.models.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
