DELIMITER //
CREATE TRIGGER validate_teacher_not_student
BEFORE INSERT ON teachers
FOR EACH ROW
BEGIN
	SET @insert_id = NEW.person_id;
	IF validate_id_students(@insert_id) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Un profesor no puede ser estudiante";
	END IF;
END; //