package com.clase.calculadora.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Clase que representa el formulario de la calculadora
public class CalculadoraForm {

    @NotNull(message = "El primer número es obligatorio") // Valida número A
    private Double numeroA;

    @NotNull(message = "El segundo número es obligatorio") // Valida número B
    private Double numeroB;

    @NotBlank(message = "Debes elegir una operación") // Valida operación
    private String operacion;

    // ===== GETTERS Y SETTERS =====

    public Double getNumeroA() { return numeroA; } // Obtener número A

    public void setNumeroA(Double numeroA) {
        this.numeroA = numeroA; // Asignar número A
    }

    public Double getNumeroB() { return numeroB; } // Obtener número B

    public void setNumeroB(Double numeroB) {
        this.numeroB = numeroB; // Asignar número B
    }

    public String getOperacion() { return operacion; } // Obtener operación

    public void setOperacion(String op) {
        this.operacion = op; // Asignar operación
    }
}