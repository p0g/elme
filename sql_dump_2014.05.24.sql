-- phpMyAdmin SQL Dump
-- version 3.3.7deb7
-- http://www.phpmyadmin.net
--
-- Host: wp266.webpack.hosteurope.de
-- Erstellungszeit: 24. Mai 2014 um 19:18
-- Server Version: 5.5.31
-- PHP-Version: 5.3.3-7+squeeze19

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `db10619302-uni`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `adressen`
--

CREATE TABLE IF NOT EXISTS `adressen` (
  `mitglied_id` int(11) NOT NULL,
  `strasse` varchar(32) COLLATE latin1_german2_ci NOT NULL,
  `hausnummer` varchar(16) COLLATE latin1_german2_ci NOT NULL,
  `plz` int(16) NOT NULL,
  `ort` varchar(32) COLLATE latin1_german2_ci NOT NULL,
  `land` varchar(32) COLLATE latin1_german2_ci NOT NULL,
  PRIMARY KEY (`mitglied_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;

--
-- Daten für Tabelle `adressen`
--

INSERT INTO `adressen` (`mitglied_id`, `strasse`, `hausnummer`, `plz`, `ort`, `land`) VALUES
(1001, 'Teststraße', '22a', 44882, 'Dortmund', 'Deutschland'),
(1027, 'strasse', '12', 22234, 'Dorf', 'Deutschland'),
(1026, 'strasse', '12', 22234, 'Dorf', 'Deutschland');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `buecher`
--

CREATE TABLE IF NOT EXISTS `buecher` (
  `mediumid` int(11) NOT NULL,
  `verfasser` varchar(64) NOT NULL,
  `verlag` varchar(64) NOT NULL,
  `isbn` varchar(64) NOT NULL,
  PRIMARY KEY (`mediumid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `buecher`
--

INSERT INTO `buecher` (`mediumid`, `verfasser`, `verlag`, `isbn`) VALUES
(1, 'James Dick', 'Stern Verlag', '123-456-789'),
(2, 'Kirk', 'Buchbinder', '222-333-444');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `cds`
--

CREATE TABLE IF NOT EXISTS `cds` (
  `mediumid` int(11) NOT NULL,
  `interpret` varchar(64) NOT NULL,
  `label` varchar(64) NOT NULL,
  PRIMARY KEY (`mediumid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `cds`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `dvds`
--

CREATE TABLE IF NOT EXISTS `dvds` (
  `mediumid` int(11) NOT NULL,
  `fsk` int(11) NOT NULL,
  `spieldauer` int(11) NOT NULL COMMENT 'Spieldauer in Minuten',
  PRIMARY KEY (`mediumid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `dvds`
--

INSERT INTO `dvds` (`mediumid`, `fsk`, `spieldauer`) VALUES
(3, 12, 120);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `leihen`
--

CREATE TABLE IF NOT EXISTS `leihen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `mitglied` int(11) NOT NULL,
  `medium` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Daten für Tabelle `leihen`
--

INSERT INTO `leihen` (`id`, `date`, `mitglied`, `medium`) VALUES
(6, '2014-06-16', 1001, 2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `medien`
--

CREATE TABLE IF NOT EXISTS `medien` (
  `mediumid` int(11) NOT NULL AUTO_INCREMENT,
  `medium_typ_id` int(11) NOT NULL,
  `titel` varchar(32) NOT NULL,
  `signatur` varchar(16) NOT NULL,
  `jahr` year(4) NOT NULL,
  `entliehen` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`mediumid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Daten für Tabelle `medien`
--

INSERT INTO `medien` (`mediumid`, `medium_typ_id`, `titel`, `signatur`, `jahr`, `entliehen`) VALUES
(1, 1, 'Das erste Buch', 'B-0', 1999, 0),
(2, 1, 'Das zweite Buch', 'B-1', 2000, 1),
(3, 2, 'Die Reise', 'DVD-2', 1980, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `medien_typen`
--

CREATE TABLE IF NOT EXISTS `medien_typen` (
  `medium_typ_id` int(11) NOT NULL,
  `name` varchar(64) CHARACTER SET latin1 COLLATE latin1_german2_ci NOT NULL,
  `beschreibung` varchar(64) CHARACTER SET latin1 COLLATE latin1_german2_ci NOT NULL,
  PRIMARY KEY (`medium_typ_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `medien_typen`
--

INSERT INTO `medien_typen` (`medium_typ_id`, `name`, `beschreibung`) VALUES
(1, 'Buch', 'Bücher'),
(2, 'DVD', 'DVDs'),
(3, 'CD', 'CDs');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `mitglieder`
--

CREATE TABLE IF NOT EXISTS `mitglieder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `vorname` varchar(32) NOT NULL,
  `benutzername` varchar(32) NOT NULL,
  `passwort` varchar(32) NOT NULL,
  `geburtsdatum` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1028 ;

--
-- Daten für Tabelle `mitglieder`
--

INSERT INTO `mitglieder` (`id`, `name`, `vorname`, `benutzername`, `passwort`, `geburtsdatum`) VALUES
(1001, 'Mustermann', 'Max', 'mamu', 'mamu1', '2014-05-14'),
(1027, 'Müller', 'Peter', 'pemü', 'pemü1', '1990-06-21'),
(1026, 'M¸ller', 'Peter', 'pem¸', 'pem¸1', '1990-06-21');
