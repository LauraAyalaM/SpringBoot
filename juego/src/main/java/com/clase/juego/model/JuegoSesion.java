package com.clase.juego.model; // Define el paquete al que pertenece la clase

import java.util.ArrayList;   // Importa la implementación de lista dinámica
import java.util.List;         // Importa la interfaz List para manejar colecciones

public class JuegoSesion {

    private int numeroSecreto;             // Almacena el número que el jugador debe adivinar
    private int intentos;                  // Contador de intentos realizados por el usuario
    private int maxIntentos;              // Límite máximo de intentos permitidos
    private boolean terminado;            // Indica si el juego ha finalizado (por victoria o derrota)
    private boolean gano;                 // Indica si el usuario logró adivinar el número
    private List<String> historialIntentos; // Lista que guarde el registro de cada intento realizado

    // Constructor para inicializar una nueva sesión de juego
    public JuegoSesion(int numeroSecreto, int maxIntentos) {
        this.numeroSecreto  = numeroSecreto;   // Asigna el número a adivinar
        this.maxIntentos    = maxIntentos;     // Establece el tope de intentos
        this.intentos       = 0;               // Inicializa el contador en cero
        this.terminado      = false;           // El juego comienza activo
        this.gano           = false;           // El estado de victoria empieza en falso
        this.historialIntentos = new ArrayList<>(); // Crea la lista vacía para el historial
    }

    // Métodos Getter y Setter (Encapsulamiento)
    public int getNumeroSecreto()               { return numeroSecreto; }   // Obtiene el número secreto
    public int getIntentos()                    { return intentos; }         // Obtiene intentos actuales
    public void setIntentos(int intentos)       { this.intentos = intentos; } // Actualiza el contador de intentos
    public int getMaxIntentos()                 { return maxIntentos; }      // Obtiene el limite de intentos
    public boolean isTerminado()                { return terminado; }        // Verifica si el juego acabó
    public void setTerminado(boolean t)         { this.terminado = t; }      // Cambia el estado de finalización
    public boolean isGano()                     { return gano; }             // Verifica si el jugador ganó
    public void setGano(boolean gano)           { this.gano = gano; }        // Cambia el estado de victoria
    public List<String> getHistorialIntentos()  { return historialIntentos; } // Obtiene la lista de intentos
    public void agregarIntento(String intento)  { this.historialIntentos.add(intento); } // Añade un mensaje al historial
    public int getIntentosRestantes()           { return maxIntentos - intentos; } // Calcula cuántas oportunidades quedan
}