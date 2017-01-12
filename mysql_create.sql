CREATE TABLE `Trip` (
	`trip_id` INT NOT NULL,
	`station_from_id` INT NOT NULL,
	`station_to_id` INT NOT NULL,
	`date_from` DATE NOT NULL,
	`date_to` DATE NOT NULL,
	`time_from` TIME NOT NULL,
	`time_to` TIME NOT NULL,
	`service` BOOLEAN NOT NULL,
	PRIMARY KEY (`trip_id`)
);

CREATE TABLE `User` (
	`user_id` INT NOT NULL,
	`role_id` INT NOT NULL,
	`login` varchar(12) NOT NULL,
	`password` varchar(64) NOT NULL,
	`purse_id` INT NOT NULL,
	`ticket_id` INT NOT NULL,
	`locale_id` INT NOT NULL,
	PRIMARY KEY (`user_id`)
);

CREATE TABLE `Train` (
	`train_id` INT NOT NULL,
	`train_type_id` INT NOT NULL,
	`code` varchar(5) NOT NULL,
	`train_table_id` INT NOT NULL,
	`route_id` INT NOT NULL,
	PRIMARY KEY (`train_id`)
);

CREATE TABLE `Carriage` (
	`carriage_id` INT NOT NULL,
	`carriage_type_id` INT NOT NULL,
	`train_id` INT NOT NULL,
	`seat_amount` INT NOT NULL,
	`carriage_number` INT NOT NULL,
	PRIMARY KEY (`carriage_id`)
);

CREATE TABLE `Seat` (
	`seat_id` INT NOT NULL,
	`seat_number` INT NOT NULL,
	`carriage_id` INT NOT NULL,
	`seat_type_id` INT NOT NULL,
	`occupied` BOOLEAN NOT NULL,
	PRIMARY KEY (`seat_id`)
);

CREATE TABLE `Train_type` (
	`train_type_id` INT NOT NULL,
	`train_type_name_en` varchar(15) NOT NULL,
	`train_type_name_ru` varchar(15) NOT NULL,
	PRIMARY KEY (`train_type_id`)
);

CREATE TABLE `Carriage_type` (
	`carriage_type_id` INT NOT NULL,
	`carriage_type_name_en` varchar(15) NOT NULL,
	`carriage_type_name_ru` varchar(15) NOT NULL,
	PRIMARY KEY (`carriage_type_id`)
);

CREATE TABLE `Ticket` (
	`ticket_id` INT NOT NULL,
	`trip_id` INT NOT NULL,
	`first_name` varchar(16) NOT NULL,
	`last_name` varchar(20) NOT NULL,
	`document_number` INT NOT NULL,
	`train_id` INT NOT NULL,
	`carriage_id` INT NOT NULL,
	`seat_id` INT NOT NULL,
	`user_id` INT NOT NULL,
	`cost` INT NOT NULL,
	PRIMARY KEY (`ticket_id`)
);

CREATE TABLE `Locality` (
	`locality_id` INT NOT NULL,
	`locality_name_en` varchar(25) NOT NULL,
	`locality_name_ru` varchar(25) NOT NULL,
	PRIMARY KEY (`locality_id`)
);

CREATE TABLE `Station` (
	`station_id` INT NOT NULL,
	`locality_id` INT NOT NULL,
	`station_name_en` varchar(25) NOT NULL,
	`station_name_ru` varchar(25) NOT NULL,
	PRIMARY KEY (`station_id`)
);

CREATE TABLE `Train-table` (
	`train_table_id` INT NOT NULL,
	`route_id` INT NOT NULL,
	`station_id` INT NOT NULL,
	`date_in` DATE NOT NULL,
	`time_in` TIME NOT NULL,
	`stop` INT NOT NULL,
	`date_off` DATE NOT NULL,
	`time_off` TIME NOT NULL,
	`train_id` INT NOT NULL,
	PRIMARY KEY (`train_table_id`)
);

CREATE TABLE `Route` (
	`route_id` INT NOT NULL,
	`route_name_en` varchar(30) NOT NULL,
	`base_cost` INT NOT NULL,
	`route_station_id` INT NOT NULL,
	`route_name_ru` varchar(30) NOT NULL,
	PRIMARY KEY (`route_id`)
);

CREATE TABLE `Route_station` (
	`route_station_id` INT NOT NULL,
	`route_id` INT NOT NULL,
	`station_id` INT NOT NULL,
	`coefficient` INT NOT NULL,
	PRIMARY KEY (`route_station_id`)
);

CREATE TABLE `Purse` (
	`purse_id` INT NOT NULL,
	`purse_amount` INT NOT NULL,
	`currency_id` INT NOT NULL,
	`user_id` INT NOT NULL,
	PRIMARY KEY (`purse_id`)
);

CREATE TABLE `Currency` (
	`currency_id` INT NOT NULL,
	`currency_name` varchar(15) NOT NULL,
	PRIMARY KEY (`currency_id`)
);

CREATE TABLE `Seat_type` (
	`seat_type_id` INT NOT NULL,
	`seat_type_name_en` varchar(15) NOT NULL,
	`seat_type_name_ru` varchar(15) NOT NULL,
	PRIMARY KEY (`seat_type_id`)
);

CREATE TABLE `Role` (
	`role_id` INT NOT NULL,
	`role_name` varchar(20) NOT NULL,
	PRIMARY KEY (`role_id`)
);

CREATE TABLE `Locale` (
	`locale_id` INT NOT NULL,
	`locale_name` varchar(2) NOT NULL,
	PRIMARY KEY (`locale_id`)
);

ALTER TABLE `Trip` ADD CONSTRAINT `Trip_fk0` FOREIGN KEY (`station_from_id`) REFERENCES `Station`(`station_id`);

ALTER TABLE `Trip` ADD CONSTRAINT `Trip_fk1` FOREIGN KEY (`station_to_id`) REFERENCES `Station`(`station_id`);

ALTER TABLE `User` ADD CONSTRAINT `User_fk0` FOREIGN KEY (`role_id`) REFERENCES `Role`(`role_id`);

ALTER TABLE `User` ADD CONSTRAINT `User_fk1` FOREIGN KEY (`purse_id`) REFERENCES `Purse`(`purse_id`);

ALTER TABLE `User` ADD CONSTRAINT `User_fk2` FOREIGN KEY (`ticket_id`) REFERENCES `Ticket`(`ticket_id`);

ALTER TABLE `User` ADD CONSTRAINT `User_fk3` FOREIGN KEY (`locale_id`) REFERENCES `Locale`(`locale_id`);

ALTER TABLE `Train` ADD CONSTRAINT `Train_fk0` FOREIGN KEY (`train_type_id`) REFERENCES `Train_type`(`train_type_id`);

ALTER TABLE `Train` ADD CONSTRAINT `Train_fk1` FOREIGN KEY (`train_table_id`) REFERENCES `Train-table`(`train_table_id`);

ALTER TABLE `Train` ADD CONSTRAINT `Train_fk2` FOREIGN KEY (`route_id`) REFERENCES `Route`(`route_id`);

ALTER TABLE `Carriage` ADD CONSTRAINT `Carriage_fk0` FOREIGN KEY (`carriage_type_id`) REFERENCES `Carriage_type`(`carriage_type_id`);

ALTER TABLE `Carriage` ADD CONSTRAINT `Carriage_fk1` FOREIGN KEY (`train_id`) REFERENCES `Train`(`train_id`);

ALTER TABLE `Seat` ADD CONSTRAINT `Seat_fk0` FOREIGN KEY (`carriage_id`) REFERENCES `Carriage`(`carriage_id`);

ALTER TABLE `Seat` ADD CONSTRAINT `Seat_fk1` FOREIGN KEY (`seat_type_id`) REFERENCES `Seat_type`(`seat_type_id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk0` FOREIGN KEY (`trip_id`) REFERENCES `Trip`(`trip_id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk1` FOREIGN KEY (`train_id`) REFERENCES `Train`(`train_id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk2` FOREIGN KEY (`carriage_id`) REFERENCES `Carriage`(`carriage_id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk3` FOREIGN KEY (`seat_id`) REFERENCES `Seat`(`seat_id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk4` FOREIGN KEY (`user_id`) REFERENCES `User`(`user_id`);

ALTER TABLE `Station` ADD CONSTRAINT `Station_fk0` FOREIGN KEY (`locality_id`) REFERENCES `Locality`(`locality_id`);

ALTER TABLE `Train-table` ADD CONSTRAINT `Train-table_fk0` FOREIGN KEY (`route_id`) REFERENCES `Route`(`route_id`);

ALTER TABLE `Train-table` ADD CONSTRAINT `Train-table_fk1` FOREIGN KEY (`station_id`) REFERENCES `Station`(`station_id`);

ALTER TABLE `Train-table` ADD CONSTRAINT `Train-table_fk2` FOREIGN KEY (`train_id`) REFERENCES `Train`(`train_id`);

ALTER TABLE `Route` ADD CONSTRAINT `Route_fk0` FOREIGN KEY (`route_station_id`) REFERENCES `Route_station`(`route_station_id`);

ALTER TABLE `Route_station` ADD CONSTRAINT `Route_station_fk0` FOREIGN KEY (`route_id`) REFERENCES `Route`(`route_id`);

ALTER TABLE `Route_station` ADD CONSTRAINT `Route_station_fk1` FOREIGN KEY (`station_id`) REFERENCES `Station`(`station_id`);

ALTER TABLE `Purse` ADD CONSTRAINT `Purse_fk0` FOREIGN KEY (`currency_id`) REFERENCES `Currency`(`currency_id`);

ALTER TABLE `Purse` ADD CONSTRAINT `Purse_fk1` FOREIGN KEY (`user_id`) REFERENCES `User`(`user_id`);
