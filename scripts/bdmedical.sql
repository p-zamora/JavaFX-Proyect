CREATE SCHEMA `bdmedical` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `bdmedical`;

CREATE TABLE `cita` (
`id` int NOT NULL AUTO_INCREMENT,
`fecha` date NOT NULL,
`hora` time NOT NULL,
`asunto` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`idMedico` int NOT NULL,
`idPaciente` int NOT NULL,
`estado` char(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
PRIMARY KEY (`id`) ,
INDEX `FK_cita_medico` (`idMedico` ASC) USING BTREE,
INDEX `FK_cita_paciente` (`idPaciente` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8mb3
COLLATE = utf8mb3_spanish_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;
CREATE TABLE `medico` (
`id` int NOT NULL AUTO_INCREMENT,
`tipoDocumento` char(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`numeroDocumento` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`nombre` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`apellidoPaterno` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`apellidoMaterno` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`fechaNacimiento` date NULL DEFAULT NULL,
`codigoEspecialidad` char(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`activo` bit(1) NOT NULL,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `DNI_UNIQUE` (`numeroDocumento` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8mb3
COLLATE = utf8mb3_spanish_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;
CREATE TABLE `paciente` (
`id` int NOT NULL AUTO_INCREMENT,
`tipoDocumento` char(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`numeroDocumento` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`nombre` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`apellidoPaterno` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`apellidoMaterno` varbinary(45) NOT NULL,
`fechaNacimiento` date NULL DEFAULT NULL,
`activo` bit(1) NOT NULL DEFAULT b'0',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `DNI_UNIQUE` (`numeroDocumento` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8mb3
COLLATE = utf8mb3_spanish_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;
CREATE TABLE `parametro` (
`codigoTabla` varchar(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`codigoFila` varchar(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`descripcionLarga` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`descripcionCorta` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NULL DEFAULT NULL,
`valorEntero` tinyint NULL DEFAULT NULL,
`valorDecimal` decimal(8,2) NULL DEFAULT NULL,
`valorCadena` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NULL DEFAULT NULL,
`activo` bit(1) NOT NULL
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8mb3
COLLATE = utf8mb3_spanish_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;
CREATE TABLE `usuario` (
`id` int NOT NULL AUTO_INCREMENT,
`idMedico` int NOT NULL,
`nombre` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`clave` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
`activo` bit(1) NOT NULL,
PRIMARY KEY (`id`) ,
INDEX `FK_usuario_medico` (`idMedico` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8mb3
COLLATE = utf8mb3_spanish_ci
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Dynamic;

ALTER TABLE `cita` ADD CONSTRAINT `FK_cita_medico` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `cita` ADD CONSTRAINT `FK_cita_paciente` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `usuario` ADD CONSTRAINT `FK_usuario_medico` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

