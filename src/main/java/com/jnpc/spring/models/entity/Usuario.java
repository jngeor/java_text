package com.jnpc.spring.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Usuario {

    @Id
    private Long IiUsuario;
    @Column(length = 20)
    private String userName;
    @Column(length = 200)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="usuario_rol", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "rolId"))
    private List<Rol> roles;
}
