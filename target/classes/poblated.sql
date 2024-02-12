INSERT INTO addresses(road, road_number, road_cross, road_dist) VALUES ('Calle', 13, 28, 22);
INSERT INTO cities(city_name) VALUES ('Bucaramanga');
INSERT INTO persons(document_type,document_numb,name,last_name, phone, birthdate, gender, address_id,city_id) VALUES ('C.C','1054682974','Nicolas','Suarez','3026816959','1998/02/08','M',1,1);
INSERT INTO persons(document_type,document_numb,name,last_name, phone, birthdate, gender, address_id,city_id) VALUES ('C.C', '23495425','Gladys','Mongui','3123249371','1957/12/31','F',1,1);
INSERT INTO departments(department_name) VALUES ('ciencias basicas');
INSERT INTO teachers(person_id,department_id) VALUES (2, 1);
INSERT INTO programs(program_name) VALUES ('Ingenieria de sistemas'); 
INSERT INTO courses(course_name, course_guide) VALUES ('matematicas','Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolores harum iusto natus cupiditate rem sunt accusamus commodi quis magni esse molestias doloribus inventore nulla veniam minima labore, quisquam, repellendus neque!');
INSERT INTO buildings(building_name, building_levels) VALUES ('Camilo Torres',5);
INSERT INTO classrooms(classroom_capacity,classroom_level,classroom_code,building_id) VALUES (20,4,'CT-401',1);
INSERT INTO periods(period_year,semester,period_code) VALUES (2024,'01','P24-01');
INSERT INTO tuitions(credit_cost,program_id,period_id) VALUES (1000000, 1,1);
INSERT INTO signatures(credits,capacity,duration,name,teacher_id,course_id,period_id) VALUES (3,20,2,'PR01-C01-PER-01-MATEMATICAS',2,1,1);
INSERT INTO students(person_id,program_id) VALUES (1,1);
INSERT INTO registers(student_id,period_id,signature_id) VALUES (1,1,4);
INSERT INTO schedules(schedule_day,start_time,classroom_id,signature_id) VALUES ('Lunes','08:00:00',1,4);
INSERT INTO classrooms(classroom_capacity,classroom_level,classroom_code,building_id) VALUES (20,6,'CT-501',1);
INSERT INTO signatures(credits,capacity,duration,name,teacher_id,course_id,period_id) VALUES (3,30,2,'PR01-C01-PER-01-MATEMATICAS',2,1,1);
INSERT INTO schedules(schedule_day,start_time,classroom_id,signature_id) VALUES ('Lunes','14:00:00',1,4);
INSERT INTO students(person_id,program_id) VALUES (2,1);
INSERT INTO teachers(person_id,department_id) VALUES (1,1);
INSERT INTO schedules(schedule_day,start_time,classroom_id,signature_id) VALUES ('Lunes', '09:00:00',1,4);

INSERT INTO schedules (schedule_day, start_time, end_time,classroom_id, signature_id) VALUES ('Martes', '10:00:00','12:00:00', 1, 4);
INSERT INTO schedules (schedule_day, start_time, end_time,classroom_id, signature_id) VALUES ('Martes', '09:00:00','11:00:00', 1, 4);
INSERT INTO schedules (schedule_day, start_time, end_time,classroom_id, signature_id) VALUES ('Martes', '09:00:00','11:00:00', 1, 4);
INSERT INTO schedules (schedule_day, start_time, end_time,classroom_id, signature_id) VALUES ('Martes', '11:00:00','13:00:00', 1, 4);

INSERT INTO teachers (person_id,department_id) VALUES (18,1);

INSERT INTO university.registers(student_id, period_id, signature_id) VALUES
(1, 1, 1),
(1, 1, 2),
(1, 1, 3),
(2, 1, 1),
(2, 1, 2),
(2, 1, 3),
(3, 1, 1),
(3, 1, 2),
(4, 1, 1),
(4, 1, 2),
(1, 2, 4),
(1, 2, 5),
(2, 2, 4),
(2, 2, 5),
(5, 2, 4),
(5, 2, 5),
(6, 2, 4),
(6, 2, 5),
(3, 2, 4),
(3, 2, 5),
(4, 2, 4),
(4, 2, 5),
(7, 3, 6),
(7, 3, 7),
(7, 3, 8),
(7, 3, 9),
(8, 3, 7),
(8, 3, 8),
(8, 3, 9),
(9, 3, 7),
(9, 3, 8),
(9, 3, 9);