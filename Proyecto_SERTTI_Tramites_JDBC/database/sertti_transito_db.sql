-- Base de datos para el módulo de gestión de trámites - SERTTI Tránsito La Jagua
-- Evidencia: GA7-220501096-AA2-EV01 | Ficha: 3336212
-- Aprendiz: Jhon Jairo Marriaga Ortiz

CREATE DATABASE IF NOT EXISTS sertti_transito_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE sertti_transito_db;

CREATE TABLE IF NOT EXISTS tramites (
    id_tramite INT AUTO_INCREMENT PRIMARY KEY,
    numero_radicado VARCHAR(25) NOT NULL UNIQUE,
    tipo_tramite VARCHAR(60) NOT NULL,
    placa_vehiculo VARCHAR(10) NOT NULL,
    documento_solicitante VARCHAR(20) NOT NULL,
    nombre_solicitante VARCHAR(100) NOT NULL,
    estado_tramite VARCHAR(30) NOT NULL DEFAULT 'EN_PROCESO',
    observaciones VARCHAR(255),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tramites (numero_radicado, tipo_tramite, placa_vehiculo, documento_solicitante, nombre_solicitante, estado_tramite, observaciones)
VALUES
('RAD-2026-001', 'Traspaso de propiedad', 'KJL458', '1064789123', 'Carlos Andrés Pérez', 'RADICADO', 'Documentación completa y paz y salvo verificado'),
('RAD-2026-002', 'Traslado de cuenta', 'MNO912', '77192345', 'María Fernanda Gómez', 'EN_PROCESO', 'Pendiente validación de historial vehicular');
