# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# HÙte: 127.0.0.1 (MySQL 5.7.32)
# Base de donnÈes: repertoire
# Temps de gÈnÈration: 2022-03-12 08:11:36 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Affichage de la table contact
# ------------------------------------------------------------

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL DEFAULT '',
  `prenom` varchar(20) NOT NULL DEFAULT '',
  `adresse` varchar(40) NOT NULL DEFAULT '',
  `ville` varchar(20) NOT NULL DEFAULT '',
  `cp` varchar(5) NOT NULL DEFAULT '0',
  `tel` varchar(10) NOT NULL DEFAULT '0',
  `email` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;

INSERT INTO `contact` (`id`, `nom`, `prenom`, `adresse`, `ville`, `cp`, `tel`, `email`)
VALUES
	(1,'Bernard','Alice','10 avenue des All√©es','Etampes','91150','0132324500','abernard@gmail.com'),
	(2,'Petit','Marc','88 rue de la sabliere','Etampes','91150','0132239987','mpetit@gmail.com'),
	(3,'Roux','Alexandre','07 avenue du 8 mai','Etampes','91150','0198475847','aroux@hotmail.com'),
	(4,'David','C√©cile','10 rue de la r√©publique','Etampes','91150','0132999008','cdavid@gmail.com'),
	(5,'Muller','Loic','78 rue de la r√©publique','Etampes','91150','0132386655','lmuller@msn.com'),
	(6,'Fontaine','M√©lissa','10 avenue de la lib√©ration','Etampes','91150','0176588893','mfontaine@gmail.com'),
	(7,'Bonnet','Sebastien','67 rue de la region','Lardy','91344','0109843098','sbonnet@gmail.com'),
	(8,'Lambert','Dimitri','5 rue de la croix','Longjumeau','91099','0143987398','dlambert@hotmail.fr'),
	(9,'Blanc','Vincent','54 avenue du chene','Marolles','91988','0693847747','vblanc@gmail.com'),
	(10,'Robin','Matilde','09 avenue de la motte','Evry','91039','0637683738','m.robin@gmail.com'),
	(11,'Mercier','Nicolas','5 bis rue des Maronniers','Morigny','91150','0109898656','nmercier@gmail.com'),
	(12,'Perrin','David','67 rue du martin','Massy','91098','0199876788','david.perrin@gmail.com'),
	(13,'Masson','Jimmy','54 rue des boites','Evry','91966','0109879776','jmasson@hotmail.com'),
	(14,'Dufour','Jessica','12 rue des moulins','Bretigny','91953','0678939334','jdufour@gamil.com'),
	(15,'Gautier','Younes','12 rue des bulles','Orsay','91728','0676454669','younes.gautier@hotmail.com'),
	(16,'Joly','Enzo','10 rue des Lambeaux','Morigny','91150','0198798980','enzo.joly@gmail.com'),
	(17,'Schmitt','C√©dric','08 rue de la veille','Etrechy','91136','0198767789','cschmitt@hotmail.com'),
	(18,'Vidal','Amendine','23 avenue de la fontaine','Boissy le sec','91228','0627272888','avidal@gmail.com'),
	(19,'Royer','Anthony','15 rue des pigeons','Arpajon','91876','0196789079','aroyer@gmail.com'),
	(20,'Robin','Matilde','09 avenue de la motte','Evry','91039','0637683738','m.robin@gmail.com'),
	(21,'ABIB','James','187 rue du brelor','Etampes','91150','0698574989','james.abibamman@gmail.com'),
	(22,'Vernhes','Jordan','52 rue de la boite','Evry','91966','0613192346','jordan.vernhes@gmail.com'),
	(23,'Gauret','Lucas','20 rue de la pate','Etampe','91150','0732196734','l.gauret@gmail.com');

/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
