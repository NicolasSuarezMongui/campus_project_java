DELIMITER //
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
