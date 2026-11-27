package com.sertti.tramites.repository;

import com.sertti.tramites.model.Tramite;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio Spring Data JPA para el almacenamiento y consulta de trámites en MySQL.
 * Provee operaciones CRUD automáticas sin necesidad de SQL repetitivo.
 *
 * @author Jhon Jairo Marriaga Ortiz
 */
@Repository
public interface TramiteRepository extends JpaRepository<Tramite, Long> {

    /**
     * Busca un trámite específico por su número de radicado único.
     *
     * @param numeroRadicado código de radicado asignado en ventanilla
     * @return Optional con el trámite encontrado si existe
     */
    Optional<Tramite> findByNumeroRadicado(String numeroRadicado);

    /**
     * Lista todos los trámites asociados a una placa vehicular.
     *
     * @param placaVehiculo placa del automotor o motocicleta
     * @return lista de trámites registrados para dicha placa
     */
    List<Tramite> findByPlacaVehiculoIgnoreCase(String placaVehiculo);
}
