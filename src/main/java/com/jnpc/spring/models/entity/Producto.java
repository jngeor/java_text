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
@Table(name="producto")
public class Producto {

    @Id
    private Long idProducto;
    @Column(length = 50)
    private String nommbre;
    @Column(precision = 2)
    private Double precio;
}
