-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 10 juin 2022 à 20:53
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `g_personnels`
--

-- --------------------------------------------------------

--
-- Structure de la table `admis`
--

CREATE TABLE `admis` (
  `Id_ADMIS` int(11) NOT NULL,
  `Nom_ADMIS` varchar(100) NOT NULL,
  `Prenom_ADMIS` varchar(100) NOT NULL,
  `Naiss_ADMIS` date NOT NULL,
  `Tel_ADMIS` varchar(10) NOT NULL,
  `Email_ADMIS` varchar(100) NOT NULL,
  `Situation_F_ADMIS` varchar(100) NOT NULL,
  `Adresse_ADMIS` varchar(100) NOT NULL,
  `Photo_ADMIS` varchar(100) NOT NULL,
  `CIN_ADMIS` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admis`
--

INSERT INTO `admis` (`Id_ADMIS`, `Nom_ADMIS`, `Prenom_ADMIS`, `Naiss_ADMIS`, `Tel_ADMIS`, `Email_ADMIS`, `Situation_F_ADMIS`, `Adresse_ADMIS`, `Photo_ADMIS`, `CIN_ADMIS`) VALUES
(1, 'El Malki', 'Zineb', '2000-06-14', '0612345678', 'zinebElMalki@gmail.com', 'Celebataire', 'Ben Ahemad', 'agent_photo.png', 'JR567'),
(3, 'Chhaib', 'Fatima', '2000-01-03', '0708145283', 'chhaibFatima@gmail.com', 'Celebataire', 'Casablanca', 'agent_photo.png', 'BA8600'),
(4, 'El Jabirri', 'Meriam', '2000-06-01', '0672776090', 'MeriamElJabirri@gmail.com', 'Marie', 'Casablanca', 'agent_photo.png', 'BG3456');

-- --------------------------------------------------------

--
-- Structure de la table `affectation`
--

CREATE TABLE `affectation` (
  `Id_UA` int(11) NOT NULL,
  `Id_AGENT` int(11) NOT NULL,
  `Date_Affectation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `affectation`
--

INSERT INTO `affectation` (`Id_UA`, `Id_AGENT`, `Date_Affectation`) VALUES
(1, 1, '2022-06-10'),
(1, 2, '2022-06-10');

-- --------------------------------------------------------

--
-- Structure de la table `agent`
--

CREATE TABLE `agent` (
  `Id_AGENT` int(11) NOT NULL,
  `Nom_AGENT` varchar(100) NOT NULL,
  `Prenom_AGENT` varchar(100) NOT NULL,
  `Naiss_AGENT` date NOT NULL,
  `Tel_AGENT` varchar(10) NOT NULL,
  `Email_AGENT` varchar(100) NOT NULL,
  `Situation_F_AGENT` varchar(100) NOT NULL,
  `Adresse_AGENT` varchar(100) NOT NULL,
  `Photo_AGENT` varchar(100) NOT NULL,
  `CIN_AGENT` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `agent`
--

INSERT INTO `agent` (`Id_AGENT`, `Nom_AGENT`, `Prenom_AGENT`, `Naiss_AGENT`, `Tel_AGENT`, `Email_AGENT`, `Situation_F_AGENT`, `Adresse_AGENT`, `Photo_AGENT`, `CIN_AGENT`) VALUES
(1, 'Baraka', 'Zineb', '2000-06-13', '0708145283', 'zinebbaraka@gmail.com', 'Celebataire', 'Sidi Hejjaj', 'agent_photo.png', 'B4000'),
(2, 'El Malki', 'Zineb', '2000-01-05', '0612345678', 'zinebElMalki@gmail.com', 'Celebataire', 'Ben Ahemad', 'agent_photo.png', 'JE3456');

-- --------------------------------------------------------

--
-- Structure de la table `ar`
--

CREATE TABLE `ar` (
  `Id_AR` int(11) NOT NULL,
  `Id_DCP` int(11) NOT NULL,
  `Nom_AR` varchar(100) NOT NULL,
  `Region_AR` varchar(100) NOT NULL,
  `Ville_AR` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ar`
--

INSERT INTO `ar` (`Id_AR`, `Id_DCP`, `Nom_AR`, `Region_AR`, `Ville_AR`) VALUES
(1, 1, 'AR ', 'Casablanca-Settat', 'Casablanca');

-- --------------------------------------------------------

--
-- Structure de la table `archive_decision`
--

CREATE TABLE `archive_decision` (
  `Id_POSTE` int(11) NOT NULL,
  `Id_ADMIS` int(11) NOT NULL,
  `Avis_Prise_Fonction` varchar(100) NOT NULL,
  `Date_prev` date NOT NULL,
  `Visa` varchar(100) NOT NULL,
  `Status_DECISION` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `archive_decision`
--

INSERT INTO `archive_decision` (`Id_POSTE`, `Id_ADMIS`, `Avis_Prise_Fonction`, `Date_prev`, `Visa`, `Status_DECISION`) VALUES
(2, 1, 'PRISE', '2022-06-30', 'Accepte', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `carierre`
--

CREATE TABLE `carierre` (
  `Id_POSTE` int(11) NOT NULL,
  `Id_AGENT` int(11) NOT NULL,
  `Date_Occupation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `carierre`
--

INSERT INTO `carierre` (`Id_POSTE`, `Id_AGENT`, `Date_Occupation`) VALUES
(1, 1, '2022-06-10'),
(2, 2, '2022-06-10'),
(3, 2, '2022-06-10');

-- --------------------------------------------------------

--
-- Structure de la table `conge`
--

CREATE TABLE `conge` (
  `Id_Conge` int(11) NOT NULL,
  `Id_AGENT` int(11) NOT NULL,
  `Type_Conge` varchar(100) NOT NULL,
  `Date_Debut` date NOT NULL,
  `Date_Fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `conge`
--

INSERT INTO `conge` (`Id_Conge`, `Id_AGENT`, `Type_Conge`, `Date_Debut`, `Date_Fin`) VALUES
(1, 1, 'MATERNITE', '2022-06-10', '2022-06-30'),
(2, 2, 'MATERNITE', '2022-06-10', '2022-06-30');

-- --------------------------------------------------------

--
-- Structure de la table `dcp`
--

CREATE TABLE `dcp` (
  `Id_DCP` int(11) NOT NULL,
  `Nom_DCP` varchar(100) NOT NULL,
  `Login_DCP` varchar(100) NOT NULL,
  `Passwd_DCP` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `dcp`
--

INSERT INTO `dcp` (`Id_DCP`, `Nom_DCP`, `Login_DCP`, `Passwd_DCP`) VALUES
(1, 'DCP', 'DCP', '12345');

-- --------------------------------------------------------

--
-- Structure de la table `decision`
--

CREATE TABLE `decision` (
  `Id_POSTE` int(11) NOT NULL,
  `Id_ADMIS` int(11) NOT NULL,
  `Avis_Prise_Fonction` varchar(100) NOT NULL,
  `Date_prev` date NOT NULL,
  `Visa` varchar(100) NOT NULL,
  `Status_DECISION` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `decision`
--

INSERT INTO `decision` (`Id_POSTE`, `Id_ADMIS`, `Avis_Prise_Fonction`, `Date_prev`, `Visa`, `Status_DECISION`) VALUES
(1, 3, 'Non Prise', '2022-06-30', '', b'0');

--
-- Déclencheurs `decision`
--
DELIMITER $$
CREATE TRIGGER `Prise_Fonction` AFTER UPDATE ON `decision` FOR EACH ROW IF (new.Avis_Prise_Fonction='PRISE')THEN
 insert into archive_decision(Id_POSTE,Id_ADMIS,Avis_Prise_Fonction,Date_Prev,Visa,Status_DECISION)VALUES(new.Id_POSTE,new.Id_ADMIS,new.Avis_Prise_Fonction,new.Date_Prev,new.Visa,new.Status_DECISION);
 INSERT INTO agent(CIN_AGENT,Nom_AGENT,Prenom_AGENT,Naiss_AGENT,Tel_AGENT,Email_AGENT,Situation_F_AGENT,Adresse_AGENT,Photo_AGENT)
SELECT CIN_ADMIS,Nom_ADMIS,Prenom_ADMIS,Naiss_ADMIS,Tel_ADMIS,Email_ADMIS,Situation_F_ADMIS,Adresse_ADMIS,Photo_ADMIS FROM admis,decision WHERE decision.Id_ADMIS=admis.Id_ADMIS  AND decision.Id_ADMIS=new.Id_ADMIS;



set @idagent=(SELECT Id_AGENT from agent where CIN_AGENT=( select CIN_ADMIS from decision ,admis where admis.Id_ADMIS=decision.Id_ADMIS AND admis.Id_ADMIS=new.Id_ADMIS
AND CIN_ADMIS =(SELECT CIN_ADMIS FROM admis WHERE Id_ADMIS=new.Id_ADMIS)));

set @Id_UA=(
SELECT Id_UA from ua where Id_UA=( select  distinct Id_UA from decision ,poste where poste.Id_POSTE=decision.Id_POSTE AND poste.Id_POSTE=new.Id_POSTE ));

set @dateAfect=(SELECT CAST(NOW() AS DATE));
insert into affectation(Id_UA,Id_AGENT,Date_Affectation)VALUES(@Id_UA,@idagent,@dateAfect);


INSERT INTO carierre values (@idagent,new.Id_POSTE,@dateAfect);


  END IF
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `diplome`
--

CREATE TABLE `diplome` (
  `Id_DIPLOME` int(11) NOT NULL,
  `Id_AGENT` int(11) NOT NULL,
  `Nom_DIPLOME` varchar(100) NOT NULL,
  `Date_Obtention` date NOT NULL,
  `Spacialite_DIPLOME` varchar(100) NOT NULL,
  `Etablisssement` varchar(100) NOT NULL,
  `Mention_DIPLOME` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `diplome`
--

INSERT INTO `diplome` (`Id_DIPLOME`, `Id_AGENT`, `Nom_DIPLOME`, `Date_Obtention`, `Spacialite_DIPLOME`, `Etablisssement`, `Mention_DIPLOME`) VALUES
(2, 1, 'Bac', '2018-12-31', 'PC', 'AbdeAllah', 'Tres Bien'),
(3, 2, 'Bac', '2019-06-30', 'SVT', 'AdbeAllah', 'Tres Bien');

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `Id_Emp` int(11) NOT NULL,
  `Id_SP` int(11) NOT NULL,
  `Nom_Emp` varchar(100) NOT NULL,
  `Prenom_Emp` varchar(100) NOT NULL,
  `Login_Emp` varchar(100) NOT NULL,
  `Passwd_Emp` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`Id_Emp`, `Id_SP`, `Nom_Emp`, `Prenom_Emp`, `Login_Emp`, `Passwd_Emp`) VALUES
(1, 1, 'NEmp1', 'PEmp1', 'AR', '12345');

-- --------------------------------------------------------

--
-- Structure de la table `grade`
--

CREATE TABLE `grade` (
  `Id_GRADE` int(11) NOT NULL,
  `Id_AGENT` int(11) NOT NULL,
  `Nom_GRADE` varchar(100) NOT NULL,
  `Date_GRADE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `grade`
--

INSERT INTO `grade` (`Id_GRADE`, `Id_AGENT`, `Nom_GRADE`, `Date_GRADE`) VALUES
(1, 1, 'grade5', '2022-01-03'),
(2, 2, 'Grade4', '2022-06-10');

-- --------------------------------------------------------

--
-- Structure de la table `poste`
--

CREATE TABLE `poste` (
  `Id_POSTE` int(11) NOT NULL,
  `Nom_POSTE` varchar(100) NOT NULL,
  `Grade_Poste` varchar(100) NOT NULL,
  `Salaire` double NOT NULL,
  `Status_POSTE` bit(1) NOT NULL,
  `Id_UA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `poste`
--

INSERT INTO `poste` (`Id_POSTE`, `Nom_POSTE`, `Grade_Poste`, `Salaire`, `Status_POSTE`, `Id_UA`) VALUES
(1, 'Responsable ', 'grade9', 20000, b'1', 1),
(2, 'Responsable G', 'Grade4', 18000, b'0', 1),
(3, 'Responsable T', 'Grade 7', 13000, b'0', 1);

-- --------------------------------------------------------

--
-- Structure de la table `qualification`
--

CREATE TABLE `qualification` (
  `Id_QAULIFICATION` int(11) NOT NULL,
  `Id_AGENT` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Date_QUALIFICATION` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `qualification`
--

INSERT INTO `qualification` (`Id_QAULIFICATION`, `Id_AGENT`, `Description`, `Date_QUALIFICATION`) VALUES
(1, 1, 'Gestion de stress', '2022-06-10'),
(2, 1, 'Gestion de stress', '2022-06-17'),
(3, 1, 'Bac +5', '2022-06-10'),
(4, 1, 'Bac +3', '2022-06-10');

-- --------------------------------------------------------

--
-- Structure de la table `scf`
--

CREATE TABLE `scf` (
  `Id_SCF` int(11) NOT NULL,
  `Id_DCP` int(11) NOT NULL,
  `Login_SCF` varchar(100) NOT NULL,
  `Passwd_SCF` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `scf`
--

INSERT INTO `scf` (`Id_SCF`, `Id_DCP`, `Login_SCF`, `Passwd_SCF`) VALUES
(1, 1, 'SCF', '12345');

-- --------------------------------------------------------

--
-- Structure de la table `sp`
--

CREATE TABLE `sp` (
  `Id_SP` int(11) NOT NULL,
  `Id_AR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `sp`
--

INSERT INTO `sp` (`Id_SP`, `Id_AR`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `sr`
--

CREATE TABLE `sr` (
  `Id_SR` int(11) NOT NULL,
  `Id_DCP` int(11) NOT NULL,
  `Login_SR` varchar(100) NOT NULL,
  `Passwd_SR` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `sr`
--

INSERT INTO `sr` (`Id_SR`, `Id_DCP`, `Login_SR`, `Passwd_SR`) VALUES
(1, 1, 'SR', '12345');

-- --------------------------------------------------------

--
-- Structure de la table `ua`
--

CREATE TABLE `ua` (
  `Id_UA` int(11) NOT NULL,
  `Id_AR` int(11) NOT NULL,
  `Nom_UA` varchar(100) NOT NULL,
  `Id_Resp` int(11) NOT NULL,
  `Login_UA` varchar(100) NOT NULL,
  `PasswdUA` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ua`
--

INSERT INTO `ua` (`Id_UA`, `Id_AR`, `Nom_UA`, `Id_Resp`, `Login_UA`, `PasswdUA`) VALUES
(1, 1, 'UA1', 1, 'UA', '12345');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admis`
--
ALTER TABLE `admis`
  ADD PRIMARY KEY (`Id_ADMIS`);

--
-- Index pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD PRIMARY KEY (`Id_UA`,`Id_AGENT`),
  ADD KEY `Id_AGENT` (`Id_AGENT`);

--
-- Index pour la table `agent`
--
ALTER TABLE `agent`
  ADD PRIMARY KEY (`Id_AGENT`);

--
-- Index pour la table `ar`
--
ALTER TABLE `ar`
  ADD PRIMARY KEY (`Id_AR`),
  ADD KEY `Id_DCP` (`Id_DCP`);

--
-- Index pour la table `archive_decision`
--
ALTER TABLE `archive_decision`
  ADD KEY `Id_POSTE` (`Id_POSTE`),
  ADD KEY `Id_ADMIS` (`Id_ADMIS`);

--
-- Index pour la table `carierre`
--
ALTER TABLE `carierre`
  ADD PRIMARY KEY (`Id_POSTE`,`Id_AGENT`),
  ADD KEY `Id_AGENT` (`Id_AGENT`);

--
-- Index pour la table `conge`
--
ALTER TABLE `conge`
  ADD PRIMARY KEY (`Id_Conge`),
  ADD KEY `Id_AGENT` (`Id_AGENT`);

--
-- Index pour la table `dcp`
--
ALTER TABLE `dcp`
  ADD PRIMARY KEY (`Id_DCP`);

--
-- Index pour la table `decision`
--
ALTER TABLE `decision`
  ADD PRIMARY KEY (`Id_POSTE`,`Id_ADMIS`),
  ADD KEY `Id_ADMIS` (`Id_ADMIS`);

--
-- Index pour la table `diplome`
--
ALTER TABLE `diplome`
  ADD PRIMARY KEY (`Id_DIPLOME`),
  ADD KEY `Id_AGENT` (`Id_AGENT`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`Id_Emp`),
  ADD KEY `Id_SP` (`Id_SP`);

--
-- Index pour la table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`Id_GRADE`),
  ADD KEY `Id_AGENT` (`Id_AGENT`);

--
-- Index pour la table `poste`
--
ALTER TABLE `poste`
  ADD PRIMARY KEY (`Id_POSTE`),
  ADD KEY `Id_UA` (`Id_UA`);

--
-- Index pour la table `qualification`
--
ALTER TABLE `qualification`
  ADD PRIMARY KEY (`Id_QAULIFICATION`),
  ADD KEY `Id_AGENT` (`Id_AGENT`);

--
-- Index pour la table `scf`
--
ALTER TABLE `scf`
  ADD PRIMARY KEY (`Id_SCF`),
  ADD KEY `Id_DCP` (`Id_DCP`);

--
-- Index pour la table `sp`
--
ALTER TABLE `sp`
  ADD PRIMARY KEY (`Id_SP`),
  ADD KEY `Id_AR` (`Id_AR`);

--
-- Index pour la table `sr`
--
ALTER TABLE `sr`
  ADD PRIMARY KEY (`Id_SR`),
  ADD KEY `Id_DCP` (`Id_DCP`);

--
-- Index pour la table `ua`
--
ALTER TABLE `ua`
  ADD PRIMARY KEY (`Id_UA`),
  ADD KEY `Id_AR` (`Id_AR`),
  ADD KEY `Id_Resp` (`Id_Resp`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admis`
--
ALTER TABLE `admis`
  MODIFY `Id_ADMIS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `agent`
--
ALTER TABLE `agent`
  MODIFY `Id_AGENT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `ar`
--
ALTER TABLE `ar`
  MODIFY `Id_AR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `conge`
--
ALTER TABLE `conge`
  MODIFY `Id_Conge` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `dcp`
--
ALTER TABLE `dcp`
  MODIFY `Id_DCP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `diplome`
--
ALTER TABLE `diplome`
  MODIFY `Id_DIPLOME` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `employe`
--
ALTER TABLE `employe`
  MODIFY `Id_Emp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `grade`
--
ALTER TABLE `grade`
  MODIFY `Id_GRADE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `poste`
--
ALTER TABLE `poste`
  MODIFY `Id_POSTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `qualification`
--
ALTER TABLE `qualification`
  MODIFY `Id_QAULIFICATION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `scf`
--
ALTER TABLE `scf`
  MODIFY `Id_SCF` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `sp`
--
ALTER TABLE `sp`
  MODIFY `Id_SP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `sr`
--
ALTER TABLE `sr`
  MODIFY `Id_SR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `ua`
--
ALTER TABLE `ua`
  MODIFY `Id_UA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD CONSTRAINT `affectation_ibfk_1` FOREIGN KEY (`Id_UA`) REFERENCES `ua` (`Id_UA`) ON DELETE CASCADE,
  ADD CONSTRAINT `affectation_ibfk_2` FOREIGN KEY (`Id_AGENT`) REFERENCES `agent` (`Id_AGENT`) ON DELETE CASCADE;

--
-- Contraintes pour la table `ar`
--
ALTER TABLE `ar`
  ADD CONSTRAINT `ar_ibfk_1` FOREIGN KEY (`Id_DCP`) REFERENCES `dcp` (`Id_DCP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `archive_decision`
--
ALTER TABLE `archive_decision`
  ADD CONSTRAINT `archive_decision_ibfk_1` FOREIGN KEY (`Id_POSTE`) REFERENCES `poste` (`Id_POSTE`) ON DELETE CASCADE,
  ADD CONSTRAINT `archive_decision_ibfk_2` FOREIGN KEY (`Id_ADMIS`) REFERENCES `admis` (`Id_ADMIS`) ON DELETE CASCADE;

--
-- Contraintes pour la table `carierre`
--
ALTER TABLE `carierre`
  ADD CONSTRAINT `carierre_ibfk_1` FOREIGN KEY (`Id_AGENT`) REFERENCES `agent` (`Id_AGENT`) ON DELETE CASCADE,
  ADD CONSTRAINT `carierre_ibfk_2` FOREIGN KEY (`Id_POSTE`) REFERENCES `poste` (`Id_POSTE`) ON DELETE CASCADE;

--
-- Contraintes pour la table `conge`
--
ALTER TABLE `conge`
  ADD CONSTRAINT `conge_ibfk_1` FOREIGN KEY (`Id_AGENT`) REFERENCES `agent` (`Id_AGENT`) ON DELETE CASCADE;

--
-- Contraintes pour la table `decision`
--
ALTER TABLE `decision`
  ADD CONSTRAINT `decision_ibfk_1` FOREIGN KEY (`Id_ADMIS`) REFERENCES `admis` (`Id_ADMIS`) ON DELETE CASCADE,
  ADD CONSTRAINT `decision_ibfk_2` FOREIGN KEY (`Id_POSTE`) REFERENCES `poste` (`Id_POSTE`) ON DELETE CASCADE;

--
-- Contraintes pour la table `diplome`
--
ALTER TABLE `diplome`
  ADD CONSTRAINT `diplome_ibfk_1` FOREIGN KEY (`Id_AGENT`) REFERENCES `agent` (`Id_AGENT`) ON DELETE CASCADE;

--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `employe_ibfk_1` FOREIGN KEY (`Id_SP`) REFERENCES `sp` (`Id_SP`) ON DELETE CASCADE;

--
-- Contraintes pour la table `grade`
--
ALTER TABLE `grade`
  ADD CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`Id_AGENT`) REFERENCES `agent` (`Id_AGENT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `poste`
--
ALTER TABLE `poste`
  ADD CONSTRAINT `poste_ibfk_1` FOREIGN KEY (`Id_UA`) REFERENCES `ua` (`Id_UA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `qualification`
--
ALTER TABLE `qualification`
  ADD CONSTRAINT `qualification_ibfk_1` FOREIGN KEY (`Id_AGENT`) REFERENCES `agent` (`Id_AGENT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `scf`
--
ALTER TABLE `scf`
  ADD CONSTRAINT `scf_ibfk_1` FOREIGN KEY (`Id_DCP`) REFERENCES `dcp` (`Id_DCP`) ON DELETE CASCADE;

--
-- Contraintes pour la table `sp`
--
ALTER TABLE `sp`
  ADD CONSTRAINT `sp_ibfk_1` FOREIGN KEY (`Id_AR`) REFERENCES `ar` (`Id_AR`) ON DELETE CASCADE;

--
-- Contraintes pour la table `sr`
--
ALTER TABLE `sr`
  ADD CONSTRAINT `sr_ibfk_1` FOREIGN KEY (`Id_DCP`) REFERENCES `dcp` (`Id_DCP`) ON DELETE CASCADE;

--
-- Contraintes pour la table `ua`
--
ALTER TABLE `ua`
  ADD CONSTRAINT `ua_ibfk_1` FOREIGN KEY (`Id_AR`) REFERENCES `ar` (`Id_AR`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ua_ibfk_2` FOREIGN KEY (`Id_Resp`) REFERENCES `agent` (`Id_AGENT`);

DELIMITER $$
--
-- Évènements
--
CREATE DEFINER=`root`@`localhost` EVENT `Echanchier` ON SCHEDULE EVERY 1 DAY STARTS '2022-06-10 00:00:00' ENDS '2022-06-30 19:50:50' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM decision WHERE
decision.Avis_Prise_Fonction='PRISE'$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
