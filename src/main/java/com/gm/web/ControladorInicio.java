package com.gm.web;

import com.gm.dominio.Persona;
import com.gm.service.IPersonaService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        //Iterable

        List<Persona> personas = personaService.listarPersona();

        model.addAttribute("personas", personas);
        log.info("usuario que hizo login " + user);

        double saldoTotal = 0;
        for (Persona p : personas) {
            saldoTotal += p.getSaldo();
        }

        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());

        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {

        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            System.out.println("entro");
            return "modificar";

        }
        personaService.guardar(persona);
        System.out.println("No entro");
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona, Model model) {
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
