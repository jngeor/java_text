package com.jnpc.spring.models.dto;

import lombok.Data;

@Data
public class DetalleVentaDto {
    private Long idDetalleVenta;
    private Long idVenta;
    private Long idProducto;
}
