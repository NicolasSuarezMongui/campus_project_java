DELIMITER //
CREATE TRIGGER validate_student_not_teacher
BEFORE INSERT ON students
FOR EACH ROW
BEGIN
	SET @insert_id = NEW.person_id;
	IF validate_id_teachers(@insert_id) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Un estudiante no puede ser profesor";
	END IF;
END; //
