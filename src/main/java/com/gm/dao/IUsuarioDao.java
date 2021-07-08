package com.gm.dao;

import com.gm.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}
