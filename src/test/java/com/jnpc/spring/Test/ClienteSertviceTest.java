package com.jnpc.spring.Test;

import com.jnpc.spring.models.entity.Cliente;
import com.jnpc.spring.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ClienteSertviceTest {

    @Autowired
    private ClienteRepository clienteRepository;

    public void  whenInsCliente(){
        Cliente cliente01 = Cliente.builder()
                .idCliente(1L)
                .apellido("Tabara")
                .nombre("Carlos")
                .dni("00403987")
                .email("hola@hola.com")
                .telefono("40264478").build();

        Cliente r = clienteRepository.save(cliente01);

        Cliente cliente = clienteRepository.getById(1L);
        Assertions.assertEquals(r.getIdCliente(), cliente.getIdCliente());
        Assertions.assertEquals(r.getApellido(), cliente.getApellido());
    }

}
