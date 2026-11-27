package com.sertti.tramites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de arranque del módulo web SERTTI Tránsito La Jagua.
 * Implementa el framework Spring Boot para la gestión ágil de trámites vehiculares y de conductores.
 *
 * @author Jhon Jairo Marriaga Ortiz
 * @version 1.0.0
 */
@SpringBootApplication
public class SerttiTramitesApplication {

    /**
     * Método principal que inicia el contexto del framework Spring Boot.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(SerttiTramitesApplication.class, args);
    }
}
