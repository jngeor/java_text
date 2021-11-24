package com.jnpc.spring.Service.Interface;

import com.jnpc.spring.models.dto.VentaDto;
import com.jnpc.spring.models.entity.Venta;

import java.util.List;

public interface IVentaService {

    public List<VentaDto> findAll();
    public VentaDto findById(Long id);
    public Venta insVenta(VentaDto ventaDto);

}
