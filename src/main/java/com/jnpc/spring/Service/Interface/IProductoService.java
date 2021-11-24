package com.jnpc.spring.Service.Interface;

import com.jnpc.spring.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();
    public Producto findById(Long id);
    public Producto insProducto(Producto producto);
    public Producto updProducto(Producto producto);
    public int delProducto(Long id);

}
