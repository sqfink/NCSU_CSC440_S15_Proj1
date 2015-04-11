SET foreign_key_checks = 0;

CREATE TABLE users(
	id INT NOT NULL UNIQUE,
	password VARCHAR(64),
	PRIMARY KEY (id)
); 

CREATE TABLE student(
	snumber INT NOT NULL UNIQUE,
	firstname VARCHAR(40),
	lastname VARCHAR(40),
	rentalstatus VARCHAR(10),
	leasenumber INT NOT NULL,
	parkingnumber INT NOT NULL,
	dob VARCHAR(10),
	phone VARCHAR(12),
	alternatephone VARCHAR(12),
	nationality VARCHAR(20),
	address varchar(30) NOT NULL,
	city varchar(15) NOT NULL,
	state varchar(2) NOT NULL,
	country varchar(32) NOT NULL,
	zip varchar(10),
	year INT(4) NOT NULL,
	specialneeds varchar(50),
	comments varchar(150),
	sex varchar(1) NOT NULL,
	smoker varchar(1) NOT NULL,
	guest INT(1) NOT NULL,
	PRIMARY KEY (snumber)
); 

CREATE TABLE family(
	snumber INT NOT NULL,
	name VARCHAR(40),
	dob VARCHAR(10),
	FOREIGN KEY (snumber) REFERENCES student(snumber)
);

CREATE TABLE nextofkin(
	snumber INT NOT NULL,
	firstname VARCHAR(40),
	lastname VARCHAR(40),
	address varchar(30),
	city varchar(15),
	state varchar(2),
	zip varchar(10),
	sex varchar(1),
	FOREIGN KEY (snumber) REFERENCES student(snumber)
); 

CREATE TABLE course(
	snumber INT NOT NULL,
	cnumber INT NOT NULL,
	grade INT NOT NULL,
	FOREIGN KEY (snumber) REFERENCES student(snumber)
); 

CREATE TABLE lease(
	leasenumber INT(10) primary key,
	placenumber INT(10) NOT NULL,
	snumber INT NOT NULL,
	sname VARCHAR(40),
	roomnumber INT NOT NULL,
	paymentduration INT,
	earlyterminationfee INT,
	securitydeposits INT,
	rentalperiod VARCHAR(10),
	FOREIGN KEY (placenumber) REFERENCES places(placenumber)
);

CREATE TABLE studentflat(
	appnumber INT(10) unsigned auto_increment primary key,
	placenumber INT(10),
	bathrooms INT,
	flattype VARCHAR(20),
	private VARCHAR(1),
	bedrooms INT,
	rate INT,
	roomnumber INT
);

CREATE TABLE parking(
	parkingnumber INT(10) unsigned auto_increment primary key,
	lotsavailable INT(10),
	snumber INT NOT NULL,
	FOREIGN KEY (snumber) REFERENCES student(snumber)
);

CREATE TABLE housing(
	housingLocation INT(10) NOT NULL PRIMARY KEY,
	name VARCHAR(32) NOT NULL,
	address VARCHAR(100) NOT NULL,
	city VARCHAR(15) NOT NULL, 
	state VARCHAR(2) NOT NULL,
	zip VARCHAR(10) NOT NULL,
	supervisor INT NOT NULL,
	requiredYear INT NOT NULL,
	FOREIGN KEY (supervisor) REFERENCES staff(staffnumber)
);

CREATE TABLE places(
	placenumber INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	housingLocation INT NOT NULL,
	snumber INT NOT NULL,
	FOREIGN KEY (housingLocation) REFERENCES housing(housingLocation),
	FOREIGN KEY (snumber) REFERENCES student(snumber)
);

CREATE TABLE appartments(
	housingLocation INT(10) NOT NULL,
	rent REAL NOT NULL,
	deposit REAL NOT NULL,
	apttype VARCHAR(64) NOT NULL,
	FOREIGN KEY (housingLocation) REFERENCES housing(housingLocation)
);

CREATE TABLE parkingclasscosts(
	classification VARCHAR(32) NOT NULL,
	cost REAL NOT NULL
);

CREATE TABLE parkinglotsnear(
	lotnumber INT(10) NOT NULL PRIMARY KEY,
	near INT(10) NOT NULL,
	FOREIGN KEY (near) REFERENCES housing(housingLocation)
);

CREATE TABLE parkingspots(
	spotnumber INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	lotnumber INT(10),
	classification VARCHAR(30),
	snumber INT(11), 
	FOREIGN KEY (snumber) REFERENCES student(snumber)
);

CREATE TABLE studenthallinspection(
	staffname VARCHAR(30) NOT NULL,
	residencename VARCHAR(30) NOT NULL,
	inspectiondate VARCHAR(10),
	propertycondition VARCHAR(20),
	comments VARCHAR(50)
);

CREATE TABLE staff(
	staffnumber INT NOT NULL,
	firstname VARCHAR(40),
	lastname VARCHAR(40),
	location VARCHAR(40),
	department VARCHAR(50),
	position VARCHAR(50),
	dob VARCHAR(10),
	address varchar(30),
	city varchar(15),
	state varchar(2),
	zip varchar(10),
	sex varchar(1),
	PRIMARY KEY (staffnumber)
); 

CREATE TABLE invoices(
	invoicenumber INT NOT NULL,
	snumber INT NOT NULL,
	staffname VARCHAR(40),
	residencename VARCHAR(50),
	roomnumber INT,
	placenumber INT,
	leasenumber INT,
	duedate VARCHAR(10),
	paiddate VARCHAR(10),
	paymentdue INT,
	paymenttype VARCHAR(10),
	location VARCHAR(40),
	department VARCHAR(50),
	position VARCHAR(50),
	dob VARCHAR(10),
	PRIMARY KEY (invoicenumber)
); 

CREATE TABLE lineitems(
	invoicenumber INT NOT NULL,
	fee INT NOT NULL,
	itemtype VARCHAR(40),
	FOREIGN KEY (invoicenumber) REFERENCES invoices(invoicenumber)
); 

SET foreign_key_checks = 1;
