CREATE TABLE users(
	id INT NOT NULL,
	password VARCHAR(200),
	PRIMARY KEY (id)
); 

CREATE TABLE student(
	snumber INT NOT NULL,
	name VARCHAR(40),
	rentalstatus VARCHAR(10),
	parkingnumber INT NOT NULL,
	dob VARCHAR(10),
	phone VARCHAR(12),
	alternatephone VARCHAR(12),
	nationality VARCHAR(20),
	address varchar(30),
	city varchar(15),
	state varchar(2),
	zip varchar(10),
	year varchar(4),
	specialneeds varchar(50),
	comments varchar(150),
	sex varchar(1),
	smoker varchar(1),
	PRIMARY KEY (snumber)
); 

CREATE TABLE family(
	snumber INT NOT NULL,
	name VARCHAR(40),
	dob VARCHAR(10),
	FOREIGN KEY (snumber) REFERENCES student(snumber)
); 

CREATE TABLE guest(
	snumber INT NOT NULL,
	approvalvalid VARCHAR(1),
	FOREIGN KEY (snumber) REFERENCES student(snumber)
); 

CREATE TABLE nextofkin(
	snumber INT NOT NULL,
	name VARCHAR(40),
	rentalstatus VARCHAR(10),
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
	placenumber INT(10) unsigned auto_increment primary key,
	leasenumber INT(10) unsigned auto_increment primary key,
	snumber INT NOT NULL,
	sname VARCHAR(40),
	roomnumber INT NOT NULL,
	paymentduration INT,
	earlyterminationfee INT,
	securitydeposits INT,
	rentalperiod VARCHAR(10)
);

CREATE TABLE studentflat(
	appnumber INT(10) unsigned auto_increment primary key,
	placenumber INT(10),
	bathrooms INT,
	flattype VARCHAR(20),
	private VARCHAR(1),
	bedrooms INT,
	rate INT,
	roomnumber INT,
	FOREIGN KEY (placenumber) REFERENCES lease(placenumber)
);

CREATE TABLE parking(
	parkingnumber INT(10) unsigned auto_increment primary key,
	lotsavailable INT(10),
	snumber INT NOT NULL,
	FOREIGN KEY (snumber) REFERENCES student(snumber)
);

/**
 * TODO need to determine relationship
 */
CREATE TABLE parkingspots(
	spotnumber INT(10) unsigned auto_increment primary key,
	lotnumber INT(10) unsigned auto_increment primary key,
	classification VARCHAR(30),
);

/**
 * TODO need to determine relationship
 */
CREATE TABLE parkingclassification(
	rate INT,
	classificationtype VARCHAR(15)
);

CREATE TABLE studenthallinspection(
	staffname VARCHAR(30) NOT NULL,
	residencename VARCHAR(30) NOT NULL,
	inspectiondate VARCHAR(10),
	propertycondition VARCHAR(20),
	comments VARCHAR(50),
	FOREIGN KEY (placenumber) REFERENCES lease(placenumber)
);

CREATE TABLE staff(
	staffnumber INT NOT NULL,
	staffname VARCHAR(40),
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
	studentname VARCHAR(40),
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
