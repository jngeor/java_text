package com.jnpc.spring.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="cliente")
public class Cliente {
    @Id
    private Long idCliente;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String apellido;
    @Column(length = 8)
    private String dni;
    @Column(length = 11)
    private String telefono;
    @Column(length = 100)
    private String email;
}
