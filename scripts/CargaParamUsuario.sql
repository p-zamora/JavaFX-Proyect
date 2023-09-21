INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,
`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000001","01","ODONTÓLOGO","ODONTOLOGO",0,0,"-");

INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,
`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000001","02","CARDIÓLOGO","CARDIÓLOGO",0,0,"-");

INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,
`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000001","03","URÓLOGO","URÓLOGO",0,0,"-");

INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,
`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000001","04","PEDIATRA","PEDIATRA",0,0,"-");

INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,
`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000001","05","TRAUMATÓLOGO","TRAUMATÓLOGO",0,0,"-");

INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,
`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000002","01","PENDIENTE","PENDIENTE",0,0,"-");

INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,
`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000002","02","ATENDIDO","ATENDIDO",0,0,"-");

INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000003","01","CONSULTORIO 01","CONSULTORIO 01",0,0,"-");
INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000003","02","CONSULTORIO 02","CONSULTORIO 02",0,0,"-");
INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000003","03","CONSULTORIO 03","CONSULTORIO 03",0,0,"-");
INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000003","04","CONSULTORIO 04","CONSULTORIO 04",0,0,"-");
INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000003","05","CONSULTORIO 05","CONSULTORIO 05",0,0,"-");
INSERT INTO `bdmedical`.`parametro`(`codigoTabla`,`codigoFila`,`descripcionLarga`,`descripcionCorta`,`valorEntero`,`valorDecimal`,`valorCadena`)
VALUES ("000003","06","CONSULTORIO 06","CONSULTORIO 06",0,0,"-");


INSERT INTO `bdmedical`.`medico`(`tipoDocumento`,`numeroDocumento`,`nombre`,`apellidoPaterno`,`apellidoMaterno`,
`fechaNacimiento`,`codigoEspecialidad`) VALUES ('01', '43499734', 'Sergio Yoel', 'Samanamud', 'Ramirez', '1965-01-18', '01');
INSERT INTO `bdmedical`.`medico`(`tipoDocumento`,`numeroDocumento`,`nombre`,`apellidoPaterno`,`apellidoMaterno`,
`fechaNacimiento`,`codigoEspecialidad`) VALUES ('01', '10713749', 'Victor', 'Silva', 'Falcon', '1965-01-18', '02');
INSERT INTO `bdmedical`.`medico`(`tipoDocumento`,`numeroDocumento`,`nombre`,`apellidoPaterno`,`apellidoMaterno`,
`fechaNacimiento`,`codigoEspecialidad`) VALUES ('01', '18105532', 'Yuri', 'Evangelista', 'Carpio', '1965-01-18', '03');
INSERT INTO `bdmedical`.`medico`(`tipoDocumento`,`numeroDocumento`,`nombre`,`apellidoPaterno`,`apellidoMaterno`,
`fechaNacimiento`,`codigoEspecialidad`) VALUES ('01', '70915618', 'Pablo', 'Zamora', 'León', '1965-01-18', '04');
INSERT INTO `bdmedical`.`medico`(`tipoDocumento`,`numeroDocumento`,`nombre`,`apellidoPaterno`,`apellidoMaterno`,
`fechaNacimiento`,`codigoEspecialidad`) VALUES ('01', '71434610', 'Hector Raul', 'Berrospi', 'Ramirez', '1965-01-18', '05');



INSERT INTO `bdmedical`.`usuario`(`idMedico`,`nombre`,`clave`,`activo`) VALUES (1,"SAMAR","202020",true);
INSERT INTO `bdmedical`.`usuario`(`idMedico`,`nombre`,`clave`,`activo`) VALUES (1,"HECTORB","151515",true);
INSERT INTO `bdmedical`.`usuario`(`idMedico`,`nombre`,`clave`,`activo`) VALUES (1,"YEVANGEL","121212",true);
INSERT INTO `bdmedical`.`usuario`(`idMedico`,`nombre`,`clave`,`activo`) VALUES (1,"PABLOZ","131313",true);
INSERT INTO `bdmedical`.`usuario`(`idMedico`,`nombre`,`clave`,`activo`) VALUES (1,"VICTORS","141414",true);

