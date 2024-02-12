DELIMITER //
CREATE FUNCTION validate_id_teachers (new_id int)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
	RETURN (new_id IN (SELECT p.person_id FROM persons p INNER JOIN teachers t ON p.person_id = t.person_id));
END; //

CREATE FUNCTION validate_id_students (new_id int)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
	RETURN (new_id IN (SELECT p.person_id FROM persons p INNER JOIN students s ON p.person_id = s.person_id));
END; //


CREATE FUNCTION validate_classroom_day (class_day VARCHAR(10), current_classroom_id int)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
	RETURN (class_day IN (SELECT s.schedule_day  FROM schedules s INNER JOIN classrooms c ON c.classroom_id = current_classroom_id));
END; //

CREATE FUNCTION validate_class_time ( current_start_time TIME, current_end_time TIME, current_classroom_id int)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
	SET @validate_start = (SELECT 1 IN (SELECT current_start_time BETWEEN s.start_time AND s.end_time FROM schedules s WHERE s.classroom_id = current_classroom_id));
	SET @validate_end = (SELECT 1 IN (SELECT current_end_time BETWEEN s.start_time AND s.end_time FROM schedules s WHERE s.classroom_id = current_classroom_id));
	RETURN (@validate_start OR @validate_end);
END; //

CREATE FUNCTION validate_student_disponibility (current_time_start TIME, current_time_end TIME, schedule_start TIME, schedule_end TIME )
RETURNS BOOLEAN DETERMINISTIC
BEGIN
	SET @validate_start = (SELECT current_time_start BETWEEN schedule_start AND schedule_end);
	SET @validate_end = (SELECT current_time_end BETWEEN schedule_start AND schedule_end);
	RETURN (@validate_start OR @validate_end);
END; //

CREATE FUNCTION validate_student_signature (current_student INT, current_signature INT)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    DECLARE signature_count INT;
    
    SELECT COUNT(*) INTO signature_count
    FROM register r
    WHERE r.student_id = current_student AND r.signature_id = current_signature;
    
    RETURN (signature_count > 0);
END; //

CREATE FUNCTION validate_student_schedule (id_student INT, new_time_start TIME, new_time_end TIME)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
	RETURN (SELECT 1 IN (SELECT validate_student_disponibility(new_time_start,new_time_end,s2.start_time,s2.end_time) FROM registers r INNER JOIN signatures s ON r.signature_id = s.signature_id INNER JOIN schedules s2 ON s2.signature_id = s.signature_id WHERE r.student_id = id_student));
END; //

CREATE FUNCTION validate_schedule_signature (id_signature INT)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
	RETURN (SELECT id_signature IN (SELECT signture_id FROM schedules));
END; //
