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
