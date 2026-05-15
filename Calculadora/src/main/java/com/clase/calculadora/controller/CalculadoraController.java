package com.clase.calculadora.controller;

import com.clase.calculadora.model.*;
import com.clase.calculadora.service.CalculadoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

// Indica que esta clase es un controlador MVC
@Controller
// Ruta base del controlador
@RequestMapping("/calculadora")
public class CalculadoraController {

    // Inyección automática del servicio
    @Autowired
    private CalculadoraService service;

    // ---------------------------
    // GET /calculadora
    // Muestra el formulario vacío
    // ---------------------------
    @GetMapping
    public String mostrarFormulario(Model model) {
        // Enviar objeto vacío al formulario
        model.addAttribute("form", new CalculadoraForm());
        // Enviar historial de operaciones
        model.addAttribute("historial", service.getHistorial());
        // Retornar la vista calculadora.html
        return "calculadora";
    }

    // ---------------------------
    // POST /calculadora
    // Procesa el formulario
    // ---------------------------
    @PostMapping
    public String procesar(
        // Valida automáticamente el formulario
        @Valid @ModelAttribute("form") CalculadoraForm form,
        // Guarda errores de validación
        BindingResult errores,
        // Permite enviar datos a la vista
        Model model) {

        // Si hay errores, volver al formulario
        if (errores.hasErrors()) {
            // Mantener historial
            model.addAttribute("historial", service.getHistorial());
            return "calculadora";
        }

        // Llamar al servicio para calcular
        Operacion resultado = service.calcular(
            form.getNumeroA(),
            form.getNumeroB(),
            form.getOperacion()
        );

        // Enviar resultado a la vista
        model.addAttribute("resultado", resultado);

        // Limpiar formulario
        model.addAttribute("form", new CalculadoraForm());

        // Enviar historial actualizado
        model.addAttribute("historial", service.getHistorial());

        // Retornar nuevamente la vista
        return "calculadora";
    }
}