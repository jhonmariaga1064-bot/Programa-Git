package com.sertti.tramites.app;

import com.sertti.tramites.dao.TramiteDAO;
import com.sertti.tramites.modelo.Tramite;
import java.util.List;

/**
 * Clase principal de ejecución del módulo de trámites para SERTTI Tránsito La Jagua.
 * Demuestra las operaciones CRUD sobre la base de datos mediante JDBC.
 */
public class AplicacionTramites {

    public static void main(String[] args) {
        TramiteDAO tramiteDao = new TramiteDAO();

        // 1. Inserción de un nuevo trámite
        Tramite nuevoTramite = new Tramite(
                "RAD-2026-003",
                "Duplicado de licencia de conducción",
                "PQR321",
                "1064812345",
                "Luis Eduardo Martínez",
                "RADICADO",
                "Solicitud ingresada en ventanilla SERTTI"
        );
        boolean insertado = tramiteDao.insertarTramite(nuevoTramite);
        System.out.println("Registro insertado correctamente: " + insertado);

        // 2. Consulta general de trámites
        System.out.println("\nListado actual de trámites:");
        List<Tramite> listaTramites = tramiteDao.consultarTodosLosTramites();
        for (Tramite item : listaTramites) {
            System.out.println(item);
        }

        // 3. Actualización del estado del trámite
        boolean actualizado = tramiteDao.actualizarEstadoTramite(
                "RAD-2026-003",
                "APROBADO",
                "Licencia impresa y lista para entrega al usuario"
        );
        System.out.println("\nRegistro actualizado correctamente: " + actualizado);

        // 4. Consulta individual por número de radicado
        Tramite tramiteConsultado = tramiteDao.consultarPorRadicado("RAD-2026-003");
        System.out.println("Detalle consultado: " + tramiteConsultado);

        // 5. Eliminación de prueba
        boolean eliminado = tramiteDao.eliminarTramitePorRadicado("RAD-2026-003");
        System.out.println("\nRegistro eliminado correctamente: " + eliminado);
    }
}
