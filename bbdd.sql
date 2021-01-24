DROP DATABASE IF EXISTS bbdd;
CREATE DATABASE bbdd;
USE bbdd;

CREATE TABLE User (
	ID TEXT NOT NULL,
	uname TEXT NOT NULL,
	pswrd TEXT NOT NULL,
	email TEXT NOT NULL,
	idGame TEXT NOT NULL,
	cash INT
);

CREATE TABLE Item (
    ID TEXT NOT NULL,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    qualityUpdater TEXT NOT NULL,
    quantityUpdater INT,
    price INT,
    image TEXT NOT NULL
);

CREATE TABLE Achievements (
    ID TEXT NOT NULL,
    calcAch INT,
    electronicsAch INT,
    commsAch INT,
    oescAch INT,
    dsaAch INT ,
    aeroAch INT,
    tfgAch INT
);

CREATE TABLE Game (
    ID TEXT NOT NULL,
    idObjects TEXT NOT NULL,
    idAchievements TEXT NOT NULL,
    idMap TEXT NOT NULL
);

CREATE TABLE Inventory (
    ID TEXT NOT NULL,
    turtleQuantity INT,
    coffQuantity INT,
    redbullQuantity INT,
    pillsQuantity INT,
    calculatorQuantity INT,
    ruleQuantity INT,
    compassQuantity INT,
    pencilQuantity INT,
    glassesQuantity INT,
    puzzleQuantity INT,
    bookQuantity INT,
    usbQuantity INT,
    cheatQuantity INT
);

CREATE TABLE Maps (
    ID TEXT NOT NULL,
    name TEXT NOT NULL,
    vectMap TEXT NOT NULL
);