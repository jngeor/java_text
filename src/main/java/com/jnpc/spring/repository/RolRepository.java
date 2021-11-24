package com.jnpc.spring.repository;

import com.jnpc.spring.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "rol")
public interface RolRepository extends JpaRepository<Rol, Long> {
}
