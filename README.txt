CREATE TABLE `spaces` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` int NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='Table for storing spaces.'


CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `client_name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3


CREATE TABLE `reservations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(45) NOT NULL,
  `space_name` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_name_idx` (`customer_name`),
  KEY `space_name_idx` (`space_name`),
  CONSTRAINT `customer_name` FOREIGN KEY (`customer_name`) REFERENCES `customers` (`name`),
  CONSTRAINT `space_name` FOREIGN KEY (`space_name`) REFERENCES `spaces` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3

