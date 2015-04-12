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
	leasenumber INT,
	parkingnumber INT,
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
	leasenumber INT(10) PRIMARY KEY,
	hallLocation INT(10),
	aptLocation INT(10),
	snumber INT NOT NULL,
	paymentperiod VARCHAR(16),
	rentalperiod VARCHAR(10),
	startdate DATE NOT NULL,
	ended INT NOT NULL DEFAULT '0',
	active INT NOT NULL DEFAULT '0',
	pending INT NOT NULL DEFAULT '1',
	FOREIGN KEY (snumber) REFERENCES student(snumber),
	FOREIGN KEY (hallLocation) REFERENCES hallrooms(hallLocation),
	FOREIGN KEY (aptLocation) REFERENCES aptrooms(aptLocation)
);

CREATE TABLE parking(
	parkingnumber INT(10) unsigned auto_increment primary key,
	lotsavailable INT(10),
	snumber INT NOT NULL,
	FOREIGN KEY (snumber) REFERENCES student(snumber)
);

CREATE TABLE hallrooms(
	hallLocation INT PRIMARY KEY,
	housingDetailsLocation INT(10) NOT NULL,
	roomnum INT(10) NOT NULL,
	snumber INT,
	FOREIGN KEY (snumber) REFERENCES student(snumber),
	FOREIGN KEY (housingDetailsLocation) REFERENCES housingdetails(housingDetailsLocation)
);

CREATE TABLE housingdetails(
	housingDetailsLocation INT(10) NOT NULL PRIMARY KEY,
	name VARCHAR(64) NOT NULL,
	address VARCHAR(100) NOT NULL,
	city VARCHAR(15) NOT NULL, 
	state VARCHAR(2) NOT NULL,
	zip VARCHAR(10) NOT NULL,
	supervisor INT NOT NULL,
	requiredYear INT NOT NULL,
	phone VARCHAR(12) NOT NULL,
	FOREIGN KEY (supervisor) REFERENCES staff(staffnumber)
);

CREATE TABLE appartmentrooms(
	aptLocation INT(10) NOT NULL PRIMARY KEY,
	aptnum INT NOT NULL,
	roomnum INT NOT NULL,
	snumber INT,
	FOREIGN KEY (snumber) REFERENCES student(snumber),
	FOREIGN KEY (aptnum) REFERENCES appartments(aptnum)
);

CREATE TABLE appartments(
	rent REAL NOT NULL,
	deposit REAL NOT NULL,
	apttype VARCHAR(64) NOT NULL,
	housingDetailsLocation INT NOT NULL,
	aptnum INT NOT NULL PRIMARY KEY,
	family INT NOT NULL,
	FOREIGN KEY (housingDetailsLocation) REFERENCES housingdetails(housingDetailsLocation)
);

CREATE TABLE parkingclasscosts(
	classification VARCHAR(32) NOT NULL,
	cost REAL NOT NULL
);

CREATE TABLE parkinglotsnear(
	lotnumber INT(10) NOT NULL,
	near INT(10) NOT NULL,
	FOREIGN KEY (near) REFERENCES housingdetails(housingDetailsLocation)
);

CREATE TABLE parkingspots(
	spotnumber INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	lotnumber INT(10),
	classification VARCHAR(30),
	snumber INT(11), 
	FOREIGN KEY (snumber) REFERENCES student(snumber)
);

CREATE TABLE studenthallinspection(
	inspectionID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	staffnumber INT NOT NULL, 
	leasenumber INT NOT NULL,
	inspectiondate VARCHAR(10),
	propertycondition VARCHAR(20),
	comments VARCHAR(50),
	FOREIGN KEY (staffnumber) REFERENCES staff(staffnumber),
	FOREIGN KEY (leasenumber) REFERENCES lease(leasenumber)
);

CREATE TABLE staff(
	staffnumber INT NOT NULL,
	firstname VARCHAR(40) NOT NULL,
	lastname VARCHAR(40) NOT NULL,
	department VARCHAR(50) NOT NULL,
	position VARCHAR(50) NOT NULL,
	dob VARCHAR(10) NOT NULL,
	address varchar(30) NOT NULL,
	city varchar(15) NOT NULL,
	state varchar(2) NOT NULL,
	zip varchar(10) NOT NULL,
	country VARCHAR(16) NOT NULL,
	sex varchar(1) NOT NULL,
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
	fee REAL NOT NULL,
	itemtype VARCHAR(40),
	FOREIGN KEY (invoicenumber) REFERENCES invoices(invoicenumber)
);

CREATE TABLE maintnencetickets(
	ticketnumber INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
	issue VARCHAR(100) NOT NULL,
	createdon VARCHAR(10) NOT NULL,
	status VARCHAR(32) NOT NULL,
	createdby INT NOT NULL,
	comments VARCHAR(256) NOT NULL,
	FOREIGN KEY (createdby) REFERENCES lease(leasenumber)
);

SET foreign_key_checks = 1;
