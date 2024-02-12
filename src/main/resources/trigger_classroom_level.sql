DELIMITER //
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
