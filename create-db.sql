DROP SCHEMA IF EXISTS `web_academia_love2code`;

CREATE SCHEMA `web_academia_love2code`;

use `web_academia_love2code`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructor_detalle`;

CREATE TABLE `instructor_detalle` (curso
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `canal_youtube` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `primer_apellido` varchar(45) DEFAULT NULL,
  `segundo_apellido` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detalle_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructor_detalle_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detalle_id`) 
  REFERENCES `instructor_detalle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `curso`;

CREATE TABLE `curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(128) DEFAULT NULL,
  `instructor_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `TITLE_UNIQUE` (`titulo`),
  
  KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
  
  CONSTRAINT `FK_INSTRUCTOR` 
  FOREIGN KEY (`instructor_id`) 
  REFERENCES `instructor` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comentario` varchar(256) DEFAULT NULL,
  `curso_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_COURSE_ID_idx` (`curso_id`),

  CONSTRAINT `FK_COURSE` 
  FOREIGN KEY (`curso_id`) 
  REFERENCES `curso` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `primer_apellido` varchar(45) DEFAULT NULL,
  `segundo_apellido` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;

INSERT INTO `alumno` VALUES 
	(1,'David','Adams', 'Adams','david@luv2code.com'),
	(2,'John','Doe', 'Adams','john@luv2code.com'),
	(3,'Ajay','Rao', 'Adams','ajay@luv2code.com'),
	(4,'Mary','Public', 'Adams','mary@luv2code.com'),
	(5,'Maxwell','Dixon', 'Adams','max@luv2code.com');

/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `curso_alumno`;

CREATE TABLE `curso_alumno` (
  `curso_id` int(11) NOT NULL,
  `alumno_id` int(11) NOT NULL,
  
  PRIMARY KEY (`curso_id`,`alumno_id`),
  
  KEY `FK_STUDENT_idx` (`alumno_id`),
  
  CONSTRAINT `FK_COURSE_05` FOREIGN KEY (`curso_id`) 
  REFERENCES `course` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_STUDENT` FOREIGN KEY (`alumno_id`) 
  REFERENCES `student` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
