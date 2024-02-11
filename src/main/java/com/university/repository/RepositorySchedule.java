package com.university.repository;

import java.util.List;

import com.university.repository.models.Schedule;

public interface RepositorySchedule {
    
    List<Schedule> toList();

    Schedule findById(int schedule_id);

    void create(Schedule schedule);

    void update(Schedule schedule);

    List<Schedule> toListByStudentId(int student_id);

    List<Schedule> toListByTeacherId(int teacher_id);

    List<Schedule> toListBySignatureId(int signature_id);

    List<Schedule> toListByClassroomId(int classroom_id);

    List<Schedule> toListByDay(String day);

}
