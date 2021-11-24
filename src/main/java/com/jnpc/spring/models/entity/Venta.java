package com.jnpc.spring.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="venta")
public class Venta {

    @Id
    private Long idVenta;
    private Long idCliente;
    @Temporal(TemporalType.DATE)
    private Date fecha;
}
