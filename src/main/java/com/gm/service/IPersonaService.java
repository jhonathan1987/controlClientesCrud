
package com.gm.service;

import com.gm.dominio.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> listarPersona();
    public void guardar(Persona per);
    public void eliminar(Persona p);
    public Persona encontrarPersona(Persona p);
    
}
