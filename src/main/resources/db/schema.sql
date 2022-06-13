DROP TABLE IF EXISTS person;

CREATE TABLE person
(
   id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
   is_mutant boolean  NOT NULL,
   dna varchar(100) NOT NULL UNIQUE
);