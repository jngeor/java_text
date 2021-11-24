package com.jnpc.spring.models.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class VentaDto {

    private Long idVenta;
    private Long idCliente;
    private Date fecha;

    private List<DetalleVentaDto> detalle;
}
