package com.university.services;

import java.util.List;

import com.university.exceptions.scheduleexceptions.ScheduleNullException;
import com.university.repository.models.Schedule;

public interface ServiceSchedule {
    
    List<Schedule> toList();

    Schedule findById(int schedule_id) throws ScheduleNullException;

    void create(Schedule schedule);

    void update(Schedule schedule);

    List<Schedule> toListByStudentId(int student_id);

    List<Schedule> toListByTeacherId(int teacher_id);

    List<Schedule> toListBySignatureId(int signature_id);

    List<Schedule> toListByClassroomId(int classroom_id);

    List<Schedule> toListByDay(String day);

}
