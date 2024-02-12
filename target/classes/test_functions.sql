DELIMITER //
CREATE FUNCTION validate_schedule_signature (id_signature INT)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
	RETURN (SELECT id_signature IN (SELECT signture_id FROM schedules));
END; //
