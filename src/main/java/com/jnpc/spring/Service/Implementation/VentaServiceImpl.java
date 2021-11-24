package com.jnpc.spring.Service.Implementation;

import com.jnpc.spring.Service.Interface.IVentaService;
import com.jnpc.spring.models.dto.DetalleVentaDto;
import com.jnpc.spring.models.dto.VentaDto;
import com.jnpc.spring.models.entity.DetalleVenta;
import com.jnpc.spring.models.entity.Venta;
import com.jnpc.spring.repository.DetalleVentaRepository;
import com.jnpc.spring.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {
    
    @Autowired
    private VentaRepository ventaRepository;
    
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    
    @Override
    public List<VentaDto> findAll() {
        List<VentaDto> result = new ArrayList<>();
        List<Venta> ventas = ventaRepository.findAll();
        for(Venta v:ventas)
        {
            VentaDto item = new VentaDto();
            item.setIdVenta(v.getIdVenta());
            item.setIdCliente(v.getIdCliente());
            item.setFecha(v.getFecha());

            List<DetalleVenta> detalle = detalleVentaRepository.findbyId(v.getIdVenta());
            List<DetalleVentaDto> detResult = new ArrayList<>();
            for(DetalleVenta d:detalle)
            {
                DetalleVentaDto det = new DetalleVentaDto();
                det.setIdVenta(d.getIdVenta());
                det.setIdProducto(d.getIdProducto());
                det.setIdDetalleVenta(d.getIdDetalleVenta());
                detResult.add(det);
            }

            result.add(item);
        }

        return  result;
    }

    @Override
    public VentaDto findById(Long id) {
        VentaDto item = new VentaDto();
        Venta venta = ventaRepository.findById(id).orElse(null);
        if(venta != null){
            item.setIdVenta(venta.getIdVenta());
            item.setIdCliente(venta.getIdCliente());
            item.setFecha(venta.getFecha());

            List<DetalleVenta> detalle = detalleVentaRepository.findbyId(venta.getIdVenta());
            List<DetalleVentaDto> detResult = new ArrayList<>();
            for(DetalleVenta d:detalle)
            {
                DetalleVentaDto det = new DetalleVentaDto();
                det.setIdVenta(d.getIdVenta());
                det.setIdProducto(d.getIdProducto());
                det.setIdDetalleVenta(d.getIdDetalleVenta());
                detResult.add(det);
            }
            item.setDetalle(detResult);
        }

        return item;
    }

    @Override
    public Venta insVenta(VentaDto ventaDto) {

        Venta venta = new Venta();
        venta.setIdVenta(ventaDto.getIdVenta());
        venta.setIdCliente(ventaDto.getIdCliente());
        venta.setFecha(ventaDto.getFecha());

        ventaRepository.save(venta);

        for(DetalleVentaDto d: ventaDto.getDetalle())
        {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setIdDetalleVenta(d.getIdDetalleVenta());
            detalle.setIdVenta(d.getIdVenta());
            detalle.setIdProducto(d.getIdProducto());

            detalleVentaRepository.save(detalle);
        }

        return venta;
    }
}
