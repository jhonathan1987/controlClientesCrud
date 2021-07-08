package com.gm.service;

import com.gm.dao.IPersonaDao;
import com.gm.dominio.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersona() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona per) {
        personaDao.save(per);
    }

    @Override
    @Transactional
    public void eliminar(Persona p) {
        personaDao.delete(p);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona p) {
        return personaDao.findById(p.getId()).orElse(null);
    }

}
