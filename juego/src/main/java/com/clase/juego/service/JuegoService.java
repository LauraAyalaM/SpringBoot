package com.clase.juego.service; // Define el paquete de la capa de servicio

import com.clase.juego.model.JuegoSesion; // Importa el modelo de la sesión
import org.springframework.stereotype.Service; // Marca la clase como un componente de servicio de Spring
import java.util.Random; // Importa la utilidad para generar números aleatorios

@Service // Indica a Spring que esta clase contiene la lógica de negocio
public class JuegoService {

    private static final int MAX_INTENTOS = 7; // Define el límite constante de intentos
    private static final int MIN = 1;           // Define el valor mínimo del número secreto
    private static final int MAX = 100;         // Define el valor máximo del número secreto

    private JuegoSesion sesionActual; // Almacena la sesión de juego activa en memoria

    // Método para inicializar un juego nuevo
    public JuegoSesion nuevaPartida() {
        // Genera un número aleatorio entre 1 y 100
        int secreto = new Random().nextInt(MAX - MIN + 1) + MIN;
        // Crea una nueva instancia de la sesión con el número y el máximo de intentos
        sesionActual = new JuegoSesion(secreto, MAX_INTENTOS);
        return sesionActual; // Retorna la sesión creada
    }

    // Método para recuperar la sesión actual sin crear una nueva
    public JuegoSesion getSesion() {
        return sesionActual;
    }

    // Método principal con la lógica para procesar un intento del jugador
    public String adivinar(int numero) {
        // Valida si no hay una partida iniciada o si ya finalizó
        if (sesionActual == null || sesionActual.isTerminado()) {
            return "SIN_JUEGO"; // Retorna un estado de error o control
        }

        // Incrementa el contador de intentos realizados en la sesión
        sesionActual.setIntentos(sesionActual.getIntentos() + 1);
        int secreto = sesionActual.getNumeroSecreto(); // Obtiene el número a adivinar
        String pista; // Variable para guardar el resultado de la comparación

        // Estructura de decisión para determinar el resultado del intento
        if (numero == secreto) {
            sesionActual.setGano(true);                   // Registra la victoria
            sesionActual.setTerminado(true);              // Finaliza la partida
            pista = "GANO";
        } else if (sesionActual.getIntentos() >= sesionActual.getMaxIntentos()) {
            pista = "PERDIO";                             // Se agotaron los intentos
            sesionActual.setTerminado(true);              // Finaliza la partida
        } else {
            // Calcula la distancia absoluta entre el número secreto y el ingresado
            int diferencia = Math.abs(secreto - numero);
            // Asigna una pista basada en qué tan cerca está el usuario
            if      (diferencia <= 5)   pista = "MUY_CALIENTE"; // Muy cerca (5 o menos)
            else if (diferencia <= 15)  pista = "CALIENTE";     // Cerca (6 a 15)
            else if (diferencia <= 30)  pista = "TIBIO";        // Algo lejos (16 a 30)
            else                        pista = "FRIO";          // Muy lejos (más de 30)
        }

        // Determina el emoji visual basado en la pista obtenida
        String emoji = switch (pista) {
            case "GANO"         -> "🎉";
            case "PERDIO"       -> "💀";
            case "MUY_CALIENTE" -> "🔥";
            case "CALIENTE"     -> "♨️";
            case "TIBIO"        -> "😐";
            case "FRIO"         -> "🧊";
            default             -> "❓";
        };

        // Construye la cadena de texto para el historial y la añade a la sesión
        sesionActual.agregarIntento(
            "Intento " + sesionActual.getIntentos() + ": " + numero + " = " + emoji
        );

        return pista; // Retorna el código del resultado (ej. "GANO", "FRIO", etc.)
    }
}