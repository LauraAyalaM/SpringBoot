package com.clase.juego.model; // Define el paquete del modelo de formulario

import jakarta.validation.constraints.Max;     // Validación: valor máximo permitido
import jakarta.validation.constraints.Min;     // Validación: valor mínimo permitido
import jakarta.validation.constraints.NotNull; // Validación: el campo no puede estar vacío

public class JuegoForm {

    @NotNull(message = "Debes ingresar un número") // Error si el usuario envía el campo vacío
    @Min(value = 1,   message = "El número debe ser mayor o igual a 1")  // Límite inferior (1)
    @Max(value = 100, message = "El número debe ser menor o igual a 100") // Límite superior (100)
    private Integer numero; // Variable que recibe el número ingresado por el usuario

    // Métodos Getter y Setter
    public Integer getNumero()              { return numero; }               // Obtiene el número del formulario
    public void setNumero(Integer numero)   { this.numero = numero; }        // Asigna el número al formulario
}