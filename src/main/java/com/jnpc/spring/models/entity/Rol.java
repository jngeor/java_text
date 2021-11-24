package com.jnpc.spring.models.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Rol {
    @Id
    private Long idRol;
    @Column(length = 20)
    private String nombre;
}
