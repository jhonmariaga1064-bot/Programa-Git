package com.sertti.tramites.dao;

import com.sertti.tramites.config.ConexionBD;
import com.sertti.tramites.modelo.Tramite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de acceso a datos (DAO) que implementa las operaciones CRUD
 * (Inserción, Consulta, Actualización y Eliminación) mediante JDBC.
 */
public class TramiteDAO {

    /**
     * Inserta un nuevo registro de trámite en la base de datos.
     */
    public boolean insertarTramite(Tramite tramite) {
        String sqlInsercion = "INSERT INTO tramites (numero_radicado, tipo_tramite, placa_vehiculo, " +
                              "documento_solicitante, nombre_solicitante, estado_tramite, observaciones) " +
                              "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sqlInsercion)) {

            sentencia.setString(1, tramite.getNumeroRadicado());
            sentencia.setString(2, tramite.getTipoTramite());
            sentencia.setString(3, tramite.getPlacaVehiculo());
            sentencia.setString(4, tramite.getDocumentoSolicitante());
            sentencia.setString(5, tramite.getNombreSolicitante());
            sentencia.setString(6, tramite.getEstadoTramite());
            sentencia.setString(7, tramite.getObservaciones());

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al insertar el trámite: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Consulta todos los trámites registrados en el sistema.
     */
    public List<Tramite> consultarTodosLosTramites() {
        List<Tramite> listaTramites = new ArrayList<>();
        String sqlConsulta = "SELECT id_tramite, numero_radicado, tipo_tramite, placa_vehiculo, " +
                             "documento_solicitante, nombre_solicitante, estado_tramite, observaciones " +
                             "FROM tramites ORDER BY id_tramite DESC";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sqlConsulta);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                Tramite tramite = mapearFilaATramite(resultado);
                listaTramites.add(tramite);
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar los trámites: " + ex.getMessage());
        }
        return listaTramites;
    }

    /**
     * Consulta un trámite específico según su número de radicado.
     */
    public Tramite consultarPorRadicado(String numeroRadicado) {
        String sqlConsulta = "SELECT id_tramite, numero_radicado, tipo_tramite, placa_vehiculo, " +
                             "documento_solicitante, nombre_solicitante, estado_tramite, observaciones " +
                             "FROM tramites WHERE numero_radicado = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sqlConsulta)) {

            sentencia.setString(1, numeroRadicado);
            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return mapearFilaATramite(resultado);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar el radicado " + numeroRadicado + ": " + ex.getMessage());
        }
        return null;
    }

    /**
     * Actualiza el estado y las observaciones de un trámite existente.
     */
    public boolean actualizarEstadoTramite(String numeroRadicado, String nuevoEstado, String nuevasObservaciones) {
        String sqlActualizacion = "UPDATE tramites SET estado_tramite = ?, observaciones = ? WHERE numero_radicado = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sqlActualizacion)) {

            sentencia.setString(1, nuevoEstado);
            sentencia.setString(2, nuevasObservaciones);
            sentencia.setString(3, numeroRadicado);

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar el trámite: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Elimina un trámite de la base de datos a partir de su número de radicado.
     */
    public boolean eliminarTramitePorRadicado(String numeroRadicado) {
        String sqlEliminacion = "DELETE FROM tramites WHERE numero_radicado = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sqlEliminacion)) {

            sentencia.setString(1, numeroRadicado);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar el trámite: " + ex.getMessage());
            return false;
        }
    }

    private Tramite mapearFilaATramite(ResultSet resultado) throws SQLException {
        Tramite tramite = new Tramite();
        tramite.setIdTramite(resultado.getInt("id_tramite"));
        tramite.setNumeroRadicado(resultado.getString("numero_radicado"));
        tramite.setTipoTramite(resultado.getString("tipo_tramite"));
        tramite.setPlacaVehiculo(resultado.getString("placa_vehiculo"));
        tramite.setDocumentoSolicitante(resultado.getString("documento_solicitante"));
        tramite.setNombreSolicitante(resultado.getString("nombre_solicitante"));
        tramite.setEstadoTramite(resultado.getString("estado_tramite"));
        tramite.setObservaciones(resultado.getString("observaciones"));
        return tramite;
    }
}
