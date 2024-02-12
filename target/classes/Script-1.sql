DELIMIMITER //
CREATE TRIGGER validate_students_disponibility
BEFORE INSERT ON register
FOR EACH ROW
BEGIN 
	SET @current_student_id = NEW.student_id;
	SET @current_signature_id = NEW.signature_id;
	
END; //
