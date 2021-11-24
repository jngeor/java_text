package com.jnpc.spring.Test;

import com.jnpc.spring.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductoServiceTest {

    @Autowired
    private ProductoRepository productoRepository;

}
