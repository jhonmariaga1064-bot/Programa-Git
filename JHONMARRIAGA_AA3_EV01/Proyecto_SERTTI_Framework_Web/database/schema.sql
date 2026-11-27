-- Script de creación de base de datos y tabla principal para SERTTI Tránsito La Jagua
-- Evidencia: GA7-220501096-AA3-EV01

CREATE DATABASE IF NOT EXISTS sertti_tramites_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE sertti_tramites_db;

CREATE TABLE IF NOT EXISTS tramites_sertti (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_radicado VARCHAR(30) NOT NULL UNIQUE,
    placa_vehiculo VARCHAR(15) NOT NULL,
    tipo_tramite VARCHAR(60) NOT NULL,
    nombre_solicitante VARCHAR(100) NOT NULL,
    estado_tramite VARCHAR(30) NOT NULL DEFAULT 'RADICADO',
    fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Registros de ejemplo contextualizados en SERTTI
INSERT INTO tramites_sertti (numero_radicado, placa_vehiculo, tipo_tramite, nombre_solicitante, estado_tramite)
VALUES
  ('RAD-2026-001', 'KLM458', 'Traspaso de propiedad', 'Carlos Andrés Pérez', 'RADICADO'),
  ('RAD-2026-002', 'XYZ91G', 'Duplicado de placa', 'María Fernanda Gómez', 'EN_VALIDACION_RUNT');
