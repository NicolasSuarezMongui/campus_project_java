DELIMITER //
CREATE TRIGGER validate_capacity_signature_classroom
BEFORE INSERT ON schedules
FOR EACH ROW
BEGIN
	SET @classroom_capacity = (SELECT classroom_capacity FROM classrooms c WHERE c.classroom_id = NEW.classroom_id);
	SET @signature_capacity = (SELECT capacity FROM signatures s WHERE s.signature_id = NEW.signature_id);
	IF @signature_capacity < 1 OR @signature > @classroom_capacity THEN 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Esta asignatura no puede ser asignada a este salón';
	END IF;
END; //

CREATE TRIGGER validate_level_classroom
BEFORE INSERT ON classrooms
FOR EACH ROW
BEGIN
	SET @building_levels = (SELECT building_leves FROM buildings b WHERE b.building_id = NEW.building_id);
	SET @classroom_level = NEW.classroom_level;
	IF @classroom_level < 1 OR @classroom_level> @building_levels THEN 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El número de piso asignado al salón no es válido';
	END IF;
END; //


CREATE TRIGGER validate_student_not_teacher
BEFORE INSERT ON students
FOR EACH ROW
BEGIN
	SET @insert_id = NEW.person_id;
	IF validate_id_teachers(@insert_id) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Un estudiante no puede ser profesor";
	END IF;
END; //

CREATE TRIGGER validate_teacher_not_student
BEFORE INSERT ON teachers
FOR EACH ROW
BEGIN
	SET @insert_id = NEW.person_id;
	IF validate_id_students(@insert_id) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Un profesor no puede ser estudiante";
	END IF;
END; //

CREATE TRIGGER validate_disponibility_schedule
BEFORE INSERT ON schedules
FOR EACH ROW
BEGIN 
	SET @class_day = NEW.schedule_day;
	SET @classroom = NEW.classroom_id;
	IF validate_classroom_day(@class_day, @classroom) THEN
		SET @current_start_time = NEW.start_time;
	    SET @duration = (SELECT s.duration FROM signatures s WHERE s.signature_id = NEW.signature_id);
		SET @current_end_time = ADDTIME(@current_start_time, @duration); 
		IF validate_class_time(@current_start_time, @current_end_time, NEW.classroom_id) THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No hay disponibilidad del salon.';
		END IF;
	END IF;
END; //

CREATE TRIGGER validate_disponibility_student
BEFORE INSERT ON registers
FOR EACH ROW 
BEGIN 
	SET @id_student = NEW.student_id;
	SET @id_signature = NEW.signature_id;

	IF NOT validate_student_signature(@id_student, @id_signature) THEN
		SET @new_time_start = (SELECT start_time FROM schedule s WHERE s.signature_id = @id_signature);
		SET @new_time_end = (SELECT end_time FROM schedule s WHERE s.signature_id = @id_signature);
		IF validate_student_schedule(@id_student, @new_time_start, @new_time_end) THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "No es posible ingresar esta materia por cruce";
		END IF;
	END IF;
END; //

CREATE TRIGGER validate_signature_in_schedule
BEFORE INSERT ON registers
FOR EACH ROW 
BEGIN 
	IF NOT validate_schedule_signature(NEW.signature_id) THEN 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "La asignatura no esta asociada a un salón";
	END IF;
END; //