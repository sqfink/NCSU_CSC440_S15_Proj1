INSERT INTO `csc440`.`student` (`snumber`, `name`, `rentalstatus`, `parkingnumber`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `zip`, `year`, `specialneeds`, `comments`, `sex`, `smoker`, `guest`) VALUES ('0', 'Test STUDENT', 'UNKNOWN', '-1', '1994-02-09', '555-555-5555', '000-000-0000', 'Murica', '1234 Fake Street', 'Springfield', 'NC', '12345', '1', 'N/A', 'None', 'M', 'N', '0');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('0', 'f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b');

INSERT INTO `csc440`.`student` (`snumber`, `name`, `rentalstatus`, `parkingnumber`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `zip`, `year`, `specialneeds`, `comments`, `sex`, `smoker`, `guest`) VALUES ('1', 'Test GUEST', 'UNKNOWN', '-1', '1971-07-20', '555-555-6666', '123-456-7890', 'Canada', '1234 10th Street', 'Vancouver', 'BC', 'V6H 1E7', '1', 'N/A', 'None', 'F', 'N', '1');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('1', '65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5');

INSERT INTO `csc440`.`staff` (`staffnumber`, `staffname`, `location`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `sex`) VALUES ('2', 'Test STAFF', 'The Moon', 'badassery', 'CEO', '1234-01-01', '9876 Some Street', 'Boston', 'MA', '10296', 'T');
INSERT INTO `csc440`.`users` (`id`, `password`) VALUES ('2', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
