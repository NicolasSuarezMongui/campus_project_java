CREATE DATABASE IF NOT EXISTS university;
USE university;
CREATE TABLE IF NOT EXISTS addresses (
	address_id int NOT NULL AUTO_INCREMENT,
	road ENUM('Calle','Carrera','Transversal') NOT NULL,
	road_number int NOT NULL,
	road_cross int NOT NULL,
	road_dist int NOT NULL,
	PRIMARY KEY (address_id)
);

CREATE TABLE IF NOT EXISTS cities (
	city_id int NOT NULL AUTO_INCREMENT,
	city_name VARCHAR(50) NOT NULL,
	PRIMARY KEY (city_id)
);

CREATE TABLE IF NOT EXISTS departments (
	department_id int NOT NULL AUTO_INCREMENT,
	department_name VARCHAR(80) NOT NULL,
	PRIMARY KEY (department_id)
);

CREATE TABLE IF NOT EXISTS persons (
	person_id int NOT NULL AUTO_INCREMENT,
	document_type ENUM("C.C", "T.I") NOT NULL,
	document_numb VARCHAR(10) NOT NULL UNIQUE,	
	name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	phone VARCHAR(10) NOT NULL,
	birthdate DATE NOT NULL,
	gender ENUM("M","F"),
	address_id int,
	city_id int,
	PRIMARY KEY (person_id),
	FOREIGN KEY (address_id) REFERENCES addresses (address_id),
	FOREIGN KEY (city_id) REFERENCES cities (city_id)
);

CREATE TABLE IF NOT EXISTS teachers (
	teacher_id int NOT NULL AUTO_INCREMENT,
	person_id int,
	department_id int,
	PRIMARY KEY (teacher_id),
	FOREIGN KEY (person_id) REFERENCES persons (person_id),
	FOREIGN KEY (department_id) REFERENCES departments (department_id)
);

CREATE TABLE IF NOT EXISTS courses (
	course_id int NOT NULL AUTO_INCREMENT,
	course_name VARCHAR(30) NOT NULL,
	course_guide TEXT,
	PRIMARY KEY (course_id)
);

CREATE TABLE IF NOT EXISTS periods (
	period_id int NOT NULL AUTO_INCREMENT,
	period_year YEAR NOT NULL,
	semester ENUM('01','02') NOT NULL,
	period_code VARCHAR(6),
	PRIMARY KEY (period_id)
);

CREATE TABLE IF NOT EXISTS programs (
	program_id int NOT NULL AUTO_INCREMENT,
	program_name VARCHAR(50) NOT NULL,
	program_level ENUM('pregrado', 'postgrado') NOT NULL,
	PRIMARY KEY (program_id)
);

CREATE TABLE IF NOT EXISTS students (
	student_id int AUTO_INCREMENT,
	person_id int,
	program_id int,
	PRIMARY KEY (student_id),
	FOREIGN KEY (person_id) REFERENCES persons (person_id),
	FOREIGN KEY (program_id) REFERENCES programs (program_id)
);

CREATE TABLE IF NOT EXISTS tuitions (
	tuition_id int AUTO_INCREMENT,
	credit_cost double NOT NULL,
	program_id int,
	period_id int,
	PRIMARY KEY (tuition_id),
	FOREIGN KEY (program_id) REFERENCES programs (program_id),
	FOREIGN KEY (period_id) REFERENCES periods (period_id)
);

CREATE TABLE IF NOT EXISTS buildings (
	building_id int AUTO_INCREMENT,
	building_name VARCHAR(30) NOT NULL,
	building_levels int NOT NULL,
	PRIMARY KEY (building_id)
);

CREATE TABLE IF NOT EXISTS classrooms (
	classroom_id int AUTO_INCREMENT,
	classroom_capacity int NOT NULL,
	classroom_level int NOT NULL,
	classroom_code VARCHAR(10),
	building_id int,
	PRIMARY KEY (classroom_id),
	FOREIGN KEY (building_id) REFERENCES buildings (building_id)
);

CREATE TABLE IF NOT EXISTS signatures (
	signature_id int AUTO_INCREMENT,
	credits int NOT NULL,
	capacity int NOT NULL,
	duration int NOT NULL,
	name VARCHAR(60) NOT NULL,
	teacher_id int,
	course_id int,
	period_id int,
	PRIMARY KEY (signature_id),
	FOREIGN KEY (teacher_id) REFERENCES teachers (teacher_id),
	FOREIGN KEY (course_id) REFERENCES courses (course_id),
	FOREIGN KEY (period_id) REFERENCES periods (period_id)
);

CREATE TABLE IF NOT EXISTS registers (
	register_id int AUTO_INCREMENT,
	student_id int,
	period_id int,
	signature_id int,
	PRIMARY KEY (register_id),
	FOREIGN KEY (student_id) REFERENCES students (student_id),
	FOREIGN KEY (period_id) REFERENCES periods (period_id),
	FOREIGN KEY (signature_id) REFERENCES signatures (signature_id)
);

CREATE TABLE IF NOT EXISTS schedules (
	schedule_id int AUTO_INCREMENT,
	schedule_day ENUM ('Lunes','Martes','Miercoles','Jueves','Viernes') NOT NULL,
	start_time TIME NOT NULL,
	end_time TIME,
	classroom_id int,
	signature_id int,
	PRIMARY KEY (schedule_id),
	FOREIGN KEY (classroom_id) REFERENCES classrooms (classroom_id),
	FOREIGN KEY (signature_id) REFERENCES signatures (signature_id)
);


ALTER TABLE periods ADD UNIQUE (period_year, semester);
ALTER TABLE registers ADD UNIQUE (period_id, student_id, signature_id);

