INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('0', 'f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b');
INSERT INTO `csc440`.`student` (`snumber`, `firstname`, `lastname`, `rentalstatus`, `parkingnumber`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `zip`, `year`, `specialneeds`, `comments`, `sex`, `smoker`, `guest`) VALUES ('0', 'Test', 'STUDENT', 'UNKNOWN', '-1', '1994-02-09', '555-555-5555', '000-000-0000', 'Murica', '1234 Fake Street', 'Springfield', 'NC', '12345', '1', 'N/A', 'None', 'M', 'N', '0');

INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('1', '65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5');
INSERT INTO `csc440`.`student` (`snumber`, `firstname`, `lastname`, `rentalstatus`, `parkingnumber`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `zip`, `country`, `year`, `specialneeds`, `comments`, `sex`, `smoker`, `guest`) VALUES ('1', 'Test', 'GUEST', 'UNKNOWN', '-1', '1971-07-20', '555-555-6666', '123-456-7890', 'Canada', '1234 10th Street', 'Vancouver', 'BC', 'V6H 1E7', 'Canada', '1', 'N/A', 'None', 'F', 'N', '1');

INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('100540001', 'f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b');
INSERT INTO `csc440`.`student` (`snumber`, `firstname`, `lastname`, `rentalstatus`, `parkingnumber`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `zip`, `country`, `year`, `specialneeds`, `comments`, `sex`, `smoker`, `guest`) VALUES ('100540001', 'Harry', 'Potter', 'Placed', '003', '1991-07-21', '9189327078', '9176326078', 'British', '31 B, Privet Drive', 'London', '', 'W12 7TS', 'England', '1', 'None', NULL, 'M', 'N', '0');

INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('2', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('3', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('4', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('5', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('6', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('7', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `csc440`.`staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('2', 'Minerva', 'McGonagall', 'UNKNOWN', 'Hall Manager/Supervisor', '1950-08-04', 'McGonagall Road', 'Delhi', '', '011', 'India', 'F');
INSERT INTO `csc440`.`staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('3', 'Severus', 'Snape', 'UNKNOWN', 'Hall Manager/Supervisor', '1953-10-07', 'Snape Road', 'Lahore', '', '007', 'Pakistan', 'M');
INSERT INTO `csc440`.`staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('4', 'Filius', 'Flitwick', 'UNKNOWN', 'Hall Manager/Supervisor', '1960-08-06', 'Flitwick Road', 'Sydney', '', '050', 'Australia', 'M');
INSERT INTO `csc440`.`staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('5', 'Ponoma', 'Sprout', 'UNKNOWN', 'Hall Manager/Supervisor', '1965-08-16', 'Sprout Road', 'Berlin', '', '05963', 'Germany', 'F');
INSERT INTO `csc440`.`staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('6', 'Lebron', 'James', 'UNKNOWN', 'Hall Manager/Supervisor', '1981-01-01', '1702 Beach Road', 'Miami', 'FL', '33101', 'USA', 'M');
INSERT INTO `csc440`.`staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('7', 'Albus', 'Dumbledore', 'UNKNOWN', 'Hall Manager/Supervisor', '1945-04-23', 'Dumbledore Road', 'Gandhinagar', '', '382007', 'India', 'M');

INSERT INTO `csc440`.`housing` (`housingLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('1', 'Falcon House', '2746 Cates Avenue', 'Raleigh', 'NC', '27607', '6', '0', '919-777-6541');
INSERT INTO `csc440`.`housing` (`housingLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('2', 'Gryffindor Hall', '2751 Cates Avenue, Gryffindor Residence Hall', 'Raleigh', 'NC', '27607', '2', '0', '919-540-0001');
INSERT INTO `csc440`.`housing` (`housingLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('3', 'Slytherin Hall', '210 Dan Allen Drive', 'Raleigh', 'NC', '27695', '3', '5', '919-540-0002');
INSERT INTO `csc440`.`housing` (`housingLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('4', 'Ravenclaw', '315 Gorman Crossings', 'Raleigh', 'NC', '27606', '4', '0', '919-540-0003');
INSERT INTO `csc440`.`housing` (`housingLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('5', 'Hufflepuff', '515 University Commons', 'Raleigh', 'NC', '27606', '5', '0', '919-540-0004');
INSERT INTO `csc440`.`housing` (`housingLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('6', 'Hogwarts', '300 Wade Avenue', 'Raleigh', 'NC', '27606', '7', '0', '919-540-0005');

INSERT INTO `csc440`.`parkinglotsnear` (`lotnumber`, `near`) VALUES ('1', '1');
INSERT INTO `csc440`.`parkinglotsnear` (`lotnumber`, `near`) VALUES ('1', '2');
INSERT INTO `csc440`.`parkinglotsnear` (`lotnumber`, `near`) VALUES ('2', '3');
INSERT INTO `csc440`.`parkinglotsnear` (`lotnumber`, `near`) VALUES ('3', '4');
INSERT INTO `csc440`.`parkinglotsnear` (`lotnumber`, `near`) VALUES ('4', '4');
INSERT INTO `csc440`.`parkinglotsnear` (`lotnumber`, `near`) VALUES ('5', '5');
INSERT INTO `csc440`.`parkinglotsnear` (`lotnumber`, `near`) VALUES ('6', '6');



INSERT INTO `csc440`.`parkingclasscosts` (`classification`, `cost`) VALUES ('Handicapped', '25');
INSERT INTO `csc440`.`parkingclasscosts` (`classification`, `cost`) VALUES ('Bike', '30');
INSERT INTO `csc440`.`parkingclasscosts` (`classification`, `cost`) VALUES ('Small Car', '35');
INSERT INTO `csc440`.`parkingclasscosts` (`classification`, `cost`) VALUES ('Large Car', '40');

INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('1', '1', 'Handicapped');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('1', '2', 'Bike');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('1', '3', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('1', '4', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '5', 'Handicapped');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '6', 'Bike');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '7', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '8', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '9', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '10', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '11', 'Handicapped');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '12', 'Bike');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '13', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '14', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '15', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '16', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('4', '17', 'Handicapped');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('4', '18', 'Bike');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('4', '19', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('4', '20', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '21', 'Handicapped');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '22', 'Handicapped');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '23', 'Bike');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '24', 'Bike');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '25', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '26', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '27', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '28', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '29', 'Handicapped');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '30', 'Handicapped');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '31', 'Bike');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '32', 'Bike');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '33', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '34', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '35', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '36', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '37', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '38', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '39', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '40', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '41', 'Handicapped');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '42', 'Handicapped');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '43', 'Bike');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '44', 'Bike');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '45', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '46', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '47', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '48', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '49', 'Small Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '50', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '51', 'Large Car');
INSERT INTO `csc440`.`parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '52', 'Large Car');