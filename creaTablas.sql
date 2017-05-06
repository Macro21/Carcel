CREATE TABLE PABELLONES(
ID_PABELLON INTEGER NOT NULL check (id_pabellon > 0),
NOMBRE VARCHAR(50) NOT NULL unique,
ESTADO INTEGER NOT NULL check (ESTADO = 0 or ESTADO = 1),
TAMANO_CELDA INTEGER,
NUM_VIGILANTES INTEGER,
TIPO VARCHAR(255) NOT NULL check (lower(tipo) = 'aislamiento' or lower(tipo) = 'comun'),
NUM_MAX_CELDAS INTEGER NOT NULL check (num_max_celdas >= 0),
PRIMARY KEY (ID_PABELLON))
;

Create sequence seq_pabellones_id_pabellones start with 1 increment by 1 nomaxvalue NOCACHE NOCYCLE
;

CREATE TABLE CELDAS(
ID_CELDA INTEGER NOT NULL check (id_celda > 0),
ID_PABELLON INTEGER NOT NULL,
NUM_CELDA INTEGER NOT NULL check (num_celda > 0),
TELEVISION INTEGER NOT NULL check (television = 0 or television = 1),
DUCHA INTEGER NOT NULL check (ducha = 0 or ducha = 1),
ESTADO INTEGER NOT NULL check (estado = 0 or estado = 1),
unique(id_pabellon, num_celda),
PRIMARY KEY(ID_CELDA),
foreign key (id_pabellon) references pabellones(id_pabellon))
;

Create sequence seq_celdas_id_celda start with 1 increment by 1 nomaxvalue NOCACHE NOCYCLE
;

CREATE TABLE PRESOS(
id_preso INTEGER NOT NULL check (id_preso > 0), 
DNI VARCHAR(9) NOT NULL unique check (length(dni) = 9),
NOMBRE VARCHAR(50) NOT NULL,
APELLIDOS VARCHAR(100) NOT NULL,
CONDENA VARCHAR(100) NOT NULL,
ESTADO INTEGER NOT NULL check (estado = 1 or estado = 0),
PRIMARY KEY (id_preso))
;

Create sequence seq_presos_id_presos start with 1 increment by 1 nomaxvalue NOCACHE NOCYCLE
;

CREATE TABLE ESTANCIA(
id_celda INTEGER NOT NULL check (id_celda > 0), 
id_preso INTEGER NOT NULL check (id_preso > 0),
fecha_inicio date NOT NULL, 
fecha_fin date,
PRIMARY KEY (id_celda,id_preso,fecha_inicio),
foreign key (id_celda) references celdas(id_celda),
foreign key (id_preso) references presos(id_preso))
;
