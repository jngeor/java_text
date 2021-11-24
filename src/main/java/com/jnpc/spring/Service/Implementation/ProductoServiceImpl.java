package com.jnpc.spring.Service.Implementation;

import com.jnpc.spring.Service.Interface.IProductoService;
import com.jnpc.spring.models.entity.Producto;
import com.jnpc.spring.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto insProducto(Producto producto) {
        productoRepository.save(producto);
        return producto;
    }

    @Override
    @Transactional
    public Producto updProducto(Producto producto) {
        Producto item = productoRepository.findById(producto.getIdProducto()).get();
        item.setNommbre(producto.getNommbre());
        item.setPrecio(producto.getPrecio());
        productoRepository.save(item);

        return item;
    }

    @Override
    @Transactional
    public int delProducto(Long id) {
        Producto item = productoRepository.findById(id).get();
        productoRepository.delete(item);
        return 0;
    }
}
