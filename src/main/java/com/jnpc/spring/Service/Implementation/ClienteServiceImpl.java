package com.jnpc.spring.Service.Implementation;

import com.jnpc.spring.Service.Interface.IClienteService;
import com.jnpc.spring.models.entity.Cliente;
import com.jnpc.spring.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente insCliente(Cliente cliente) {
        clienteRepository.save(cliente);

        return cliente;
    }
}
