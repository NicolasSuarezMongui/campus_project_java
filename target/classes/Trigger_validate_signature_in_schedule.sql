DELIMITER //
CREATE TRIGGER validate_signature_in_schedule
BEFORE INSERT ON registers
FOR EACH ROW 
BEGIN 
	IF NOT validate_schedule_signature(NEW.signature_id) THEN 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "La asignatura no esta asociada a un salón";
	END IF;
END; //
