SELECT validate_student_disponibility("09:00:00","11:00:00",) FROM registers r 

SELECT validate_student_disponibility("09:00:00","11:00:00",s2.start_time,s2.end_time) FROM registers r INNER JOIN signatures s ON r.signature_id = s.signature_id INNER JOIN schedules s2 ON s2.signature_id = s.signature_id WHERE r.student_id = 1;