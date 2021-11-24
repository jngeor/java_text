package com.jnpc.spring.Controller;

import com.jnpc.spring.Service.Interface.IProductoService;
import com.jnpc.spring.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll()
    {
        List<Producto> productos = productoService.findAll();
        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return  ResponseEntity.ok(productos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Producto> findAllById(@PathVariable("id") Long id)
    {
        Producto producto = productoService.findById(id);
        if(producto == null){
            return ResponseEntity.noContent().build();
        }

        return  ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Producto> insProducto(@RequestBody Producto producto){
        Producto prod = productoService.insProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(prod);
    }

    @PutMapping
    public ResponseEntity<Producto> updProducto(@RequestBody Producto producto){
        Producto prod = productoService.updProducto(producto);
        return ResponseEntity.ok(prod);
    }

    @DeleteMapping(value = "{id}")
    public int delProducto(@PathVariable Long id){
        return productoService.delProducto(id);
    }
}
