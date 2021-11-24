package com.jnpc.spring.Controller;

import com.jnpc.spring.Service.Interface.IClienteService;
import com.jnpc.spring.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> insCliente(@RequestBody Cliente cliente){
        Cliente cli = clienteService.insCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cli);
    }

}
