package com.sertti.tramites.modelo;

/**
 * Entidad que representa un trámite vehicular o de conductor gestionado en SERTTI Tránsito La Jagua.
 */
public class Tramite {

    private int idTramite;
    private String numeroRadicado;
    private String tipoTramite;
    private String placaVehiculo;
    private String documentoSolicitante;
    private String nombreSolicitante;
    private String estadoTramite;
    private String observaciones;

    public Tramite() {
    }

    public Tramite(String numeroRadicado, String tipoTramite, String placaVehiculo,
                   String documentoSolicitante, String nombreSolicitante,
                   String estadoTramite, String observaciones) {
        this.numeroRadicado = numeroRadicado;
        this.tipoTramite = tipoTramite;
        this.placaVehiculo = placaVehiculo;
        this.documentoSolicitante = documentoSolicitante;
        this.nombreSolicitante = nombreSolicitante;
        this.estadoTramite = estadoTramite;
        this.observaciones = observaciones;
    }

    public int getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(int idTramite) {
        this.idTramite = idTramite;
    }

    public String getNumeroRadicado() {
        return numeroRadicado;
    }

    public void setNumeroRadicado(String numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getDocumentoSolicitante() {
        return documentoSolicitante;
    }

    public void setDocumentoSolicitante(String documentoSolicitante) {
        this.documentoSolicitante = documentoSolicitante;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Tramite{" +
                "idTramite=" + idTramite +
                ", numeroRadicado='" + numeroRadicado + '\'' +
                ", tipoTramite='" + tipoTramite + '\'' +
                ", placaVehiculo='" + placaVehiculo + '\'' +
                ", documentoSolicitante='" + documentoSolicitante + '\'' +
                ", nombreSolicitante='" + nombreSolicitante + '\'' +
                ", estadoTramite='" + estadoTramite + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
