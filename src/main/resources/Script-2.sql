DELIMITER //
CREATE TRIGGER end_time_schedule
AFTER INSERT ON schedules
FOR EACH ROW 
BEGIN 
	SET @current_start_time = NEW.start_time;
    SET @duration = (SELECT s.duration FROM signatures s WHERE s.signature_id = NEW.signature_id);
	SET @current_end_time = ADDTIME(@current_start_time, @duration);
	INSERT INTO schedules(end_time) VALUES (@current_end_time);
END; //
