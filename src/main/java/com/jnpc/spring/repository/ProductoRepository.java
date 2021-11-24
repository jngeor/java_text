package com.jnpc.spring.repository;

import com.jnpc.spring.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
