package com.sertti.tramites.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa un trámite registrado en SERTTI Tránsito La Jagua.
 * Mapea directamente con la tabla 'tramites_sertti' en la base de datos MySQL.
 *
 * @author Jhon Jairo Marriaga Ortiz
 */
@Entity
@Table(name = "tramites_sertti")
public class Tramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número de radicado es obligatorio")
    @Column(name = "numero_radicado", nullable = false, unique = true, length = 30)
    private String numeroRadicado;

    @NotBlank(message = "La placa o documento es obligatorio")
    @Column(name = "placa_vehiculo", nullable = false, length = 15)
    private String placaVehiculo;

    @NotBlank(message = "El tipo de trámite es obligatorio")
    @Column(name = "tipo_tramite", nullable = false, length = 60)
    private String tipoTramite;

    @NotBlank(message = "El nombre del solicitante es obligatorio")
    @Column(name = "nombre_solicitante", nullable = false, length = 100)
    private String nombreSolicitante;

    @Column(name = "estado_tramite", nullable = false, length = 30)
    private String estadoTramite;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    /**
     * Constructor vacío requerido por el estándar JPA.
     */
    public Tramite() {
    }

    /**
     * Inicializa automáticamente la fecha de registro y el estado inicial antes de persistir.
     */
    @PrePersist
    public void inicializarValoresPorDefecto() {
        this.fechaRegistro = LocalDateTime.now();
        if (this.estadoTramite == null || this.estadoTramite.isBlank()) {
            this.estadoTramite = "RADICADO";
        }
    }

    // Métodos Getter y Setter siguiendo convención camelCase de Java

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroRadicado() {
        return numeroRadicado;
    }

    public void setNumeroRadicado(String numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getEstadoTramite() {
        return estadoTramite;
    }

    public void setEstadoTramite(String estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
