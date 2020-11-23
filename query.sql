
-- MySQL Workbench Synchronization
-- Generated: 2020-11-22 19:24
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: asus

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `ProjetEE` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `ProjetEE`.`Personne` (
  `idPersonne` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `classID` INT(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idPersonne`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ProjetEE`.`Todo` (
  `idTodo` INT(11) NOT NULL AUTO_INCREMENT,
  `description` NVARCHAR(500) NOT NULL DEFAULT '\"blablabla\"',
  `name` VARCHAR(45) NOT NULL DEFAULT '\"lien\"',
  PRIMARY KEY (`idTodo`),
  UNIQUE INDEX `idtodo_UNIQUE` (`idTodo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `ProjetEE`.`TodoClass` (
  `classIDAux` INT(11) NOT NULL,
  `idTodoAux` INT(11) NOT NULL,
  PRIMARY KEY (`idTodoAux`, `classIDAux`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SET @@global.time_zone = '+00:00';SET @@session.time_zone = '+00:00';



INSERT INTO projetee.personne (`idPersonne`, `name`,`password`) VALUES (1, 'admin','admin');
INSERT INTO projetee.personne (`idPersonne`, `name`,`password`,`classID`) VALUES (2, 'eleve1','motdepasse',1);

INSERT INTO `projetee`.`todo` (`idTodo`, `description`, `name`) VALUES ('1', 'blablabla', 'lecon 1');
INSERT INTO `projetee`.`todo` (`idTodo`, `description`, `name`) VALUES ('2', 'blibliblibli', 'lecon 2');
INSERT INTO `projetee`.`todo` (`idTodo`, `description`, `name`) VALUES ('3', 'bliblibla', 'lecon 3');

INSERT INTO `projetee`.`TodoClass` ( `classIDAux`, `idTodoAux`) VALUES ( '1', '1');
INSERT INTO `projetee`.`TodoClass` ( `classIDAux`, `idTodoAux`) VALUES ( '1', '2');
INSERT INTO `projetee`.`TodoClass` ( `classIDAux`, `idTodoAux`) VALUES ( '1', '3');
INSERT INTO `projetee`.`TodoClass` ( `classIDAux`, `idTodoAux`) VALUES ( '2', '1');
INSERT INTO `projetee`.`TodoClass` ( `classIDAux`, `idTodoAux`) VALUES ( '2', '3');
INSERT INTO `projetee`.`TodoClass` ( `classIDAux`, `idTodoAux`) VALUES ( '3', '2');

Select * from projetee.todo;
select * from projetee.TodoClass;
Select * from projetee.personne ;
Select Todo.* from projetee.Todo JOIN projetee.TodoClass on Todo.idTodo=TodoClass.idTodoAux where TodoClass.classIDAux=2 ;
Insert INTO `projetee`.`todo` (description,name) VALUES ('jevais te niquer tes morts','grossesalope');