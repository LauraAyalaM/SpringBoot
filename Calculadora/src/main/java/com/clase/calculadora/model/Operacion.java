package com.clase.calculadora.model;

// Modelo que representa una operación matemática
public class Operacion {

    // Identificador de la operación
    private long id;
    // Primer número ingresado
    private double numeroA;
    // Segundo número ingresado
    private double numeroB;
    // Tipo de operación: suma, resta, etc.
    private String tipo;
    // Resultado final de la operación
    private double resultado;
    // Mensaje de error si ocurre alguno
    private String error;

    // Constructor vacío — Spring MVC lo necesita para crear objetos automáticamente
    public Operacion() {}

    // Constructor con todos los datos principales
    public Operacion(long id, double a, double b, String tipo, double resultado) {
        this.id = id;
        this.numeroA = a;
        this.numeroB = b;
        this.tipo = tipo;
        this.resultado = resultado;
    }

    // ===== GETTERS Y SETTERS =====
    // Permiten acceder y modificar los atributos

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNumeroA() {
        return numeroA;
    }

    public void setNumeroA(double numeroA) {
        this.numeroA = numeroA;
    }

    public double getNumeroB() {
        return numeroB;
    }

    public void setNumeroB(double numeroB) {
        this.numeroB = numeroB;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}