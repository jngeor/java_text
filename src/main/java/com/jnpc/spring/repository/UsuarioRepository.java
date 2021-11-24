package com.jnpc.spring.repository;

import com.jnpc.spring.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "usuarios")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByUserName(String userName);
}
