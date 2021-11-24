package com.jnpc.spring.Test;

import com.jnpc.spring.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class VentaServiceTest {

    @Autowired
    private VentaRepository ventaRepository;

}
