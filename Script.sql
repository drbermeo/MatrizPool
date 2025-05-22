CREATE DATABASE matrizpooldb;
use matrizpooldb;
CREATE TABLE hilo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fila1 INT NOT NULL,
    fila2 INT NOT NULL,
    fila3 INT NOT NULL,
    fila4 INT NOT NULL,
    fila5 INT NOT NULL,
    fila6 INT NOT NULL,
    fila7 INT NOT NULL,
    fila8 INT NOT NULL,
    fila9 INT NOT NULL,
    fila10 INT NOT NULL,
    fila11 INT,
    fila12 INT,
    nombre_hilo VARCHAR(500) NOT NULL,
    nro_procesador INT ,
    sumafila INT
);
drop table hilo;
select * from hilo;