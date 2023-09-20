
CREATE SCHEMA IF NOT EXISTS `bdmedical` ;
USE `bdmedical` ;

-- -----------------------------------------------------
-- Table `bdmedical`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdmedical`.`medico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipoDocumento` CHAR(2) CHARACTER SET 'utf8mb3' NOT NULL,
  `numeroDocumento` VARCHAR(15) CHARACTER SET 'utf8mb3' NOT NULL,
  `nombre` VARCHAR(45) CHARACTER SET 'utf8mb3' NOT NULL,
  `apellidoPaterno` VARCHAR(45) CHARACTER SET 'utf8mb3' NOT NULL,
  `apellidoMaterno` VARCHAR(45) CHARACTER SET 'utf8mb3' NOT NULL,
  `fechaNacimiento` DATE NULL DEFAULT NULL,
  `codigoEspecialidad` CHAR(3) CHARACTER SET 'utf8mb3' NOT NULL,
  `activo` BIT(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
ROW_FORMAT = DYNAMIC;

CREATE UNIQUE INDEX `DNI1_UNIQUE` USING BTREE ON `bdmedical`.`medico` (`numeroDocumento`) VISIBLE;


-- -----------------------------------------------------
-- Table `bdmedical`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdmedical`.`paciente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipoDocumento` CHAR(2) CHARACTER SET 'utf8mb3' NOT NULL,
  `numeroDocumento` VARCHAR(15) CHARACTER SET 'utf8mb3' NOT NULL,
  `nombre` VARCHAR(45) CHARACTER SET 'utf8mb3' NOT NULL,
  `apellidoPaterno` VARCHAR(45) CHARACTER SET 'utf8mb3' NOT NULL,
  `apellidoMaterno` VARCHAR(45) COLLATE 'utf8mb3_spanish_ci' NOT NULL,
  `fechaNacimiento` DATE NULL DEFAULT NULL,
  `activo` BIT(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
ROW_FORMAT = DYNAMIC;

CREATE UNIQUE INDEX `DNI2_UNIQUE` USING BTREE ON `bdmedical`.`paciente` (`numeroDocumento`) VISIBLE;


-- -----------------------------------------------------
-- Table `bdmedical`.`cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdmedical`.`cita` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` CHAR(5) COLLATE 'utf8mb3_spanish_ci' NOT NULL,
  `asunto` VARCHAR(255) CHARACTER SET 'utf8mb3' NOT NULL,
  `idMedico` INT NOT NULL,
  `idPaciente` INT NOT NULL,
  `estado` CHAR(3) COLLATE 'utf8mb3_spanish_ci' NOT NULL,
  `consultorio` CHAR(3) COLLATE 'utf8mb3_spanish_ci' NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `bdmedical`.`parametro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdmedical`.`parametro` (
  `codigoTabla` VARCHAR(6) CHARACTER SET 'utf8mb3' NOT NULL,
  `codigoFila` VARCHAR(6) CHARACTER SET 'utf8mb3' NOT NULL,
  `descripcionLarga` VARCHAR(255) CHARACTER SET 'utf8mb3' NOT NULL,
  `descripcionCorta` VARCHAR(255) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `valorEntero` TINYINT NULL DEFAULT NULL,
  `valorDecimal` DECIMAL(8,2) NULL DEFAULT NULL,
  `valorCadena` VARCHAR(255) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `activo` BIT(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`codigoTabla`, `codigoFila`))
ENGINE = InnoDB
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `bdmedical`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdmedical`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idMedico` INT NOT NULL,
  `nombre` VARCHAR(15) CHARACTER SET 'utf8mb3' NOT NULL,
  `clave` VARCHAR(255) CHARACTER SET 'utf8mb3' NOT NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
ROW_FORMAT = DYNAMIC;


ALTER TABLE `cita` ADD CONSTRAINT `FK_cita_medico` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `cita` ADD CONSTRAINT `FK_cita_paciente` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `usuario` ADD CONSTRAINT `FK_usuario_medico` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

