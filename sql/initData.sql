INSERT INTO `csc440`.`student` (`snumber`, `firstname`, `lastname`, `rentalstatus`, `parkingnumber`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `zip`, `year`, `specialneeds`, `comments`, `sex`, `smoker`, `guest`) VALUES ('0', 'Test', 'STUDENT', 'UNKNOWN', '-1', '1994-02-09', '555-555-5555', '000-000-0000', 'Murica', '1234 Fake Street', 'Springfield', 'NC', '12345', '1', 'N/A', 'None', 'M', 'N', '0');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('0', 'f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b');

INSERT INTO `csc440`.`student` (`snumber`, `firstname`, `lastname`, `rentalstatus`, `parkingnumber`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `zip`, `year`, `specialneeds`, `comments`, `sex`, `smoker`, `guest`) VALUES ('1', 'Test', 'GUEST', 'UNKNOWN', '-1', '1971-07-20', '555-555-6666', '123-456-7890', 'Canada', '1234 10th Street', 'Vancouver', 'BC', 'V6H 1E7', '1', 'N/A', 'None', 'F', 'N', '1');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('1', '65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5');

INSERT INTO `csc440`.`staff` (`staffnumber`, `firstname`, `lastname`, `location`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `sex`) VALUES ('2', 'Test', 'STAFF', 'The Moon', 'badassery', 'CEO', '1234-01-01', '9876 Some Street', 'Boston', 'MA', '10296', 'T');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('2', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');

INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('100540001', 'f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b');
INSERT INTO `csc440`.`student` (`snumber`, `firstname`, `lastname`, `rentalstatus`, `parkingnumber`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `zip`, `year`, `specialneeds`, `comments`, `sex`, `smoker`, `guest`) VALUES ('100540001', 'Harry', 'Potter', 'Placed', '003', '1991-07-21', '9189327078', '9176326078', 'British', '31 B, Privet Drive', 'London', 'NA', '27605', '1', 'None', NULL, 'M', 'N', '0');

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