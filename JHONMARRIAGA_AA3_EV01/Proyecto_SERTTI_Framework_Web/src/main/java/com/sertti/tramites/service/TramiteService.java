package com.sertti.tramites.service;

import com.sertti.tramites.model.Tramite;
import com.sertti.tramites.repository.TramiteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Capa de lógica de negocio para la gestión de trámites en SERTTI Tránsito La Jagua.
 * Coordina validaciones y transacciones antes de interactuar con la base de datos.
 *
 * @author Jhon Jairo Marriaga Ortiz
 */
@Service
public class TramiteService {

    private final TramiteRepository tramiteRepository;

    /**
     * Inyección de dependencias por constructor recomendada por Spring Framework.
     *
     * @param tramiteRepository repositorio de persistencia de trámites
     */
    public TramiteService(TramiteRepository tramiteRepository) {
        this.tramiteRepository = tramiteRepository;
    }

    /**
     * Registra un nuevo trámite en la base de datos verificando que el radicado no esté duplicado.
     *
     * @param tramite objeto trámite con datos del solicitante y vehículo
     * @return trámite guardado con su identificador generado
     */
    @Transactional
    public Tramite registrarTramite(Tramite tramite) {
        Optional<Tramite> existente = tramiteRepository.findByNumeroRadicado(tramite.getNumeroRadicado());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un trámite registrado con el radicado: " + tramite.getNumeroRadicado());
        }
        tramite.setPlacaVehiculo(tramite.getPlacaVehiculo().toUpperCase().trim());
        return tramiteRepository.save(tramite);
    }

    /**
     * Obtiene el listado completo de trámites almacenados.
     *
     * @return lista de trámites
     */
    @Transactional(readOnly = true)
    public List<Tramite> listarTodos() {
        return tramiteRepository.findAll();
    }

    /**
     * Consulta un trámite por su número de radicado.
     *
     * @param numeroRadicado número de radicado a consultar
     * @return Optional con el trámite encontrado
     */
    @Transactional(readOnly = true)
    public Optional<Tramite> buscarPorRadicado(String numeroRadicado) {
        return tramiteRepository.findByNumeroRadicado(numeroRadicado);
    }

    /**
     * Actualiza el estado de gestión de un trámite (ej. RADICADO, EN_VALIDACION_RUNT, FINALIZADO).
     *
     * @param id identificador primario del trámite
     * @param nuevoEstado nuevo estado operativo
     * @return trámite actualizado
     */
    @Transactional
    public Tramite actualizarEstado(Long id, String nuevoEstado) {
        Tramite tramite = tramiteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el trámite con ID: " + id));
        tramite.setEstadoTramite(nuevoEstado.toUpperCase().trim());
        return tramiteRepository.save(tramite);
    }
}
