CREATE DATABASE IF NOT EXISTS emuswing_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'emuswing'@'localhost'
    IDENTIFIED BY 'supermario';

GRANT ALL PRIVILEGES ON emuswing_db.*
    TO 'emuswing'@'localhost';

USE emuswing_db;

CREATE TABLE IF NOT EXISTS juegos (
    id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(150) NOT NULL,
    genero VARCHAR(80) NOT NULL,
    desarrollador VARCHAR(120) NOT NULL,
    consola VARCHAR(100) NOT NULL,
    anio SMALLINT UNSIGNED NOT NULL,
    urlPortada VARCHAR(2048),
    urlEmulador VARCHAR(2048),

    CONSTRAINT pk_juegos PRIMARY KEY (id)
);
    
CREATE TABLE IF NOT EXISTS registros_juego (
    username VARCHAR(100) NOT NULL,
    id_juego INT NOT NULL,
    horas DECIMAL(10, 6) NOT NULL DEFAULT 0,
    CONSTRAINT pk_registros_juego PRIMARY KEY (username, id_juego),
    CONSTRAINT fk_registros_juego_juego FOREIGN KEY (id_juego) REFERENCES juegos(id)
);

ALTER TABLE registros_juego
    MODIFY horas DECIMAL(10, 6) NOT NULL DEFAULT 0;


CREATE TABLE IF NOT EXISTS roles (
    codigo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(80) NOT NULL,
    activo TINYINT(1) NOT NULL DEFAULT 1,
    CONSTRAINT pk_roles PRIMARY KEY (codigo),
    CONSTRAINT uq_roles_nombre UNIQUE (nombre)
);

CREATE TABLE IF NOT EXISTS usuarios (
    usuario VARCHAR(100) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    codigo_rol INT NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT FALSE,
    estado_suscripcion BOOLEAN NOT NULL DEFAULT FALSE,

    CONSTRAINT pk_usuarios PRIMARY KEY (usuario)
);
