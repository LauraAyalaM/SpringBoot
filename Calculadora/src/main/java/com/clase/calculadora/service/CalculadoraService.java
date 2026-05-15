package com.clase.calculadora.service;

import com.clase.calculadora.model.Operacion;
import org.springframework.stereotype.Service;
import java.util.*;

// Indica que esta clase es un servicio de Spring
@Service
public class CalculadoraService {

    // Lista donde se guarda el historial de operaciones
    private final List<Operacion> historial = new ArrayList<>();

    // Contador para asignar IDs automáticos
    private long contador = 1L;

    // Método principal que realiza las operaciones
    public Operacion calcular(double a, double b, String op) {

        // Crear nueva operación
        Operacion o = new Operacion();

        // Asignar datos básicos
        o.setId(contador++);
        o.setNumeroA(a);
        o.setNumeroB(b);
        o.setTipo(op);

        // Evaluar qué operación se va a realizar
        switch (op) {
            // Suma
            case "suma" ->
                o.setResultado(a + b);
            // Resta
            case "resta" ->
                o.setResultado(a - b);
            // Multiplicación
            case "multiplicacion" ->
                o.setResultado(a * b);
            // División
            case "division" -> {
                // Validar división entre cero
                if (b == 0)
                    o.setError("No se puede dividir entre cero");
                else
                    o.setResultado(a / b);
            }
            // Si la operación no existe
            default ->
                o.setError("Operación desconocida: " + op);
        }

        // Guardar operación en el historial
        historial.add(o);

        // Retornar resultado final
        return o;
    }

    // Retorna el historial completo
    public List<Operacion> getHistorial() {
        // Evita modificar la lista original
        return Collections.unmodifiableList(historial);
    }
}