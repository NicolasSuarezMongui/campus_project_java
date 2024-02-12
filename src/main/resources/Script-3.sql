DELIMITER //
CREATE TRIGGER discount_capacity_signature
AFTER INSERT ON registers
FOR EACH ROW 
BEGIN 
	SET @capacity_signature = (SELECT s.capacity FROM signatures s WHERE s.signature_id = NEW.signature_id);
	IF @capacity_signature > 0 THEN
		UPDATE signature SET capacity = @capacity_signature - 
	ELSE
	END IF;
END; //
