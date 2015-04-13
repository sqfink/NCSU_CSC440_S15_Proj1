SET foreign_key_checks = 0;

CREATE TABLE users(
	id INT NOT NULL UNIQUE,
	password VARCHAR(64) NOT NULL,
	PRIMARY KEY (id)
); 

CREATE TABLE student(
	snumber INT NOT NULL UNIQUE,
	firstname VARCHAR(40) NOT NULL,
	lastname VARCHAR(40) NOT NULL,
	leasenumber INT,
	parkingnumber INT,
	dob DATE,
	phone VARCHAR(12) NOT NULL,
	alternatephone VARCHAR(10),
	nationality VARCHAR(20) NOT NULL,
	address varchar(30) NOT NULL,
	city varchar(15) NOT NULL,
	state varchar(2),
	country varchar(32) NOT NULL,
	zip varchar(10) NOT NULL,
	year INT(4) NOT NULL,
	specialneeds varchar(50),
	comments varchar(150),
	sex varchar(1) NOT NULL,
	smoker varchar(1) NOT NULL,
	guest INT(1) NOT NULL,
	course INT NOT NULL,
	PRIMARY KEY (snumber),
	FOREIGN KEY (snumber) REFERENCES users(id),
	FOREIGN KEY (course) REFERENCES courses(cnumber)
); 

CREATE TABLE family(
	snumber INT NOT NULL PRIMARY KEY,
	name VARCHAR(80) UNIQUE NOT NULL,
	dob DATE NOT NULL,
	FOREIGN KEY (snumber) REFERENCES student(snumber)
);

CREATE TABLE nextofkin(
	snumber INT NOT NULL PRIMARY KEY UNIQUE,
	firstname VARCHAR(40) NOT NULL,
	lastname VARCHAR(40) NOT NULL,
	relationship VARCHAR(32) NOT NULL,
	address varchar(30)NOT NULL,
	city varchar(15) NOT NULL,
	state varchar(2),
	country varchar(16) NOT NULL, 
	zip varchar(10) NOT NULL,
	phone varchar(12) NOT NULL,
	FOREIGN KEY (snumber) REFERENCES student(snumber)
); 

CREATE TABLE courses(
	cnumber INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(128) NOT NULL UNIQUE	
); 

CREATE TABLE lease(
	leasenumber INT(10) PRIMARY KEY UNIQUE AUTO_INCREMENT,
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
	FOREIGN KEY (aptLocation) REFERENCES aptrooms(aptLocation),
	CONSTRAINT ensureOneLocation CHECK (NOT ((aptLocation IS NOT NULL) AND (hallLocation IS NOT NULL)))
);

CREATE TABLE hallrooms(
	hallLocation INT PRIMARY KEY NOT NULL,
	housingDetailsLocation INT(10) NOT NULL,
	roomnum INT(10) NOT NULL,
	snumber INT,
	restricted INT(1),
	FOREIGN KEY (snumber) REFERENCES student(snumber),
	FOREIGN KEY (housingDetailsLocation) REFERENCES housingdetails(housingDetailsLocation)
);

CREATE TABLE housingdetails(
	housingDetailsLocation INT(10) NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
	name VARCHAR(64) NOT NULL UNIQUE,
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
	private INT(1) NOT NULL,
	baths INT(4) NOT NULL,
	FOREIGN KEY (housingDetailsLocation) REFERENCES housingdetails(housingDetailsLocation)
);

CREATE TABLE parkingclasscosts(
	classification VARCHAR(32) NOT NULL UNIQUE PRIMARY KEY,
	cost REAL NOT NULL
);

CREATE TABLE parkinglots(
	lotnumber INT(10) NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE parkinglotsnear(
	lotnumber INT(10) NOT NULL,
	near INT(10) NOT NULL,
	FOREIGN KEY (lotnumber) REFERENCES parkinglots(lotnumber),
	FOREIGN KEY (near) REFERENCES housingdetails(housingDetailsLocation)
);

CREATE TABLE parkingspots(
	spotnumber INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	lotnumber INT(10) NOT NULL,
	classification VARCHAR(32) NOT NULL,
	snumber INT(11) UNIQUE, 
	FOREIGN KEY (classification) REFERENCES parkingclasscosts(classification),
	FOREIGN KEY (lotnumber) REFERENCES parkinglots(lotnumber),
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
	staffnumber INT NOT NULL PRIMARY KEY,
	firstname VARCHAR(40) NOT NULL,
	lastname VARCHAR(40) NOT NULL,
	department VARCHAR(50) NOT NULL,
	position VARCHAR(50) NOT NULL,
	dob DATE NOT NULL,
	address varchar(30) NOT NULL,
	city varchar(15) NOT NULL,
	state varchar(2) NOT NULL,
	zip varchar(10) NOT NULL,
	country VARCHAR(16) NOT NULL,
	sex varchar(1) NOT NULL,
	FOREIGN KEY (staffnumber) REFERENCES users(id)
); 

CREATE TABLE invoices(
	invoicenumber INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	snumber INT NOT NULL,
	staffnumber INT NOT NULL,
	residencename VARCHAR(50),
	roomnumber INT,
	placenumber INT,
	leasenumber INT,
	duedate VARCHAR(10),
	paiddate VARCHAR(10),
	paymentdue INT,
	paymenttype VARCHAR(10),
	dob DATE NOT NULL,
	FOREIGN KEY (snumber) REFERENCES student(snumber),
	FOREIGN KEY (staffnumber) REFERENCES staff(staffnumber)
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

CREATE TABLE parkingrequests(
	reqnumber INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	snumber INT(10) NOT NULL,
	farok INT(1) NOT NULL,
	classification VARCHAR(32) NOT NULL,
	approved INT(1) NOT NULL,
	pending INT(1) NOT NULL,
	FOREIGN KEY (classification) REFERENCES parkingclasscosts(classification),
	FOREIGN KEY (snumber) REFERENCES student(snumber)
);

SET foreign_key_checks = 1;
