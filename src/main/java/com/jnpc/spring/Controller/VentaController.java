package com.jnpc.spring.Controller;

import com.jnpc.spring.Service.Interface.IVentaService;
import com.jnpc.spring.models.dto.VentaDto;
import com.jnpc.spring.models.entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/venta")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public ResponseEntity<List<VentaDto>> findAll(){
        List<VentaDto> ventas = ventaService.findAll();
        if(ventas.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(ventas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VentaDto> findById(@PathVariable("id")  Long id)
    {
        VentaDto ventaDto = ventaService.findById(id);
        if(ventaDto == null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(ventaDto);
    }

    @PostMapping
    public ResponseEntity<Venta> insVenta(@RequestBody VentaDto ventaDto){
        Venta venta = ventaService.insVenta(ventaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(venta);
    }
}
