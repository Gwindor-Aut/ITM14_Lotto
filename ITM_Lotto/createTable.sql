-- --------------------------------------------------------------------
--
-- CREATE DATABASE
--
-- --------------------------------------------------------------------

--
-- Datenbank: `lotto`
--
DROP DATABASE lotto;
CREATE DATABASE IF NOT EXISTS lotto;

USE lotto;

-- --------------------------------------------------------------------
--
-- CREATE TABLES
--
-- --------------------------------------------------------------------
--
-- Tabellenstruktur für Tabelle `accoutings`
--

CREATE TABLE IF NOT EXISTS accountings(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	balance int,
	diffBalance int,
	fk_userid int,
	description varchar(250),
	`date` date
)ENGINE = InnoDB;

--
-- Tabellenstruktur für Tabelle `users`
--

CREATE TABLE IF NOT EXISTS users(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username varchar(50) NOT NULL,
	password varchar(32) NOT NULL 
)ENGINE = InnoDB;

--
-- Tabellenstruktur für Tabelle `messages`
--

CREATE TABLE IF NOT EXISTS messages(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`date` date,
	`isRead` boolean,
	`text` varchar(250),
	fk_userid int 
)ENGINE = InnoDB;

--
-- Tabellenstruktur für Tabelle `tipps`
--

CREATE TABLE IF NOT EXISTS tipps(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`date` date,
	`numbers` varchar(17),
	fk_userid int,
	fk_drawid int, 
	isQuickTipp boolean
)ENGINE = InnoDB;

--
-- Tabellenstruktur für Tabelle `draws`
--

CREATE TABLE IF NOT EXISTS draws(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	pot int,
	`date` date,
	fk_winningLevelid int,
	`numbers` varchar(17),
	jackpotLevel tinyint,
	priceOfTipp tinyint,
	taxrate tinyint,
	ownerrate tinyint
)ENGINE = InnoDB;

--
-- Tabellenstruktur für Tabelle `winningLevels`
--

CREATE TABLE IF NOT EXISTS winningLevels(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`date` date,
	six tinyint,
	five tinyint,
	four tinyint,
	three tinyint
)ENGINE = InnoDB;
-- --------------------------------------------------------------------
--
-- ALTER STATEMENTS
--
-- --------------------------------------------------------------------
ALTER TABLE accountings 
	ADD CONSTRAINT userAccountings 
	FOREIGN KEY (fk_userid)
	REFERENCES users(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE;

ALTER TABLE messages 
	ADD CONSTRAINT userMessages 
	FOREIGN KEY (fk_userid)
	REFERENCES users(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE;

ALTER TABLE tipps 
	ADD CONSTRAINT userTipps 
	FOREIGN KEY (fk_userid)
	REFERENCES users(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE;

ALTER TABLE tipps 
	ADD CONSTRAINT tippDraws
	FOREIGN KEY (fk_drawid)
	REFERENCES draws(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE;

ALTER TABLE draws
	ADD CONSTRAINT drawWinnings
	FOREIGN KEY (fk_winningLevelid)
	REFERENCES winningLevels(id)
	ON UPDATE CASCADE
	ON DELETE CASCADE;




-- --------------------------------------------------------------------
--
-- HELPER
--
-- --------------------------------------------------------------------
-- IP - 10.65.1.71 mariadb and WILDFLY
-- root toor for login
-- mysql -u root -p
-- to execute file use - source file.xy
-- to use the lotto table - use lotto
-- get all databases - show databases;
-- get all tables - show tables;
-- get table information - descripe tablename