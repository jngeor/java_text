package com.jnpc.spring.Service.Implementation;

import com.jnpc.spring.models.entity.Usuario;
import com.jnpc.spring.repository.UsuarioRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    final static Logger logger = Logger.getLogger(UsuarioService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUserName(username);
        if(usuario == null)
        {
            logger.error("Usuario no encontrado: " + username);
            throw new UsernameNotFoundException("No existe Usuario");
        }

        logger.debug("Usuario encontrado: " + username);

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority((rol.getNombre())))
                .collect(Collectors.toList());
        return new User(usuario.getUserName(), usuario.getPassword(), true, true, true, true, authorities);
    }
}
