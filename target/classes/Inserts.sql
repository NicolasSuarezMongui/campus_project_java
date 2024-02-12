-- Script de población de la tabla City con 8 registros de Bucaramanga y su área metropolitana.
INSERT INTO cities (city_name) VALUES
('Bucaramanga'),
('Floridablanca'),
('Girón'),
('Piedecuesta'),
('Lebrija'),
('Rionegro'),
('Los Santos');

-- Script de población de la tabla Address con 20 registros de direcciones de Bucaramanga y su área metropolitana
INSERT INTO addresses (road, road_number, road_cross, road_dist) VALUES
(1, 12, 2, 23),
(1, 45, 24, 45),
(1, 78, 21, 36),
(1, 32, 10, 25),
(2, 65, 10, 10),
(2, 98, 15, 08),
(2, 12, 20, 72),
(2, 45, 22, 25),
(2, 79, 12, 32),
(2, 32, 21, 86),
(2, 65, 32, 142),
(2, 98, 21, 21),
(3, 12, 20, 17),
(3, 45, 19, 12),
(1, 78, 16, 68),
(1, 31, 12, 35),
(1, 64, 14, 42),
(1, 97, 13, 20),
(2, 13, 8, 16),
(2, 46, 3, 25);

-- Inserción de 5 registros de nombres reales
INSERT INTO buildings (building_name, building_levels) VALUES
('Torre del Este', 6),
('Edificio La Cumbre', 8),
('Torre Centenario', 5),
('Edificio El Pinar', 6),
('Torre del Norte', 5);

-- Inserción de 10 salones
INSERT INTO classrooms (building_id, classroom_level, classroom_capacity, classroom_code) VALUES
(1, 3, 30, 'S01'),
(1, 3, 20, 'S02'),
(2, 1, 25, 'S03'),
(2, 2, 50, 'S04'),
(2, 3, 40, 'S05'),
(2, 4, 30, 'S06'),
(3, 2, 15, 'S07'),
(3, 2, 20, 'S08');

-- Script de población de la tabla Person con 20 registros, 12 jóvenes y 8 adultos, y ciudades de residencia de Bucaramanga y su área metropolitana
INSERT INTO persons (document_type, document_numb, name, last_name, phone, birthdate, gender, city_id, address_id) VALUES
-- Personas jóvenes
('C.C', '123456789', 'Juan', 'Gomez', '3001234567', '2000-01-01', 1, 1, 1),
('T.I', '987654321', 'Maria', 'Rodriguez', '3012345678', '2001-02-02', 2, 2, 2), 
('C.C', '567890123', 'Carlos', 'Martinez', '3023456789', '2002-03-03', 1, 3, 3), 
('C.C', '345678901', 'Luisa', 'Lopez', '3034567890', '2003-04-04', 2, 4, 4), 
('T.I', '901234567', 'Andres', 'Hernandez', '3045678901', '2004-05-05', 1, 1, 5),
('C.C', '678901234', 'Camila', 'Perez', '3056789012', '2000-05-04', 2, 1, 6),
('T.I', '234567890', 'Santiago', 'Gonzalez', '3067890123', '2002-07-04', 1, 2, 7),
('C.C', '456789012', 'Valentina', 'Sanchez', '3078901234', '2000-11-08', 2, 2, 8),
('C.C', '789012345', 'Pedro', 'Ramirez', '3089012345', '2005-09-09', 1, 2, 9), 
('T.I', '012345678', 'Laura', 'Diaz', '3209876543', '2004-07-10', 2, 3, 10), 
('C.C', '543210987', 'Juan', 'Rodriguez', '3101234567', '204-08-11', 1, 4, 11),
('T.I', '098765432', 'Maria', 'Martinez', '3112345678', '2003-12-02', 2, 4, 12), 
-- Personas adultas
('C.C', '123756789', 'Carlos', 'Gomez', '3001234567', '1980-01-01', 1, 1, 13), 
('T.I', '987254321', 'Luisa', 'Rodriguez', '3012345678', '1975-02-02', 2, 2, 14), 
('C.C', '567490123', 'Andres', 'Martinez', '3023456789', '1970-03-03', 1, 2, 15),
('C.C', '345278901', 'Camila', 'Lopez', '3034567890', '1965-04-04', 2, 2, 16), 
('T.I', '901034567', 'Santiago', 'Hernandez', '3045678901', '1960-05-05', 1, 2, 17),
('C.C', '678001234', 'Valentina', 'Perez', '3056789012', '1955-06-06', 2, 4, 18), 
('T.I', '234067890', 'Pedro', 'Gonzalez', '3067890123', '1950-07-07', 1, 4, 19), 
('C.C', '456089012', 'Laura', 'Sanchez', '3078901234', '1945-08-08', 2, 3, 20);

-- Insertar datos de cursos
INSERT INTO courses (course_name, course_guide) VALUES
('Introducción a la Informática', 'https://ejemplo.com/guia1.txt'),
('Cálculo I', 'https://ejemplo.com/guia2.txt'),
('Derecho Civil', 'https://ejemplo.com/guia3.txt'),
('Química Orgánica', 'https://ejemplo.com/guia4.txt'),
('Literatura Española', 'https://ejemplo.com/guia5.txt'),
('Programación Avanzada', 'https://ejemplo.com/guia6.txt'),
('Economía Internacional', 'https://ejemplo.com/guia7.txt'),
('Historia del Arte', 'https://ejemplo.com/guia8.txt'),
('Física Cuántica', 'https://ejemplo.com/guia9.txt'),
('Psicología del Desarrollo', 'https://ejemplo.com/guia10.txt'),
('Inglés Avanzado', 'https://ejemplo.com/guia11.txt'),
('Biología Molecular', 'https://ejemplo.com/guia12.txt'),
('Derecho Penal', 'https://ejemplo.com/guia13.txt'),
('Análisis de Algoritmost', 'https://ejemplo.com/guia14.txt'),
('Microeconomía', 'https://ejemplo.com/guia15.txt');

-- Insertar datos de departamentos
INSERT INTO departments (department_name) VALUES
('Departamento de Informática'),
('Departamento de Matemáticas'),
('Departamento de Derecho'),
('Departamento de Química'),
('Departamento de Literatura'),
('Departamento de Ingeniería'),
('Departamento de Economía'),
('Departamento de Historia del Arte'),
('Departamento de Física'),
('Departamento de Psicología'),
('Departamento de Idiomas'),
('Departamento de Biología');

-- Insertar Profesores
INSERT INTO teachers (person_id, department_id) VALUES
(13, 1),
(14, 1),
(15, 2),
(16, 2),
(17, 2),
(18, 3),
(19, 4),
(20, 5);

-- Insertar datos de programas de pregrado
INSERT INTO programs (program_name) VALUES
('Ingeniería Informática'),
('Administración de Empresas'),
('Psicología'),
('Arquitectura'),
('Medicina'),
('Derecho'),
('Ciencias de la Computación'),
('Economía'),
('Ingeniería Civil');

-- Insertar Estudiantes asociados a programas.  
INSERT INTO students (person_id, program_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 2),
(6, 3),
(7, 4),
(8, 5),
(9, 2),
(10, 3),
(11, 4),
(12, 5);

-- Insert Periodos
INSERT INTO periods (period_year, semester, period_code) VALUES
(2022, 1, 'P22-01'),
(2022, 2, 'P22-02'),
(2023, 1, 'P23-01'),
(2023, 2, 'P23-02');


-- Crear Subjects
INSERT INTO signatures (credits, capacity, duration, teacher_id, course_id, period_id, name) VALUES
(3, 20, 0, 1, 1, 1, 'C1-PER1-Introducción a la Informática'),
(1, 25, 0, 4, 5, 1, 'C5-PER1-Literatura Española'),
(1, 25, 0, 4, 6, 1, 'C6-PER1-Programación Avanzada'),
(2, 35, 0, 2, 2, 2, 'C2-PER2-Cálculo I'),
(2, 35, 0, 2, 6, 2, 'C6-PER2-Programación Avanzada'),
(3, 20, 0, 3, 3, 3, 'C3-PER3-Derecho Civil'),
(2, 35, 0, 1, 3, 3, 'C3-PER3-Derecho Civil'),
(1, 10, 0, 2, 4, 3, 'C4-PER3-Química Orgánica'),
(1, 25, 0, 4, 5, 3, 'C5-PER3-Literatura Española');

-- Insert Fares
INSERT INTO tuitions (period_id, program_id, credit_cost) VALUES
(1, 1, 150000), (1, 2, 100000), (1, 3, 120000), (1, 4, 110000),
(1, 5, 180000), (1, 6, 160000), (1, 7, 80000), (1, 8, 250000),
(2, 1, 180000), (2, 2, 120000), (2, 3, 140000), (2, 4, 160000),
(2, 5, 210000), (2, 6, 190000), (2, 7, 110000), (2, 8, 290000),
(3, 1, 200000), (3, 2, 160000), (3, 3, 180000), (3, 4, 200000),
(3, 5, 250000), (3, 6, 220000), (3, 7, 150000), (3, 8, 320000);

INSERT INTO schedules (schedule_day, start_time, end_time, classroom_id, signature_id) VALUES
(1, '09:00:00', '11:00:00', 1, 1),
(2, '13:00:00', '15:00:00', 3, 3),
(3, '18:00:00', '20:00:00', 4, 5),
(4, '08:00:00', '10:00:00', 7, 5),
(5, '06:00:00', '08:00:00', 8, 6);


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
