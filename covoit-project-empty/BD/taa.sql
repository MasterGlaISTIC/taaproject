-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Jeu 12 Mars 2015 à 16:18
-- Version du serveur: 5.5.40-0ubuntu0.14.04.1
-- Version de PHP: 5.5.9-1ubuntu4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `taa`
--

-- --------------------------------------------------------

--
-- Structure de la table `Car`
--

CREATE TABLE IF NOT EXISTS `Car` (
  `idCar` bigint(20) NOT NULL AUTO_INCREMENT,
  `nbrPlaces` int(11) NOT NULL,
  PRIMARY KEY (`idCar`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `Car`
--

INSERT INTO `Car` (`idCar`, `nbrPlaces`) VALUES
(1, 4),
(2, 3),
(3, 2),
(4, 1),
(5, 0),
(6, 4);

-- --------------------------------------------------------

--
-- Structure de la table `Comment`
--

CREATE TABLE IF NOT EXISTS `Comment` (
  `idComment` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `event_idEvent` bigint(20) DEFAULT NULL,
  `user_idUser` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idComment`),
  KEY `FK_3cp2g9eeajv5koy1r91l503s6` (`event_idEvent`),
  KEY `FK_sq42039gtbg6fpx3oo970i3h8` (`user_idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `Event`
--

CREATE TABLE IF NOT EXISTS `Event` (
  `idEvent` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `createur_idUser` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idEvent`),
  KEY `FK_jk9fq0154kfv88dkud87eawi0` (`createur_idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `Event`
--

INSERT INTO `Event` (`idEvent`, `adresse`, `date`, `name`, `createur_idUser`) VALUES
(1, 'Rennes', '2015-03-08', 'Roken solex', NULL),
(2, 'Rennes', '2015-03-08', 'Fourmie', NULL),
(3, 'Nantes', '2015-03-08', 'Rassemblement de la région de Bratagne', NULL),
(4, 'Paris', '2015-03-08', 'Coupe du monde', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `Participation`
--

CREATE TABLE IF NOT EXISTS `Participation` (
  `idEvent` bigint(20) NOT NULL,
  `idUser` bigint(20) NOT NULL,
  PRIMARY KEY (`idEvent`,`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `idUser` bigint(20) NOT NULL AUTO_INCREMENT,
  `car` tinyblob,
  `email` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `User`
--

INSERT INTO `User` (`idUser`, `car`, `email`, `location`, `name`, `passwd`) VALUES
(1, 0x6d6f687373696e652e616d686163686940676d61696c2e636f6d, 'mohssine.amhachi@gmail.com', 'Rennes', 'Mohssine', '1'),
(2, 0x796163696e652e63686161626940676d61696c2e636f6d, 'mohssine.amhachi@gmail.com', 'CHAABI', '', '2'),
(3, 0x637265617465757240676d61696c2e636f6d, 'mohssine.amhachi@gmail.com', 'CREATEUR', '', '3'),
(4, NULL, 'mohssine.amhachi@gmail.com', 'Rennes', 'Mohssine', NULL),
(5, NULL, 'mohssine.amhachi@gmail.com', 'Rennes', 'Mohssine', NULL),
(6, NULL, 'mohssine.amhachi@gmail.com', 'Rennes', 'Mohssine', NULL),
(7, NULL, 'yacine@gmail.com', 'Rennes', 'Yacine', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `User_Car`
--

CREATE TABLE IF NOT EXISTS `User_Car` (
  `User_idUser` bigint(20) NOT NULL,
  `cars_idCar` bigint(20) NOT NULL,
  UNIQUE KEY `UK_jl5381pu7v99rvd3ad9nna4dh` (`cars_idCar`),
  KEY `FK_gsqrypnspa06y04ljnc4hiwrc` (`User_idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `User_Car`
--

INSERT INTO `User_Car` (`User_idUser`, `cars_idCar`) VALUES
(4, 6);

-- --------------------------------------------------------

--
-- Structure de la table `User_Event`
--

CREATE TABLE IF NOT EXISTS `User_Event` (
  `User_idUser` bigint(20) NOT NULL,
  `events_idEvent` bigint(20) NOT NULL,
  UNIQUE KEY `UK_cufwhrkfo7p5vje06eur5a15y` (`events_idEvent`),
  KEY `FK_pp5p6f7lno48qg7dxo3gcqpnd` (`User_idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `User_Event`
--

INSERT INTO `User_Event` (`User_idUser`, `events_idEvent`) VALUES
(5, 1),
(6, 2);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Comment`
--
ALTER TABLE `Comment`
  ADD CONSTRAINT `FK_3cp2g9eeajv5koy1r91l503s6` FOREIGN KEY (`event_idEvent`) REFERENCES `Event` (`idEvent`),
  ADD CONSTRAINT `FK_sq42039gtbg6fpx3oo970i3h8` FOREIGN KEY (`user_idUser`) REFERENCES `User` (`idUser`);

--
-- Contraintes pour la table `Event`
--
ALTER TABLE `Event`
  ADD CONSTRAINT `FK_jk9fq0154kfv88dkud87eawi0` FOREIGN KEY (`createur_idUser`) REFERENCES `User` (`idUser`);

--
-- Contraintes pour la table `User_Car`
--
ALTER TABLE `User_Car`
  ADD CONSTRAINT `FK_gsqrypnspa06y04ljnc4hiwrc` FOREIGN KEY (`User_idUser`) REFERENCES `User` (`idUser`),
  ADD CONSTRAINT `FK_jl5381pu7v99rvd3ad9nna4dh` FOREIGN KEY (`cars_idCar`) REFERENCES `Car` (`idCar`);

--
-- Contraintes pour la table `User_Event`
--
ALTER TABLE `User_Event`
  ADD CONSTRAINT `FK_cufwhrkfo7p5vje06eur5a15y` FOREIGN KEY (`events_idEvent`) REFERENCES `Event` (`idEvent`),
  ADD CONSTRAINT `FK_pp5p6f7lno48qg7dxo3gcqpnd` FOREIGN KEY (`User_idUser`) REFERENCES `User` (`idUser`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
