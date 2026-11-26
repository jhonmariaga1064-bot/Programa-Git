# Módulo de Gestión de Trámites — SERTTI Tránsito La Jagua

- **Programa:** Análisis y Desarrollo de Software (SENA)
- **Ficha:** 3336212
- **Evidencia:** GA7-220501096-AA2-EV01 — Codificación de módulos del software
- **Aprendiz:** Jhon Jairo Marriaga Ortiz
- **Repositorio GitHub:** https://github.com/jhonmariaga1064-bot/Programa-Git

## Estructura del proyecto
- `src/com/sertti/tramites/config/ConexionBD.java`: Configuración y conexión JDBC con MySQL.
- `src/com/sertti/tramites/modelo/Tramite.java`: Modelo de entidad del trámite.
- `src/com/sertti/tramites/dao/TramiteDAO.java`: Operaciones CRUD (inserción, consulta, actualización y eliminación).
- `src/com/sertti/tramites/app/AplicacionTramites.java`: Clase principal de ejecución y pruebas.
- `database/sertti_transito_db.sql`: Script SQL para crear la base de datos y la tabla `tramites`.
