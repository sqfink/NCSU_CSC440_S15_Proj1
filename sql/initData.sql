INSERT INTO `semesters` (`semesterid`, `start`, `end`, `name`) VALUES ('1', '0000-08-01', '0000-12-31', 'Fall Semester');
INSERT INTO `semesters` (`semesterid`, `start`, `end`, `name`) VALUES ('2', '0000-01-01', '0000-05-31', 'Spring Semester');
INSERT INTO `semesters` (`semesterid`, `start`, `end`, `name`) VALUES ('3', '0000-06-01', '0000-07-31', 'Summer Semester');

INSERT INTO `courses` (`cnumber`, `title`) VALUES ('1', 'Defence Against Dark Arts');
INSERT INTO `courses` (`cnumber`, `title`) VALUES ('2', 'Muggle Studies');
INSERT INTO `courses` (`cnumber`, `title`) VALUES ('3', 'Care of Magical Creatures');
INSERT INTO `courses` (`cnumber`, `title`) VALUES ('4', 'Potions');
INSERT INTO `courses` (`cnumber`, `title`) VALUES ('5', 'Coaching Triwizard Cup');
INSERT INTO `courses` (`cnumber`, `title`) VALUES ('6', 'Guest Lecturer Triwizard Cup');
INSERT INTO `courses` (`cnumber`, `title`) VALUES ('7', 'Artificial Iintelligence');

INSERT INTO `users` (`id`, `password`) VALUES ('100540001', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('100540002', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('100540003', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('100540004', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('100540005', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('100540006', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('100540007', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('100540008', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('100540009', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');

INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `zip`, `country`, `year`, `sex`, `smoker`, `guest`, `course`) VALUES ('100540001', 'Harry', 'Potter', '1991-07-21', '9189327078', '9176326078', 'British', '31 B, Privet Drive', 'London', '', '27605', 'England', '1', 'M', 'N', '0', '1');
INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `nationality`, `address`, `city`, `state`, `country`, `zip`, `year`, `specialneeds`, `sex`, `smoker`, `guest`, `course`) VALUES ('100540002', 'Draco', 'Malfoy', '1990-06-05', '9183270672', 'American', '31 B, Malfoy Drive', 'New York', 'NY', 'USA', '27506', '0', NULL, 'M', 'Y', '0', '2');
INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `nationality`, `address`, `city`, `country`, `zip`, `year`, `specialneeds`, `sex`, `smoker`, `guest`, `course`) VALUES ('100540003', 'Ron', 'Weasley', '1986-03-01', '9189567067', 'Italian', '31 B, Weasley Road', 'Rome', 'Italy', '27456', '5', NULL, 'M', 'N', '0', '3');
INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `nationality`, `address`, `city`, `country`, `zip`, `year`, `sex`, `smoker`, `guest`, `course`) VALUES ('100540004', 'Hermione', 'Granger', '1986-11-19', '9185685674', 'Scottish', '32 A, Granger Road', 'Edinburg', 'Scotland', '25556', '5', 'F', 'N', '0', '2');
INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `country`, `zip`, `year`, `sex`, `smoker`, `guest`, `course`) VALUES ('100540005', 'Fred', 'Weasley', '1982-10-20', '9133368567', '9133368511', 'Italian', '31 B, Weasley Road', 'Rome', 'Italy', '27456', '4', 'M', 'N', '0', '2');
INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `nationality`, `address`, `city`, `country`, `zip`, `year`, `sex`, `smoker`, `guest`, `course`) VALUES ('100540006', 'George', 'Weasley', '1982-10-20', '9133368568', 'Italian', '31 B, Weasley Road', 'Rome', 'Italy', '27456', '4', 'M', 'N', '0', '2');
INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `nationality`, `address`, `city`, `country`, `zip`, `year`, `specialneeds`, `sex`, `smoker`, `guest`, `course`) VALUES ('100540007', 'Bill', 'Weasley', '1982-11-29', '9198568567', 'Belgian', '32 A, William Road', 'Brussels', 'Belgium', '2535', '5', 'Difficulty in walking', 'M', 'N', '0', '4');
INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `country`, `zip`, `year`, `sex`, `smoker`, `guest`, `course`) VALUES ('100540008', 'Vernon', 'Dursley', '1975-11-29', '9198954357', '9198954786', 'American', '32 A, Dursley Road', 'Raleigh', 'NC', 'USA', '27606', '5', 'M', 'Y', '0', '2');
INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `state`, `country`, `zip`, `year`, `sex`, `smoker`, `guest`, `course`) VALUES ('100540009', 'Jim', 'Green', '1975-11-22', '9198944352', '9198955765', 'American', '11 A, Dursley Road', 'Raleigh', 'NC', 'USA', '27606', '5', 'M', 'Y', '0', '7');

INSERT INTO `users` (`id`, `password`) VALUES ('200540001', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('200540002', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');

INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `alternatephone`, `nationality`, `address`, `city`, `country`, `zip`, `year`, `sex`, `smoker`, `guest`, `course`) VALUES ('200540001', 'Viktor', 'Krum', '1982-11-29', '9198333567', '9198332233', 'Bulgarian', '32 A, Krum Road', 'Sofia', 'Bulgaria', '2221', '99', 'M', 'Y', '1', '5');
INSERT INTO `student` (`snumber`, `firstname`, `lastname`, `dob`, `phone`, `nationality`, `address`, `city`, `country`, `zip`, `year`, `sex`, `smoker`, `guest`, `course`) VALUES ('200540002', 'Olympe', 'Maxime', '1970-05-19', '9197773567', 'French', '32 A, Maxime Road', 'Paris', 'France', '2331', '99', 'F', 'Y', '1', '6');

INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `country`, `zip`, `phone`) VALUES ('100540001', 'Sirius', 'Black', 'Godfather', '12 Grimmauld Place', 'London', 'England', '27605', '9439560752');
INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `state`, `country`, `zip`, `phone`) VALUES ('100540002', 'Lucius', 'Malfoy', 'Father', '31 B, Malfoy Drive', 'New York', 'NY', 'USA', '27506', '9439560752');
INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `country`, `zip`, `phone`) VALUES ('100540003', 'Aurthur', 'Weasly', 'Father', '31 B, Weasley Road', 'Rome', 'Italy', '27456', '9436660752');
INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `country`, `zip`, `phone`) VALUES ('100540004', 'Mr.', 'Granger', 'Father', '32 A, Granger Road', 'Edinburg', 'Scotland', '25556', '9433360752');
INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `country`, `zip`, `phone`) VALUES ('100540005', 'Aurthur', 'Weasly', 'Father', '31 B, Weasley Road', 'Rome', 'Italy', '27456', '9436660752');
INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `country`, `zip`, `phone`) VALUES ('100540006', 'Aurthur', 'Weasly', 'Father', '31 B, Weasley Road', 'Rome', 'Italy', '27456', '9436660752');
INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `country`, `zip`, `phone`) VALUES ('100540007', 'Aurthur', 'Weasly', 'Father', '31 B, Weasley Road', 'Rome', 'Italy', '27456', '9436660752');
INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `country`, `zip`, `phone`) VALUES ('200540001', 'Igor', 'Karkaroff', 'Headmaster', '32 A, Krum Road', 'Sofia', 'Bulgaria', '2221', '94363530752');
INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `country`, `zip`, `phone`) VALUES ('200540002', 'Bathilda', 'Bagshot', 'Friend', '32 A, Bagshot Road', 'Zurich', 'Switzerland', '35221', '94363595752');
INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `state`, `country`, `zip`, `phone`) VALUES ('100540008', 'Petunia', 'Dursley', 'Wife', '32 A, Dursley Road', 'Raleigh', 'NC', 'USA', '27606', '94363654752');
INSERT INTO `nextofkin` (`snumber`, `firstname`, `lastname`, `relationship`, `address`, `city`, `state`, `country`, `zip`, `phone`) VALUES ('100540009', 'Michael', 'Green', 'Father', '11 A, Dursley Road', 'Raleigh', 'NC', 'USA', '27606', '9197823321');

INSERT INTO `family` (`snumber`, `name`, `dob`) VALUES ('100540007', 'Fleur Delacour', '1984-03-31');
INSERT INTO `family` (`snumber`, `name`, `dob`) VALUES ('100540008', 'Petunia Dursley', '1978-12-13');
INSERT INTO `family` (`snumber`, `name`, `dob`) VALUES ('100540008', 'Dudley Dursley', '2000-06-26');

INSERT INTO `users` (`id`, `password`) VALUES ('2', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('3', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('4', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('5', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('6', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');
INSERT INTO `users` (`id`, `password`) VALUES ('7', 'ac67aa3ae9bb7df054d795f0e0b8054ace35477dc48c1098e92d5a1347ba5560');

INSERT INTO `staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('2', 'Minerva', 'McGonagall', 'UNKNOWN', 'Hall Manager/Supervisor', '1950-08-04', 'McGonagall Road', 'Delhi', '', '011', 'India', 'F');
INSERT INTO `staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('3', 'Severus', 'Snape', 'UNKNOWN', 'Hall Manager/Supervisor', '1953-10-07', 'Snape Road', 'Lahore', '', '007', 'Pakistan', 'M');
INSERT INTO `staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('4', 'Filius', 'Flitwick', 'UNKNOWN', 'Hall Manager/Supervisor', '1960-08-06', 'Flitwick Road', 'Sydney', '', '050', 'Australia', 'M');
INSERT INTO `staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('5', 'Ponoma', 'Sprout', 'UNKNOWN', 'Hall Manager/Supervisor', '1965-08-16', 'Sprout Road', 'Berlin', '', '05963', 'Germany', 'F');
INSERT INTO `staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('6', 'Lebron', 'James', 'UNKNOWN', 'Hall Manager/Supervisor', '1981-01-01', '1702 Beach Road', 'Miami', 'FL', '33101', 'USA', 'M');
INSERT INTO `staff` (`staffnumber`, `firstname`, `lastname`, `department`, `position`, `dob`, `address`, `city`, `state`, `zip`, `country`, `sex`) VALUES ('7', 'Albus', 'Dumbledore', 'UNKNOWN', 'Hall Manager/Supervisor', '1945-04-23', 'Dumbledore Road', 'Gandhinagar', '', '382007', 'India', 'M');

INSERT INTO `housingdetails` (`housingDetailsLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('1', 'Falcon House', '2746 Cates Avenue', 'Raleigh', 'NC', '27607', '6', '1', '9197776541');
INSERT INTO `housingdetails` (`housingDetailsLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('2', 'Gryffindor Hall', '2751 Cates Avenue, Gryffindor Residence Hall', 'Raleigh', 'NC', '27607', '2', '0', '9195400001');
INSERT INTO `housingdetails` (`housingDetailsLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('3', 'Slytherin Hall', '210 Dan Allen Drive', 'Raleigh', 'NC', '27695', '3', '5', '9195400002');
INSERT INTO `housingdetails` (`housingDetailsLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('4', 'Ravenclaw', '315 Gorman Crossings', 'Raleigh', 'NC', '27606', '4', '0', '9195400003');
INSERT INTO `housingdetails` (`housingDetailsLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('5', 'Hufflepuff', '515 University Commons', 'Raleigh', 'NC', '27606', '5', '0', '9195400004');
INSERT INTO `housingdetails` (`housingDetailsLocation`, `name`, `address`, `city`, `state`, `zip`, `supervisor`, `requiredYear`, `phone`) VALUES ('6', 'Hogwarts', '300 Wade Avenue', 'Raleigh', 'NC', '27606', '7', '0', '9195400005');

INSERT INTO `appartments` (`housingDetailsLocation`, `rent`, `deposit`, `apttype`, `aptnum`, `family`) VALUES ('4', '350', '400', '3 Bed, 3 Bath', '101', '0');
INSERT INTO `appartments` (`housingDetailsLocation`, `rent`, `deposit`, `apttype`, `aptnum`, `family`) VALUES ('4', '350', '400', '4 Bed, 4 Bath', '102', '0');
INSERT INTO `appartments` (`housingDetailsLocation`, `rent`, `deposit`, `apttype`, `aptnum`, `family`) VALUES ('5', '375', '450', '3 Bed, 3 Bath', '103', '0');
INSERT INTO `appartments` (`housingDetailsLocation`, `rent`, `deposit`, `apttype`, `aptnum`, `family`) VALUES ('5', '375', '450', '4 Bed, 4 Bath', '104', '0');
INSERT INTO `appartments` (`housingDetailsLocation`, `rent`, `deposit`, `apttype`, `aptnum`, `family`) VALUES ('6', '450', '500', '1 Bed', '105', '1');
INSERT INTO `appartments` (`housingDetailsLocation`, `rent`, `deposit`, `apttype`, `aptnum`, `family`) VALUES ('6', '550', '600', '2 Bed', '106', '1');
INSERT INTO `appartments` (`housingDetailsLocation`, `rent`, `deposit`, `apttype`, `aptnum`, `family`) VALUES ('6', '700', '800', '3 Bed', '107', '1');
INSERT INTO `appartments` (`housingDetailsLocation`, `rent`, `deposit`, `apttype`, `aptnum`, `family`, `private`) VALUES ('1', '400', '400', 'Shared House', '108', '1', '1');

INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('1', '101', '1');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('2', '101', '2');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('3', '101', '3');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('4', '102', '1');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('5', '102', '2');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('6', '102', '3');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('7', '102', '4');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('8', '103', '1');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('9', '103', '2');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('10', '103', '3');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('11', '104', '1');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('12', '104', '2');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('13', '104', '3');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('14', '104', '4');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('15', '105', '1');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('16', '106', '1');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('17', '107', '1');
INSERT INTO `appartmentrooms` (`aptLocation`, `aptnum`, `roomnum`) VALUES ('18', '108', '1');

INSERT INTO `hallrooms` (`hallLocation`, `housingDetailsLocation`, `roomnum`) VALUES ('1', '2', '1');
INSERT INTO `hallrooms` (`hallLocation`, `housingDetailsLocation`, `roomnum`) VALUES ('2', '2', '2');
INSERT INTO `hallrooms` (`hallLocation`, `housingDetailsLocation`, `roomnum`) VALUES ('3', '2', '3');
INSERT INTO `hallrooms` (`hallLocation`, `housingDetailsLocation`, `roomnum`) VALUES ('4', '2', '4');
INSERT INTO `hallrooms` (`hallLocation`, `housingDetailsLocation`, `roomnum`) VALUES ('5', '2', '5');
INSERT INTO `hallrooms` (`hallLocation`, `housingDetailsLocation`, `roomnum`) VALUES ('6', '3', '1');
INSERT INTO `hallrooms` (`hallLocation`, `housingDetailsLocation`, `roomnum`) VALUES ('7', '3', '2');
INSERT INTO `hallrooms` (`hallLocation`, `housingDetailsLocation`, `roomnum`) VALUES ('8', '3', '3');

INSERT INTO `maintnencetickets` (`issue`, `createdon`, `status`, `createdby`, `comments`) VALUES ('Water', '2015-04-06', 'Pending', '100540001', 'No Water');
INSERT INTO `maintnencetickets` (`issue`, `createdon`, `status`, `createdby`, `comments`) VALUES ('Internet', '2015-03-30', 'Complete', '100540003', 'Internet not working');
INSERT INTO `maintnencetickets` (`issue`, `createdon`, `status`, `createdby`, `comments`) VALUES ('Cleaning', '2015-03-15', 'Complete', '100540007', 'Cleaning');
INSERT INTO `maintnencetickets` (`issue`, `createdon`, `status`, `createdby`, `comments`) VALUES ('Miscellaneous', '2015-04-02', 'Pending', '200540002', 'Window broken');

INSERT INTO `parkinglots` (`lotnumber`) VALUES ('1');
INSERT INTO `parkinglots` (`lotnumber`) VALUES ('2');
INSERT INTO `parkinglots` (`lotnumber`) VALUES ('3');
INSERT INTO `parkinglots` (`lotnumber`) VALUES ('4');
INSERT INTO `parkinglots` (`lotnumber`) VALUES ('5');
INSERT INTO `parkinglots` (`lotnumber`) VALUES ('6');
INSERT INTO `parkinglots` (`lotnumber`) VALUES ('7');

INSERT INTO `parkinglotsnear` (`lotnumber`, `near`) VALUES ('1', '1');
INSERT INTO `parkinglotsnear` (`lotnumber`, `near`) VALUES ('1', '2');
INSERT INTO `parkinglotsnear` (`lotnumber`, `near`) VALUES ('2', '3');
INSERT INTO `parkinglotsnear` (`lotnumber`, `near`) VALUES ('3', '4');
INSERT INTO `parkinglotsnear` (`lotnumber`, `near`) VALUES ('4', '4');
INSERT INTO `parkinglotsnear` (`lotnumber`, `near`) VALUES ('5', '5');
INSERT INTO `parkinglotsnear` (`lotnumber`, `near`) VALUES ('6', '6');

INSERT INTO `parkingclasscosts` (`classification`, `cost`) VALUES ('Handicapped', '25');
INSERT INTO `parkingclasscosts` (`classification`, `cost`) VALUES ('Bike', '30');
INSERT INTO `parkingclasscosts` (`classification`, `cost`) VALUES ('Small Car', '35');
INSERT INTO `parkingclasscosts` (`classification`, `cost`) VALUES ('Large Car', '40');

INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('1', '1', 'Handicapped');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('1', '2', 'Bike');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('1', '3', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('1', '4', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '5', 'Handicapped');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '6', 'Bike');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '7', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '8', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '9', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('2', '10', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '11', 'Handicapped');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '12', 'Bike');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '13', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '14', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '15', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('3', '16', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('4', '17', 'Handicapped');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('4', '18', 'Bike');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('4', '19', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('4', '20', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '21', 'Handicapped');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '22', 'Handicapped');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '23', 'Bike');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '24', 'Bike');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '25', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '26', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '27', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('5', '28', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '29', 'Handicapped');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '30', 'Handicapped');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '31', 'Bike');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '32', 'Bike');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '33', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '34', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '35', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '36', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '37', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '38', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '39', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('6', '40', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '41', 'Handicapped');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '42', 'Handicapped');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '43', 'Bike');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '44', 'Bike');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '45', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '46', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '47', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '48', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '49', 'Small Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '50', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '51', 'Large Car');
INSERT INTO `parkingspots` (`lotnumber`, `spotnumber`, `classification`) VALUES ('7', '52', 'Large Car');

INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('100540001', '2', '2015-01-01', '2015-07-31', 'SEMESTER');
INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('100540002', '4', '2015-01-01', '2015-07-31', 'SEMESTER');
INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('100540003', '2', '2015-01-01', '2015-05-31', 'MONTH');
INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('100540004', '2', '2015-01-01', '2015-07-31', 'MONTH');
INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('100540005', '5', '2015-01-01', '2015-07-31', 'MONTH');
INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('100540006', '5', '2015-01-01', '2015-07-31', 'SEMESTER');
INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('100540007', '3', '2015-01-01', '2015-07-31', 'SEMESTER');
INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('200540001', '4', '2015-03-01', '2015-04-30', 'MONTH');
INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('200540002', '4', '2015-04-01', '2015-04-30', 'MONTH');
INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('100540008', '6', '2015-01-01', '2015-07-31', 'SEMESTER');
INSERT INTO `newleasereq` (`snumber`, `reqloc1`, `startdate`, `enddate`, `paymentperiod`) VALUES ('100540009', '1', '2015-01-01', '2015-07-31', 'SEMESTER');

INSERT INTO `lease` (`snumber`, `hallLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('100540001', '1', 'SEMESTER', '2015-01-01', '2015-07-31', '1');
UPDATE `hallrooms` SET `snumber`='100540001' WHERE `hallLocation`='1';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='1' WHERE `reqid`='1';
INSERT INTO `parkingrequests` (`snumber`, `farok`, `classification`, `approved`, `pending`, `lreqid`) VALUES ('100540001', '1', 'Small Car', '1', '0', '1');
UPDATE `parkingspots` SET `snumber`='100540001' WHERE `spotnumber`='3';

INSERT INTO `lease` (`snumber`, `aptLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('100540002', '1', 'SEMESTER', '2015-01-01', '2015-7-31', '1');
UPDATE `appartmentrooms` SET `snumber`='100540002' WHERE `aptLocation`='1';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='2' WHERE `reqid`='2';
INSERT INTO `parkingrequests` (`snumber`, `farok`, `classification`, `approved`, `pending`, `lreqid`) VALUES ('100540002', '1', 'Small Car', '1', '0', '2');
UPDATE `parkingspots` SET `snumber`='100540002' WHERE `spotnumber`='13';

INSERT INTO `lease` (`snumber`, `hallLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('100540003', '2', 'MONTH', '2015-01-01', '2015-05-31', '1');
UPDATE `hallrooms` SET `snumber`='100540003' WHERE `hallLocation`='2';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='3' WHERE `reqid`='3';
INSERT INTO `parkingrequests` (`snumber`, `farok`, `classification`, `approved`, `pending`, `lreqid`) VALUES ('100540003', '1', 'Bike', '1', '0', '3');
UPDATE `parkingspots` SET `snumber`='100540003' WHERE `spotnumber`='2';

INSERT INTO `lease` (`snumber`, `hallLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('100540004', '3', 'MONTH', '2015-01-01', '2015-7-31', '1');
UPDATE `hallrooms` SET `snumber`='100540004' WHERE `hallLocation`='3';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='4' WHERE `reqid`='4';

INSERT INTO `lease` (`snumber`, `aptLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('100540005', '8', 'MONTH', '2015-01-01', '2015-7-31', '1');
UPDATE `appartmentrooms` SET `snumber`='100540005' WHERE `aptLocation`='8';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='5' WHERE `reqid`='5';
INSERT INTO `parkingrequests` (`snumber`, `farok`, `classification`, `approved`, `pending`, `lreqid`) VALUES ('100540005', '1', 'Large Car', '1', '0', '5');
UPDATE `parkingspots` SET `snumber`='100540005' WHERE `spotnumber`='27';

INSERT INTO `lease` (`snumber`, `aptLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('100540006', '9', 'SEMESTER', '2015-01-01', '2015-7-31', '1');
UPDATE `appartmentrooms` SET `snumber`='100540006' WHERE `aptLocation`='9';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='6' WHERE `reqid`='6';
INSERT INTO `parkingrequests` (`snumber`, `farok`, `classification`, `approved`, `pending`, `lreqid`) VALUES ('100540006', '1', 'Small Car', '1', '0', '6');
UPDATE `parkingspots` SET `snumber`='100540006' WHERE `spotnumber`='25';

INSERT INTO `lease` (`snumber`, `hallLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('100540007', '6', 'SEMESTER', '2015-01-01', '2015-7-31', '1');
UPDATE `hallrooms` SET `snumber`='100540007' WHERE `hallLocation`='6';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='7' WHERE `reqid`='7';
INSERT INTO `parkingrequests` (`snumber`, `farok`, `classification`, `approved`, `pending`, `lreqid`) VALUES ('100540007', '1', 'Small Car', '1', '0', '7');
UPDATE `parkingspots` SET `snumber`='100540007' WHERE `spotnumber`='7';

INSERT INTO `lease` (`snumber`, `aptLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('200540001', '4', 'MONTH', '2015-03-01', '2015-4-30', '1');
UPDATE `appartmentrooms` SET `snumber`='200540001' WHERE `aptLocation`='4';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='8' WHERE `reqid`='8';
INSERT INTO `parkingrequests` (`snumber`, `farok`, `classification`, `approved`, `pending`, `lreqid`) VALUES ('200540001', '1', 'Small Car', '1', '0', '8');
UPDATE `parkingspots` SET `snumber`='200540001' WHERE `spotnumber`='45';

INSERT INTO `lease` (`snumber`, `aptLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('200540002', '5', 'MONTH', '2015-04-01', '2015-4-30', '1');
UPDATE `appartmentrooms` SET `snumber`='200540002' WHERE `aptLocation`='5';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='9' WHERE `reqid`='9';

INSERT INTO `lease` (`snumber`, `aptLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('100540008', '17', 'SEMESTER', '2015-01-01', '2015-7-31', '1');
UPDATE `appartmentrooms` SET `snumber`='100540008' WHERE `aptLocation`='17';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='10' WHERE `reqid`='10';
INSERT INTO `parkingrequests` (`snumber`, `farok`, `classification`, `approved`, `pending`, `lreqid`) VALUES ('100540008', '1', 'Large Car', '1', '0', '10');
UPDATE `parkingspots` SET `snumber`='100540008' WHERE `spotnumber`='38';

INSERT INTO `lease` (`snumber`, `aptLocation`, `paymentperiod`, `startdate`, `enddate`, `active`) VALUES ('100540009', '18', 'SEMESTER', '2015-01-01', '2015-7-31', '1');
UPDATE `appartmentrooms` SET `snumber`='100540009' WHERE `aptLocation`='18';
UPDATE `newleasereq` SET `status`='IN PROGRESS', `staffnumber`='7', `leasenumber`='11' WHERE `reqid`='11';
INSERT INTO `parkingrequests` (`snumber`, `farok`, `classification`, `approved`, `pending`, `lreqid`) VALUES ('100540009', '1', 'Handicapped', '1', '0', '11');
UPDATE `parkingspots` SET `snumber`='100540009' WHERE `spotnumber`='1';

INSERT INTO `leaseterminaterequest` (`leasenumber`, `reason`, `enddate`) VALUES ('7', 'Database Blows', '2015-01-01');
INSERT INTO `leaseterminaterequest` (`leasenumber`, `reason`, `enddate`, `status`) VALUES ('6', 'Database Blows', '2015-01-01', 'PROCESSED');
