DELIMITER //
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
