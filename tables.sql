-- -----------------------------------------------------
-- Schema wdc (Wireless Data Collector)
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wdc` DEFAULT CHARACTER SET utf8;
USE `wdc`;

-- -----------------------------------------------------
-- Table `wdc`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wdc`.`role` (
  `roleId` LONG NOT NULL AUTO_INCREMENT ,
  `roleName` VARCHAR(45) NOT NULL ,
  `disabled` INT(1) ZEROFILL NULL ,
  PRIMARY KEY (`roleId`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;
  
-- -----------------------------------------------------
-- Table `wdc`.`rolePrivileges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wdc`.`rolePrivileges` (
  `privilegeId` LONG NOT NULL AUTO_INCREMENT ,
  `privilegeDescription` VARCHAR(45) NOT NULL ,
  `roleId` LONG NULL ,
  `disabled` INT(1) ZEROFILL NULL ,
  `lastModifiedUser` VARCHAR(30) NULL DEFAULT NULL,
  `lastModifiedDateTime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`privilegeId`),
  FOREIGN KEY (`roleId`)
  REFERENCES `wdc`.`role` (`roleId`)
	ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `wdc`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wdc`.`user` (
  `userId` LONG NOT NULL AUTO_INCREMENT ,
  `email` VARCHAR(45) NOT NULL ,
  `userName` VARCHAR(45) NOT NULL ,
  `firstName` VARCHAR(45) NOT NULL ,
  `lastName` VARCHAR(45) NOT NULL ,
  `loginPassword` VARCHAR(45) NOT NULL ,
  `roleId` LONG NOT NULL ,
  `disabled` INT(1) ZEROFILL NULL ,
  PRIMARY KEY (`userId`),
  FOREIGN KEY (`roleId`)
  REFERENCES `wdc`.`role` (`roleId`)
	ON DELETE NO ACTION
	ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `wdc`.`collection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wdc`.`collection` (
  `collectionId` LONG NOT NULL AUTO_INCREMENT ,
  `collectionName` VARCHAR(45) NOT NULL ,
  `collectionLocation` VARCHAR(45) NOT NULL ,
  `noOfUnits` INT ZEROFILL NULL ,
  `userId` LONG NOT NULL ,
  `disabled` INT(1) ZEROFILL NULL ,
  `lastModifiedUser` VARCHAR(30) NULL DEFAULT NULL,
  `lastModifiedDateTime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`collectionId`) ,
  FOREIGN KEY (`userId`)
  REFERENCES `wdc`.`user` (`userId`)
	ON DELETE NO ACTION
	ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `wdc`.`unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wdc`.`unit` (
  `unitId` LONG NOT NULL AUTO_INCREMENT ,
  `unitName` VARCHAR(45) NULL ,
  `unitLocation` VARCHAR(45) NOT NULL ,
  `noOfParentNodes` INT ZEROFILL NULL ,
  `collectionId` LONG NOT NULL ,
  `disabled` INT(1) ZEROFILL NULL ,
  `lastModifiedUser` VARCHAR(30) NULL DEFAULT NULL,
  `lastModifiedDateTime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`unitId`) ,
  FOREIGN KEY (`collectionId`)
  REFERENCES `wdc`.`collection` (`collectionId`)
	ON DELETE NO ACTION
	ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `wdc`.`parentNode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wdc`.`parentNode` (
  `parentNodeId` LONG NOT NULL AUTO_INCREMENT ,
  `parentNodeName` VARCHAR(45) NULL ,
  `parentNodeLocation` VARCHAR(45) NOT NULL ,
  `noOfNodes` INT ZEROFILL NOT NULL ,
  `unitId` LONG NOT NULL ,
  `collectionId` LONG NOT NULL ,
  `disabled` INT(1) ZEROFILL NULL ,
  `lastModifiedUser` VARCHAR(30) NULL DEFAULT NULL,
  `lastModifiedDateTime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`parentNodeId`) ,
  FOREIGN KEY (`unitId`)
  REFERENCES `wdc`.`unit` (`unitId`)
	ON DELETE NO ACTION
	ON UPDATE CASCADE,
  FOREIGN KEY (`collectionId`)
  REFERENCES `wdc`.`collection` (`collectionId`)
	ON DELETE NO ACTION
	ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `wdc`.`node`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wdc`.`node` (
  `nodeId` LONG NOT NULL AUTO_INCREMENT ,
  `parentNodeId` INT NOT NULL ,
  `disabled` INT(1) ZEROFILL NULL ,
  `lastModifiedUser` VARCHAR(30) NULL DEFAULT NULL,
  `lastModifiedDateTime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`nodeId`),
  FOREIGN KEY (`parentNodeId`)
  REFERENCES `wdc`.`parentNode` (`parentNodeId`)
	ON DELETE NO ACTION
	ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `wdc`.`data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wdc`.`data` (
  `dataId` LONG NOT NULL AUTO_INCREMENT ,
  `data1` VARCHAR(45) NULL ,
  `data2` VARCHAR(45) NULL ,
  `data3` VARCHAR(45) NULL ,
  `data4` VARCHAR(45) NULL ,
  `nodeId` LONG NOT NULL ,
  `validated` INT(1) ZEROFILL NULL ,
  `disabled` INT(1) ZEROFILL NULL ,
  `savedDateTime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`dataId`) ,
  FOREIGN KEY (`nodeId`)
  REFERENCES `wdc`.`node` (`nodeId`)
	ON DELETE NO ACTION
	ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;
