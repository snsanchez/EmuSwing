-- datos de prueba para ingresar juegos
use emuswing_db;

INSERT INTO roles (codigo, nombre) VALUES
(1, "ADMIN"),
(2, "ESTUDIANTE"),
(3, "INVITADO");

INSERT INTO usuarios (usuario, contrasena, nombre, email, codigo_rol, activo, estado_suscripcion) VALUES
("admin", "1234", "Admin", "admin@unrn.edu.ar", 1, FALSE, FALSE),
("ldifabio", "4", "Lucas", "ldifabio@unrn.edu.ar", 2, FALSE, FALSE),
("bjgorosito", "1234", "Bruno", "bjgorosito@unrn.edu.ar", 3, FALSE, FALSE);

INSERT INTO juegos (titulo, genero, desarrollador, consola, anio, urlPortada, urlEmulador) VALUES
("Super Street Fighter II", "Lucha", "Capcom", "SNES", 1993, "https://dn721803.ca.archive.org/0/items/Super_Street_Fighter_II_USA.md/00_coverscreenshot.png", "https://archive.org/embed/Super_Street_Fighter_II_USA.md"),
("DOOM", "FPS", "id Software", "MS-DOS", 1993, "https://dn710106.ca.archive.org/0/items/doom1.21/Cover.jpg", "https://archive.org/embed/msdos_DOOM_1993"),
("Wolfenstein 3D", "FPS", "id Software", "MS-DOS", 1992, "https://dn721602.ca.archive.org/0/items/Wolfenstein3d/00_coverscreenshot.jpg", "https://archive.org/embed/Wolfenstein3d"),
("Super Mario World", "Plataformas", "Nintendo", "NES", 1985, "https://dn721906.ca.archive.org/0/items/super-mario-world-usa_202406/Screenshot%202024-06-01%20235151.png", "https://archive.org/embed/super-mario-world-usa_202406");
