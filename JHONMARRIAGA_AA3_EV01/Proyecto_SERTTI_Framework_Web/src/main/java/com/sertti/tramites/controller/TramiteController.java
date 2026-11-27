package com.sertti.tramites.controller;

import com.sertti.tramites.model.Tramite;
import com.sertti.tramites.service.TramiteService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST del módulo web de SERTTI Tránsito La Jagua.
 * Expone los endpoints HTTP para registro, consulta y actualización de trámites.
 *
 * @author Jhon Jairo Marriaga Ortiz
 */
@RestController
@RequestMapping("/api/tramites")
public class TramiteController {

    private final TramiteService tramiteService;

    /**
     * Inyección del servicio de trámites.
     *
     * @param tramiteService capa de negocio
     */
    public TramiteController(TramiteService tramiteService) {
        this.tramiteService = tramiteService;
    }

    /**
     * Endpoint POST para radicar un nuevo trámite (traspaso, traslado, duplicado, etc.).
     *
     * @param tramite datos JSON validados del trámite
     * @return respuesta HTTP 201 Created con el trámite almacenado
     */
    @PostMapping
    public ResponseEntity<?> crearTramite(@Valid @RequestBody Tramite tramite) {
        try {
            Tramite guardado = tramiteService.registrarTramite(tramite);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.getMessage()));
        }
    }

    /**
     * Endpoint GET para listar todos los trámites almacenados en MySQL.
     *
     * @return lista completa de trámites
     */
    @GetMapping
    public ResponseEntity<List<Tramite>> obtenerTodos() {
        return ResponseEntity.ok(tramiteService.listarTodos());
    }

    /**
     * Endpoint GET para consultar un trámite puntual por número de radicado.
     *
     * @param radicado número de radicado
     * @return trámite encontrado o estado 404 Not Found
     */
    @GetMapping("/radicado/{radicado}")
    public ResponseEntity<?> consultarPorRadicado(@PathVariable String radicado) {
        return tramiteService.buscarPorRadicado(radicado)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("mensaje", "Radicado no encontrado: " + radicado)));
    }

    /**
     * Endpoint PATCH para actualizar el estado operativo del trámite en SERTTI.
     *
     * @param id identificador del trámite
     * @param estado nuevo estado operativo
     * @return trámite actualizado
     */
    @PatchMapping("/{id}/estado")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        try {
            Tramite actualizado = tramiteService.actualizarEstado(id, estado);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", ex.getMessage()));
        }
    }
}
