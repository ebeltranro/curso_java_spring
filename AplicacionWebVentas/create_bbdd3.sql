-- MySQL Script generated by MySQL Workbench
-- Fri May 24 12:07:57 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bd_ventas
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bd_ventas` ;

-- -----------------------------------------------------
-- Schema bd_ventas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_ventas` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `bd_ventas` ;

-- -----------------------------------------------------
-- Table `bd_ventas`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_ventas`.`cliente` ;

CREATE TABLE IF NOT EXISTS `bd_ventas`.`cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `email` VARCHAR(250) NOT NULL,
  `edad` TINYINT(4) NOT NULL,
  `activo` TINYINT(4) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 262
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `bd_ventas`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_ventas`.`producto` ;

CREATE TABLE IF NOT EXISTS `bd_ventas`.`producto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `precio` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `bd_ventas`.`compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_ventas`.`compra` ;

CREATE TABLE IF NOT EXISTS `bd_ventas`.`compra` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` INT(11) NOT NULL,
  `producto_id` INT(11) NOT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cantidad` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_cliente_has_producto_producto1_idx` (`producto_id` ASC) VISIBLE,
  INDEX `fk_cliente_has_producto_cliente_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_has_producto_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `bd_ventas`.`cliente` (`id`),
  CONSTRAINT `fk_cliente_has_producto_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `bd_ventas`.`producto` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
