package com.jnpc.spring.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="detalle_venta")
public class DetalleVenta {
    @Id
    private Long idDetalleVenta;
    private Long idVenta;
    private Long idProducto;
}
