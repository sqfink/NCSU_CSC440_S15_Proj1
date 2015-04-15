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
	snumber INT NOT NULL,
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

CREATE TABLE semesters(
	semesterid INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	start DATE NOT NULL,
	end DATE NOT NULL,
	name VARCHAR(32) NOT NULL
);

CREATE TABLE newleasereq(
	reqid INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	snumber INT NOT NULL,
	reqloc1 INT NOT NULL,
	reqloc2 INT,
	reqloc3 INT,
	status VARCHAR(16) NOT NULL DEFAULT "PENDING",
	staffnumber INT, 
	changedon TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	leasenumber INT,
	startdate DATE NOT NULL,
	enddate DATE NOT NULL,
	paymentperiod VARCHAR(16) NOT NULL,
	CONSTRAINT ensureValidSpan CHECK (enddate > startdate),
	FOREIGN KEY (leasenumber) REFERENCES lease(leasenumber),
	FOREIGN KEY (reqloc1) REFERENCES housingdetails(housingDetailsLocation),
	FOREIGN KEY (reqloc2) REFERENCES housingdetails(housingDetailsLocation),
	FOREIGN KEY (reqloc3) REFERENCES housingdetails(housingDetailsLocation),
	FOREIGN KEY (snumber) REFERENCES student(snumber),
	FOREIGN KEY (staffnumber) REFERENCES staff(staffnumber)
);

CREATE TABLE lease(
	leasenumber INT(10) PRIMARY KEY UNIQUE AUTO_INCREMENT,
	snumber INT NOT NULL,
	hallLocation INT(10),
	aptLocation INT(10),
	paymentperiod VARCHAR(16),
	startdate DATE NOT NULL,
	enddate DATE NOT NULL,
	active INT NOT NULL DEFAULT '0',
	terminationfee INT(100) NOT NULL DEFAULT '50',
	FOREIGN KEY (snumber) REFERENCES student(snumber),
	FOREIGN KEY (hallLocation) REFERENCES hallrooms(hallLocation),
	FOREIGN KEY (aptLocation) REFERENCES appartmentrooms(aptLocation),
	CONSTRAINT ensureValidSpan CHECK (enddate > startdate),
	CONSTRAINT ensureOneLocation CHECK (NOT ((aptLocation IS NOT NULL) AND (hallLocation IS NOT NULL)))
);

CREATE TABLE leaseterminaterequest(
	requestid INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
	leasenumber INT(10) NOT NULL, 
	status VARCHAR(16) NOT NULL DEFAULT "PENDING",
	reason VARCHAR(1024) NOT NULL,
	enddate DATE NOT NULL,
	staffnumber INT, 
	changedon TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (staffnumber) REFERENCES staff(staffnumber),
	FOREIGN KEY (leasenumber) REFERENCES lease(leasenumber)
);

CREATE TABLE hallrooms(
	hallLocation INT PRIMARY KEY NOT NULL,
	housingDetailsLocation INT(10) NOT NULL,
	roomnum INT(10) NOT NULL,
	snumber INT,
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
	aptnum INT NOT NULL PRIMARY KEY,
	rent REAL NOT NULL,
	deposit REAL NOT NULL,
	apttype VARCHAR(64) NOT NULL,
	housingDetailsLocation INT NOT NULL,
	family INT NOT NULL,
	private INT(1) NOT NULL DEFAULT '0',
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
	inspectiondate DATE NOT NULL,
	propertycondition VARCHAR(20),
	comments VARCHAR(512),
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
	leasenumber INT NOT NULL,
	duedate DATE NOT NULL,
	paiddate DATE,
	paymentdue INT(1) NOT NULL,
	paymenttype VARCHAR(10),
	FOREIGN KEY (leasenumber) REFERENCES lease(leasenumber),
	FOREIGN KEY (snumber) REFERENCES student(snumber),
	FOREIGN KEY (staffnumber) REFERENCES staff(staffnumber)
); 

CREATE TABLE lineitems(
	invoicenumber INT NOT NULL,
	fee REAL NOT NULL,
	itemtype VARCHAR(128),
	FOREIGN KEY (invoicenumber) REFERENCES invoices(invoicenumber)
);

CREATE TABLE maintnencetickets(
	ticketnumber INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
	issue VARCHAR(100) NOT NULL,
	createdon DATE NOT NULL,
	status VARCHAR(32) NOT NULL,
	createdby INT NOT NULL,
	comments VARCHAR(512) NOT NULL,
	changedon TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	changedby INT,
	FOREIGN KEY (changedby) REFERENCES staff(staffnumber),
	FOREIGN KEY (createdby) REFERENCES student(snumber)
);

CREATE TABLE parkingrequests(
	reqnumber INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	lreqid INT NOT NULL,
	snumber INT(10) NOT NULL,
	farok INT(1) NOT NULL,
	classification VARCHAR(32) NOT NULL,
	approved INT(1) NOT NULL,
	pending INT(1) NOT NULL,
	changedon TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (lreqid) REFERENCES newleasereq(reqid),
	FOREIGN KEY (classification) REFERENCES parkingclasscosts(classification),
	FOREIGN KEY (snumber) REFERENCES student(snumber)
);

SET foreign_key_checks = 1;
